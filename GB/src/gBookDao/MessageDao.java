package gBookDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import gBook.Message;
import gBook.jdbcUtil;

//���̺����� crud������ �������ִ� �޼ҵ������ϴ� �߻�Ŭ����
//�� dbms�� �˸��� ������ �����ϴ� daoŬ������ messageDaoŬ������ ��ӹ޵��� ����

public abstract class MessageDao {
	public abstract int insert(Connection conn, Message message) throws SQLException;
	//���̺� �������߰��ϴ� insert���� �����ϴ� �޼���
	
	
	public Message select(Connection conn, int messageId) throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("select * from guestbook_message where message_id = ?");
			
			ps.setInt(1, messageId);
			rs = ps.executeQuery();
			if(rs.next()) {
				return makeMessageFromResultSet(rs);
			}else {
				return null;
			}
		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(ps);
		}//���̺��� ������ �ֿ�Ű�� �ش��ϴ� ���� �����͸� �о�� make~set�޼��带 ����ؼ�
	} //Message��ü�� �����ѵ� Message��ü�� ����. 
	
	
	protected Message makeMessageFromResultSet(ResultSet rs) throws SQLException{
		Message message = new Message();
		
		message.setId(rs.getInt("message_id"));
		message.setGuestName(rs.getString("guest_name"));
		message.setPassword(rs.getString("password"));
		message.setMessage(rs.getString("message"));
		return message;
	}//resultset���κ��� �����͸��о�� message��ü������� message��ü������
	
	public int selectCount(Connection conn) throws SQLException{
		Statement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.createStatement();
			rs = ps.executeQuery("select count(*) from guestbook_message");
			rs.next();
			return rs.getInt(1);
			
		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(ps);
		}//���̺� ����� ���� ������ ����
	}
	
	public abstract List<Message> selectList(Connection conn, int firstRow, int endRow)throws SQLException;
	//���̺�κ��� ������� ���࿡ �ش��ϴ� �޽�������� �о���� �޼���
	
	public int delete(Connection conn, int messageId)throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("delete from guestbook_message where message_id = ?");
			ps.setInt(1, messageId);
			return ps.executeUpdate();
			
		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(ps);
		}
	}//���̺��� ������ �ֿ�Ű�� �ش��ϴ� �����͸� �����ϴ� ���������ϰ� ���������� ���� ����

}
	