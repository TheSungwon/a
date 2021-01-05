package DAO;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

import sequence_board.Sequencer;


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
		Statement st = null; //새로운 글의 그룹번호를 구할때
		ResultSet rs = null;
		
		PreparedStatement ps = null;  //특정 답글에 대한 순서를 구할 때 
		ResultSet rs2 = null;
		PreparedStatement ps2 = null;
		
		PreparedStatement psMessage = null;
		PreparedStatement psContent = null; //글 삽입 할 때
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			
			if(theme.getParentId() == 0) {
				//처음 쓰는글 //답글이 아닌 경우 그룹번호를 새롭게 구한다
				st = conn.createStatement();
				rs = st.executeQuery("select max(group_id) from theme_message"); //groupId최댓값 가져오기
				int maxGroupId = 0;
				if(rs.next()) {
					maxGroupId = rs.getInt(1);
				}
				maxGroupId++;
				
				theme.setGroupId(maxGroupId);
				theme.setOrderNo(0);
			}else {
				//0이 아니라면 답변글//특정 글의 답글인 경우// 같은 그룹번호 내에서 출력순서 구한다
				
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
			
			//특정 글의 답변 글인 경우 같은 그룹내에서 순서번호를 정한다
			if(theme.getOrderNo() >0) { //답변글이라면
				ps2 = conn.prepareStatement("update theme_message set order_no = order_no+1 where group_id=? and order_no=?");
				
				ps2.setInt(1, theme.getGroupId());
				ps2.setInt(2, theme.getOrderNo());
				ps2.executeUpdate();
			}
			
			//새로운 글의 번호 구하기
			theme.setId(Sequencer.nextId(conn, "theme_message"));
			
			//글 삽입
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
			
			psContent = conn.prepareStatement("insert into theme_content values(?,?)");// 글내용
			psContent.setInt(1, theme.getId());
			psContent.setCharacterStream(2, new StringReader(theme.getContent()),theme.getContent().length());
			//long형이므로 String으로 넣을수없음
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
			if(conn != null) 
				try {
					conn.setAutoCommit(false);
					conn.close();
				}catch(SQLException e) {}
			}
		}
		
		
		//제목과 내용만 변경
		public void update(Theme theme)throws Exception{
			Connection conn = null;
			PreparedStatement psMessage = null;
			PreparedStatement psContent = null;
			
			try {
				conn = getConnection();
				conn.setAutoCommit(false);
				
				psMessage = conn.prepareStatement("update theme_message set name=?, email=?, image=?, title=? where theme_messge_id=?");//테이블1
				psContent = conn.prepareStatement("update theme_content set content=? where theme_message_id=?"); //테이블2
				
				psMessage.setString(1, theme.getName());
				psMessage.setString(2, theme.getEmail());
				psMessage.setString(3, theme.getImage());
				psMessage.setString(4, theme.getTitle());
				psMessage.setInt(5, theme.getId());
				psMessage.executeUpdate();
				
				psContent.setCharacterStream(1, new StringReader(theme.getContent()),theme.getContent().length());
				psContent.setInt(2, theme.getId());
				psContent.executeUpdate();
				
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
				if(conn !=null)
					try {
						conn.setAutoCommit(true);
						conn.close();
					}catch(SQLException e) {}
			}
		}
			
	
		
