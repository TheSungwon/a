<%@ page contentType="text/html; charset=euc-kr" %>

<%@ page import = "java.sql.DriverManager"%>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.Statement" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.SQLException" %>
<%@ page import = "java.io.Reader" %>
<%@ page import = "java.io.IOException" %>

<%
String memberID = request.getParameter("memberID"); %>

<html>
<head><title> 회원정보 </title></head>
<body>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");

Connection conn = null;
Statement st = null;
ResultSet rs = null;

try{
	String jdbcDriver = "jdbc:oracle:thin:@localhost:1521:XE";
	String dbUser = "ezen";
	String dbPass = "oracle";
	String query = "select * from member_history "+ "where memberid = '"+memberID+"'";
	
	conn=DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
	st=conn.createStatement();
	rs=st.executeQuery(query);
	
	if(rs.next()){ %>
	<table border="1">
	<tr>
		<td>아이디</td><td><%= memberID %></td>
	</tr>
	
	<tr>
		<td>히스토리</td>
		<td>
		<%
		String history = null;
		Reader reader = null;
		
		try{
			reader = rs.getCharacterStream("HISTORY");
			
			if(reader != null){
				StringBuffer buff = new StringBuffer();
				char[] ch = new char[512];
				int len = -1;
				
				while ( ((len = reader.read(ch))) != -1) {
					buff.append(ch, 0, len);
				}
				
				history = buff.toString();
			}
		}catch(IOException e){
			out.println(e.getMessage());
		}finally{
			if(reader != null) try {reader.close();} catch(IOException e){}
			
		}
		%>
	<%= history %>
	</td>
	</table>
<% }else{ %>
<%= memberID %> 회원의히스토리없음
<% } }catch(SQLException e){ %>
<%=e.getMessage() %>
 <% }finally{
	if(rs != null) try {rs.close();} catch(SQLException e){}
	if(st != null) try {st.close();} catch(SQLException e){}
	if(conn != null) try {conn.close();} catch(SQLException e){}
 }
	%>

</body>

</html>