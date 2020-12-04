<%@ page contentType="text/html; charset=euc-kr"%>

<%@ page import = "java.sql.DriverManager"%>
<%@ page import = "java.sql.Connection"%>
<%@ page import = "java.sql.PreparedStatement"%>
<%@ page import = "java.sql.SQLException"%>

<% request.setCharacterEncoding("euc-kr");

String id = request.getParameter("id");
String password = request.getParameter("password");
String name = request.getParameter("name");
String email = request.getParameter("email");

/* Class.forName("oracle.jdbc.driver.OracleDriver"); */

Connection conn = null;
PreparedStatement ps = null;

try{
	String jdbc="jdbc:oracle:thin:@localhost:1521:XE";
	String user="ezen";
	String pass="oracle";
	
	conn=DriverManager.getConnection(jdbc,user,pass);
	ps = conn.prepareStatement(
			"insert into member values(?,?,?,?)");
	ps.setString(1,id);
	ps.setString(2,password);
	ps.setString(3,name);
	ps.setString(4,email);
	
	ps.executeUpdate();
	
	}finally{
		if(ps !=null) try{ps.close();} catch(SQLException e){}
		if(conn !=null) try{conn.close();} catch(SQLException e){}
	}
%>

<html>
<head><title> insert</title></head>
<body> memeber table insert</body>
</html>