//////////
		//등록된 글의 갯수
		public int count(List whereCond, Map valueMap)throws Exception{
			if(valueMap == null)
				valueMap = Collections.EMPTY_MAP;
			
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				StringBuffer query = new StringBuffer(200);
				query.append("select count(*) from theme_message ");
				 
				if(whereCond != null && whereCond.size() >0) {
					query.append("where ");
					
					for(int i=0; i<whereCond.size(); i++) {
						query.append(whereCond.get(i));
						
						if(i<whereCond.size() -1) {
							query.append(" or "); //	//select count(*) from THEME_MESSAGE where name=? or subject=?
							
						}
					}
				}
				ps = conn.prepareStatement(query.toString());
				
				
				Iterator keyIter = valueMap.keySet().iterator();
				
				while(keyIter.hasNext()) {
					Integer key = (Integer)keyIter.next();
					Object obj = valueMap.get(key);
					
					if(obj instanceof String) {
						ps.setString(key.intValue(), (String)obj);
					}else if(obj instanceof Integer) {
						ps.setInt(key.intValue(), ((Integer)obj).intValue());
						
					}else if (obj instanceof Timestamp) {
						ps.setTimestamp(key.intValue(), (Timestamp)obj);
					}
				
				}
				rs = ps.executeQuery();
				int count = 0;
				if(rs.next()) {
					count = rs.getInt(1);
				}
				return count;
						
			}catch(SQLException e) {
				e.printStackTrace();
				throw new Exception("count", e);
			}finally {
				jdbcUtil.close(rs);
				jdbcUtil.close(ps);
				jdbcUtil.close(conn);
			}
		}
		
		
		
		
		//
		//목록을 읽어온다
		public List selectList(List whereCond, Map valueMap, int startRow, int endRow)throws Exception{
			if(valueMap == null)
				valueMap = Collections.EMPTY_MAP;
			
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				StringBuffer query = new StringBuffer(200);
				
				query.append("select * from ( ");
				query.append(" select theme_message_id, group_id, order_no, levels, parent_id, register, name, email, image, password, title, rownum rnum " );
				query.append(" from( " );
				query.append(" select theme_message_id, group_id, order_no, levels, parent_id, register, name, email, image, password, title " );
				query.append(" from theme_message ");
				
				if(whereCond != null && whereCond.size() >0) {
					query.append(" where ");
					
					for(int i =0; i<whereCond.size(); i++) {
						query.append(whereCond.get(i));
						if(i <whereCond.size() -1) {
							query.append(" or ");
						}
					}
				}
				
				query.append(" order by group_id desc, order_no asc ");
				query.append(" ) where rownum <=? ");
				query.append(" ) where rnum >=? ");
				
				conn=getConnection();
				
				ps = conn.prepareStatement(query.toString());
				Iterator keyIter = valueMap.keySet().iterator();
				while(keyIter.hasNext()) {
					Integer key = (Integer)keyIter.next();
					Object obj = valueMap.get(key);
					if(obj instanceof String) {
						ps.setString(key.intValue(), (String)obj);
					
					}else if(obj instanceof Integer) {
						ps.setInt(key.intValue(), ((Integer)obj).intValue());	
						
					}else if (obj instanceof Timestamp) {
						ps.setTimestamp(key.intValue(), (Timestamp)obj);
						
					
					}
				
				}
				
				ps.setInt(valueMap.size()+1, endRow+1);
				ps.setInt(valueMap.size()+2, startRow+1);
				
				rs = ps.executeQuery();
				if(rs.next()) {
					List list = new java.util.ArrayList(endRow - startRow+1);
					
					do {
						Theme theme = new Theme();
						theme.setId(rs.getInt("theme_message_id"));
						theme.setGroupId(rs.getInt("group_id"));
						theme.setOrderNo(rs.getInt("order_no"));
						theme.setLevels(rs.getInt("levels"));
						theme.setParentId(rs.getInt("parent_id"));
						theme.setRegister(rs.getTimestamp("register"));
						theme.setName(rs.getString("name"));
						theme.setEmail(rs.getString("email"));
						theme.setImage(rs.getString("image"));
						theme.setPassword(rs.getString("password"));
						theme.setTitle(rs.getString("title"));
						
						list.add(theme);
						
					}while(rs.next());
					return list;
				}else {
					return Collections.EMPTY_LIST;
				}
			}catch(SQLException e) {
				e.printStackTrace();
				throw new Exception("selectlist", e	);
			}finally {
				jdbcUtil.close(rs);
				jdbcUtil.close(ps);
				jdbcUtil.close(conn);
			}
		}
		
		
		
		
		
		//
		//지정한 글을 읽어온다
		public Theme select (int id) throws Exception{
			Connection conn = null;
			PreparedStatement psMessage = null;
			ResultSet rsMessage = null;
			
			PreparedStatement psContent = null;
			ResultSet rsContent = null;
			
			try {
				Theme theme = null;
				
				conn = getConnection();
				psMessage = conn.prepareStatement("select from theme_message where theme_message_id=?");
				
				psMessage.setInt(1, id);
				rsMessage = psMessage.executeQuery();
				
				if(rsMessage.next()) {
					theme = new Theme();
					theme.setId(rsMessage.getInt("theme_message_id"));
					theme.setGroupId(rsMessage.getInt("group_id"));
					theme.setOrderNo(rsMessage.getInt("order_no"));
					theme.setLevels(rsMessage.getInt("levels"));
					theme.setParentId(rsMessage.getInt("parent_id"));
					theme.setRegister(rsMessage.getTimestamp("register"));
					theme.setName(rsMessage.getString("name"));
					theme.setEmail(rsMessage.getString("email"));
					theme.setImage(rsMessage.getString("image"));
					theme.setPassword(rsMessage.getString("password"));
					theme.setTitle(rsMessage.getString("title"));
					
					psContent = conn.prepareStatement("select content from theme_content where theme_message_id = ?");
					psContent.setInt(1, id);
					rsContent = psContent.executeQuery();
					
					if(rsContent.next()) {
						Reader reader = null;
						try {
							reader = rsContent.getCharacterStream("content");
							char[] buff = new char[512];
							int len = -1;
							StringBuffer buffer = new StringBuffer(512);
							while( (len=reader.read(buff)) != -1) {
							buffer.append(buff,0,len);
							
							}
							theme.setContent(buffer.toString());
							
						}catch(IOException e	) {
							throw new Exception("select",e);
						}finally {
							if(reader != null)
								try {
									reader.close();
								}catch(IOException e) {}
						}
					}else {
						return null;
					}
					return theme;
					
				}else {
					return null;
				}
			}catch(SQLException e) {
				e.printStackTrace();
				throw new Exception("select", e);
			}finally {
				jdbcUtil.close(rsMessage);
				jdbcUtil.close(psMessage);
				jdbcUtil.close(rsContent);
				jdbcUtil.close(psContent);
			}
		}
		
		
////////////////////
		
		public void delete(int id)throws Exception{
			Connection conn = null;
			PreparedStatement psMessage = null;
			PreparedStatement psContent = null;
			
			try {
				conn = getConnection();
				conn.setAutoCommit(false);
				
				psMessage = conn.prepareStatement("delete from theme_message where theme_message_id = ?");
				
				psContent = conn.prepareStatement("delete from theme_content where theme_message_id = ?");
				
				psMessage.setInt(1, id);
				psContent.setInt(1, id);
				
				int upCount1 = psMessage.executeUpdate();
				int upCount2 = psContent.executeUpdate();
				
				if(upCount1 + upCount2 == 2) {
					conn.commit();
					
				}else {
					conn.rollback();
					throw new Exception("invalid id"+id);
				}

			}catch(SQLException e) {
				e.printStackTrace();
				try {
					conn.rollback();
				}catch(SQLException e1) {}
				throw new Exception("delete",e);
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
