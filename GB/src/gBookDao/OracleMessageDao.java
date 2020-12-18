package gBookDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gBook.Message;
import gBook.jdbcUtil;

public class OracleMessageDao  extends MessageDao{		//오라클 쿼리 수행
	@Override
	public int insert(Connection conn, Message message) throws SQLException {
		PreparedStatement ps = null;
		
		try { ps = conn.prepareStatement( "insert into guestbook_message "
		+" (message_id,guest_name,password,message) "+" values(message_id_seq.NEXTVAL,?,?,?)");
		ps.setString(1, message.getGuestName());
		ps.setString(2, message.getPassword());
		ps.setString(3, message.getMessage());
		return ps.executeUpdate();
		
			
		}finally {
			jdbcUtil.close(ps);
		}

		
	}
	
	
@Override
	public List<Message> selectList(Connection conn, int firstRow, int endRow) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("select message_id,guest_name,password,message from ( "+
		" select rownum rnum, message_id,guest_name,password,message from ( "+
		" select * from guestbook_message m order by m.message_id desc "+
		" ) where rownum <= ? "+
		" ) where rnum >= ?");

			
			ps.setInt(1, endRow);
			ps.setInt(2, firstRow);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				List<Message> messageList = new ArrayList<Message>();
				do {
					messageList.add(super.makeMessageFromResultSet(rs));
				}while (rs.next());
				return messageList;
			}else {
				return Collections.emptyList();
						
			}
		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(ps);
		}
	
	}
}
