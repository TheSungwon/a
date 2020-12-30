package JDBC_PROVIDER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//drivermanager.getconnection직접호출해서connection 객체구하기보다는
//connection을 제공해주는 기능을 별도의 클래스로 분리해주기위해 생성
public class ConnectionProvider {
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:apache:commons:dbcp:/connectionPool");
		
	}

}
