package JDBC_PROVIDER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//drivermanager.getconnection����ȣ���ؼ�connection ��ü���ϱ⺸�ٴ�
//connection�� �������ִ� ����� ������ Ŭ������ �и����ֱ����� ����
public class ConnectionProvider {
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:apache:commons:dbcp:/connectionPool");
		
	}

}
