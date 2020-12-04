<%@page contentType="text/html; charset=euc-kr"%>
<%@page import = "java.sql.DriverManager"%>
<%@page import = "java.sql.Connection"%>
<%@page import = "java.sql.PreparedStatement"%>
<%@page import = "java.sql.ResultSet"%>
<%@page import = "java.sql.SQLException"%>

<%String memberID=request.getParameter("memberID"); %>

<html>
<head><title>회원정보</title></head>
<body>
<%


Connection conn = null;
PreparedStatement ps = null;
ResultSet rs = null;

try{
	String jdbc = "jdbc:apache:commons:dbcp:/connectionPool";
	conn=DriverManager.getConnection(jdbc);
	ps = conn.prepareStatement(
			"select * from MEMBER");
	
	

	rs=ps.executeQuery();
	
	if(rs.next()){ /* 한 줄 만 출력 */%>
	<table border="1">
	<tr>
		<td>아이디</td><td><%=memberID %></td>
	</tr>
	<tr>
		<td>암호</td><td><%=rs.getString("PASSWROD") %></td>
	</tr>
	<tr>
		<td>이름</td><td><%=rs.getString("name")%></td>
	</tr>
	<tr>
		<td>이메일</td><td><%=rs.getString("email")%></td>
	</tr>
	</table>

<%
	}else{out.println(memberID+"에 해당하는 정보없음");}
	
			
}catch(SQLException e){out.println(e.getMessage());
}finally{
	if(rs != null)
		try{rs.close();} catch(SQLException e){}
	if(ps != null)
		try{ps.close();} catch(SQLException e){}
	if(conn != null)
		try{conn.close();} catch(SQLException e){}
	
}
%>

</body>
</html>
