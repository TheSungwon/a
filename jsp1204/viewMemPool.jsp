<%@page contentType="text/html; charset=euc-kr"%>

<%@ page import= "java.sql.DriverManager"%>
<%@ page import= "java.sql.Connection"%>
<%@ page import = "java.sql.Statement"%>
<%@ page import = "java.sql.ResultSet"%>
<%@ page import = "java.sql.SQLException"%>
<html>
<head><title>È¸¿ø</title></head>
<body>
member table
<table width="100%" border="1">
<tr>
	<td>name</td><td>id</td><td>email</td>
</tr>

<%
Connection conn = null;
Statement st = null;
ResultSet rs = null;

try{
	String jdbc = "jdbc:apache:commons:dbcp:/connectionPool";
	String query = "select * from MEMBER order by MEMBERID";
	conn = DriverManager.getConnection(jdbc);
	st = conn.createStatement();
	rs= st.executeQuery(query);
	while(rs.next()){ %>
	<tr>
		<td><%=rs.getString("NAME") %></td>
		<td><%=rs.getString("MEMBERID") %></td>
		<td><%=rs.getString("EMAIL") %></td>
	</tr>
	<%
	}
}finally{
	if(rs != null)try{rs.close();} catch(SQLException e){}
	if(st != null)try{st.close();} catch(SQLException e){}
	if(conn != null)try{conn.close();} catch(SQLException e){}
}
	%>
	


</table>

</body>
</html>