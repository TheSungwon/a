<%@page contentType="text/html; charset=euc-kr"%>
<%@page import = "java.sql.DriverManager"%>
<%@page import = "java.sql.Connection"%>
<%@page import = "java.sql.Statement"%>
<%@page import = "java.sql.ResultSet"%>
<%@page import = "java.sql.SQLException"%>

<%String memberID=request.getParameter("memberID"); %>

<html>
<head><title>ȸ������</title></head>
<body>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");

Connection conn = null;
Statement st = null;
ResultSet rs = null;

try{
	String jdbcDriver = "jdbc:oracle:thin:@localhost:1521:XE";
	String dbUser="ezen";
	String dbPass="oracle";
	String query=
			"select * from MEMBER where MEMBERID = '"+memberID+"'" ;
	
	conn=DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
	st=conn.createStatement();
	rs=st.executeQuery(query);
	
	if(rs.next()){ /* �� �� �� ��� */%>
	<table border="1">
	<tr>
		<td>���̵�</td><td><%=memberID %></td>
	</tr>
	<tr>
		<td>��ȣ</td><td><%=rs.getString("PASSWROD") %></td>
	</tr>
	<tr>
		<td>�̸�</td><td><%=rs.getString("name")%></td>
	</tr>
	<tr>
		<td>�̸���</td><td><%=rs.getString("email")%></td>
	</tr>
	</table>

<%
	}else{out.println(memberID+"�� �ش��ϴ� ��������");}
	
			
}catch(SQLException e){out.println(e.getMessage());
}finally{
	if(rs != null)
		try{rs.close();} catch(SQLException e){}
	if(st != null)
		try{st.close();} catch(SQLException e){}
	if(conn != null)
		try{conn.close();} catch(SQLException e){}
	
}
%>

</body>
</html>
