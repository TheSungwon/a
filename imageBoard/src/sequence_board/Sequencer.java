package sequence_board;

//id_sequence테이블 관련 작업 처리하는 클래스


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC_PROVIDER.jdbcUtil;

public class Sequencer {
	
	public synchronized static int nextId(Connection conn, String tableName)throws SQLException{
		PreparedStatement ps  = null;
		ResultSet rs = null;
		
		PreparedStatement psUp = null;
		
		try {
			ps = conn.prepareStatement("select message_id from id_sequences where table_name=?");
			ps.setString(1, tableName);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt(1);
				id++;
				
				psUp = conn.prepareStatement("update id_sequences set message_id = ? where table_name=? ");
				psUp.setInt(1, id);
				psUp.setString(2, tableName);
				psUp.executeUpdate();
				
				return id;
			}else {
				psUp = conn.prepareStatement("insert into id_sequences values(?,?)");
				psUp.setString(1, tableName);
				psUp.setInt(2, 1);
				psUp.executeUpdate();
				
				return 1;
			}
		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(ps);
			jdbcUtil.close(psUp);
		}
	}

}
