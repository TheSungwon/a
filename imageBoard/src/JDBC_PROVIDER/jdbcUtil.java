package JDBC_PROVIDER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcUtil {

	public static void close(ResultSet rs) { //rs���޾��ִ� �޼ҵ�//�޼ҵ�����ε�
		if(rs != null) {
			try {
				rs.close();
			}catch(SQLException e) {
				
			}
		}
		
	}
	
	public static void close(Statement st) {
		if(st != null) {
			try {
				
			st.close();
		}catch(SQLException e) {
			
		}
	}
}
	public static void close(PreparedStatement ps) {
		if(ps != null) {
			try {
				
			ps.close();
		}catch(SQLException e) {
			
		}
	}
}
	
	public static void close(Connection conn) {
		if(conn !=null) {
			try {
				conn.close();
			}catch(SQLException e) {
				
			}
		}
	}
	
	public static void rollback(Connection conn) {
		//Ʈ����� �� �� �����
		if(conn !=null) {
			try {
				conn.rollback();
				
			}catch(SQLException e) {
				
			}
		}
	}
}