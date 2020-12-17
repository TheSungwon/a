package gBookDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import gBook.Message;
import gBook.jdbcUtil;

//테이블에대한 crud쿼리를 실행해주는 메소드정의하는 추상클래스
//각 dbms에 알맞은 쿼리를 실행하는 dao클래스는 messageDao클래스를 상속받도록 구현

public abstract class MessageDao {
	public abstract int insert(Connection conn, Message message) throws SQLException;
	//테이블에 데이터추가하는 insert쿼리 수행하는 메서드
	
	
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
		}//테이블에서 지정한 주요키에 해당하는 행의 데이터를 읽어와 make~set메서드를 사용해서
	} //Message객체에 저장한뒤 Message객체를 리턴. 
	
	
	protected Message makeMessageFromResultSet(ResultSet rs) throws SQLException{
		Message message = new Message();
		
		message.setId(rs.getInt("message_id"));
		message.setGuestName(rs.getString("guest_name"));
		message.setPassword(rs.getString("password"));
		message.setMessage(rs.getString("message"));
		return message;
	}//resultset으로부터 데이터를읽어와 message객체에저장뒤 message객체를리턴
	
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
		}//테이블에 저장된 행의 개수를 리턴
	}
	
	public abstract List<Message> selectList(Connection conn, int firstRow, int endRow)throws SQLException;
	//테이블로부터 시작행과 끝행에 해당하는 메시지목록을 읽어오는 메서드
	
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
	}//테이블에서 지정한 주요키에 해당하는 데이터를 삭제하는 쿼리실행하고 삭제된행의 개수 리턴

}
	