<%@ page contentType="text/html; charset=euc-kr"%>
<%@ page import = "java.sql.DriverManager"%>
<%@ page import = "java.sql.Connection"%>
<%@ page import = "java.sql.Statement"%>
<%@ page import = "java.sql.SQLException"%>

<%
request.setCharacterEncoding("euc-kr");

String memberID=request.getParameter("memberID");
String name=request.getParameter("name");

int updateCount=0;

Class.forName("oracle.jdbc.driver.OracleDriver");

Connection conn = null;
Statement st = null;

try{
	String jdbcDriver = "jdbc:oracle:thin:@localhost:1521:XE";
	String dbUser = "ezen";
	String dbPass = "oracle";
	String query = "update MEMBER set NAME = '"+name+"' where MEMBERID = '"+memberID+"'";
	
	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
	st = conn.createStatement();
	updateCount = st.executeUpdate(query);
	}finally{
	if(st != null) try{st.close();} catch(SQLException e){}
	if(conn != null) try{conn.close();} catch(SQLException e){}
	} %>
	
	<html>
	<head><title> name update</title></head>
	<body>
	<%if (updateCount > 0 ){
		out.println(memberID+"의 이름을"+name+"변경");
		}else { out.println(memberID+"아이디가없음");} %>
	</body>
	</html>