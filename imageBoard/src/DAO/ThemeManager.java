package DAO;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sound.midi.Sequencer;

import com.sun.net.httpserver.Authenticator.Result;

import DTO.Theme;
import JDBC_PROVIDER.jdbcUtil;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.SQLException;

import sequence_board.*;

public class ThemeManager {
	
	private static ThemeManager instance = new ThemeManager();
	public static ThemeManager getInstance() {
		return instance;
	}
	private ThemeManager() {}
	
	private Connection getConnection() throws Exception{
		return DriverManager.getConnection("jdbc:apach:commons:dbcp:/connectionPool");
		
	}
	
	public void insert(Theme theme)throws Exception{
		Connection conn = null;
		Statement st = null; //���ο� ���� �׷��ȣ�� ���Ҷ�
		ResultSet rs = null;
		
		PreparedStatement ps = null;  //Ư�� ��ۿ� ���� ������ ���� �� 
		ResultSet rs2 = null;
		PreparedStatement ps2 = null;
		
		PreparedStatement psMessage = null;
		PreparedStatement psContent = null; //�� ���� �� ��
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			
			if(theme.getParentId() == 0) {
				//ó�� ���±� //����� �ƴ� ��� �׷��ȣ�� ���Ӱ� ���Ѵ�
				st = conn.createStatement();
				rs = st.executeQuery("select max(group_id) from theme_message"); //groupId�ִ� ��������
				int maxGroupId = 0;
				if(rs.next()) {
					maxGroupId = rs.getInt(1);
				}
				maxGroupId++;
				
				theme.setGroupId(maxGroupId);
				theme.setOrderNo(0);
			}else {
				//0�� �ƴ϶�� �亯��//Ư�� ���� ����� ���// ���� �׷��ȣ ������ ��¼��� ���Ѵ�
				
				ps = conn.prepareStatement("select max(order_no) from theme_message where parent_id =? or theme_message_id=?");
				
				ps.setInt(1, theme.getParentId());
				ps.setInt(2, theme.getParentId());
				rs2 = ps.executeQuery();
				int maxOrder =0;
				if(rs2.next()) {
					maxOrder =rs2.getInt(1);
				}
				maxOrder++;
				
				theme.setOrderNo(maxOrder);
			}
			
			//Ư�� ���� �亯 ���� ��� ���� �׷쳻���� ������ȣ�� ���Ѵ�
			if(theme.getOrderNo() >0) { //�亯���̶��
				ps2 = conn.prepareStatement("update theme_message set order_no = order_no+1 where group_id=? and order_no=?");
				
				ps2.setInt(1, theme.getGroupId());
				ps2.setInt(2, theme.getOrderNo());
				ps2.executeUpdate();
			}
			
			//���ο� ���� ��ȣ ���ϱ�
			theme.setId(sequence_board.Sequencer.nextId(conn, "theme_message"));
			
			//�� ����
			psMessage = conn.prepareStatement("insert into theme_message values(?,?,?,?,?,?,?,?,?,?,?)");
			psMessage.setInt(1, theme.getId());
			psMessage.setInt(2, theme.getGroupId());
			psMessage.setInt(3, theme.getOrderNo());
			psMessage.setInt(4, theme.getLevels());
			psMessage.setInt(5, theme.getParentId());
			psMessage.setTimestamp(6, theme.getRegister());
			psMessage.setString(7, theme.getName());
			psMessage.setString(8, theme.getEmail());
			psMessage.setString(9, theme.getImage());
			psMessage.setString(10, theme.getPassword());
			psMessage.setString(11, theme.getTitle());
			psMessage.executeUpdate();
			
			psContent = conn.prepareStatement("insert into theme_content values(?,?)");// �۳���
			psContent.setInt(1, theme.getId());
			psContent.setCharacterStream(2, new StringReader(theme.getContent()),theme.getContent().length());
			//long���̹Ƿ� String���� ����������
			psContent.executeUpdate();
			
			conn.commit();
			
		}catch(SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(SQLException e1) {}
			throw new Exception("insert",e);
		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(st);
			jdbcUtil.close(ps);
			jdbcUtil.close(ps2);
			jdbcUtil.close(rs2);
			jdbcUtil.close(psMessage);
			jdbcUtil.close(psContent);
			if(conn != null) {
				try {
					conn.setAutoCommit(false);
					conn.close();
				}catch(SQLException e) {}
			}
		}
		
		
		//����� ���븸 ����
		public void update(Theme theme)throws Exception{
			Connection conn = null;
			PreparedStatement psMessage = null;
			PreparedStatement psContent = null;
		
			try {
				conn = getConnection();
				conn.setAutoCommit(false);
				
				psMessage = conn.prepareStatement("update theme_message set name=?, email=?, image=?, title=? where theme_messge_id=?");//���̺�1
				psContent = conn.prepareStatement("update theme_content set content=? where theme_message_id=?"); //���̺�2
				
				psMessage.setString(1, theme.getName());
				psMessage.setString(2, theme.getEmail());
				psMessage.setString(3, theme.getImage());
				psMessage.setString(4, theme.getTitle());
				psMessage.setInt(5, theme.getId());
				psMessage.executeUpdate();
				
				conn.commit();
				
				
			}catch(SQLException e) {
				e.printStackTrace();
				try {
					conn.rollback();
					
				}catch(SQLException e1) {}
				throw new Exception("update",e);
			}finally {
				jdbcUtil.close(psMessage);
				jdbcUtil.close(psContent);
				if(conn != null)
					try {
						conn.setAutoCommit(true);
						conn.close();
					}catch(SQLException e) {}
			}
			
		
	}

}
