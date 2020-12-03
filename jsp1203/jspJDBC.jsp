<!-- 
JDBC프로그래밍 코딩 스타일
순서는
JDBC드라이버로딩
데이터베이스 커넥션 구함
쿼리 실행을 위한 Statement객체생성
쿼리실행
Statement종료
데이터베이스 커넥션 종료 -->

<%@page contentType="text/html; charset=euc-kr"%>
<%@page import = "java.sql.DriverManager" %>
<%@page import = "java.sql.Connection" %>
<%@page import = "java.sql.Statement" %>
<%@page import = "java.sql.ResultSet" %>
<%@page import = "java.sql.SQLException" %>

<html>
<head><title> MEMBER DB</title></head>
<body>
MEMBER테이블
<table width="100%" border="1">
<tr>
	<td>name</td>
	<td>ID</td>
	<td>email</td>
</tr>
<!-- 1.jdbc 드라이버로딩  -->
<%

Class.forName("oracle.jdbc.driver.OracleDriver");

Connection conn = null;
Statement st = null;
ResultSet rs = null;

try{
	String jdbcDriver="jdbc:oracle:thin:@localhost:1521:XE";
	String dbUser="ezen";
	String dbPass="oracle";
	
	String query
	="select * from MEMBER order by MEMBERID";
	
	/* 2. 데이터베이스 커넥션 생성*/
	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
	
	/* 3. Statement 생성 */
	st = conn.createStatement();
	
	/* 4. 쿼리실행 */
	rs = st.executeQuery(query);
	
	/* 5. 쿼리실행 결과출력 */
	while(rs.next()){
		out.println("<tr>");
		out.println("<td>");
		out.println(rs.getString("NAME"));
		out.println("</td><td>");
		out.println(rs.getString("MEMBERID"));
		out.println("</td><td>");
		out.println(rs.getString("EMAIL"));
		out.println("</td>");
		out.println("</tr>");
	}
}catch(SQLException e){
	out.println(e.getMessage());
	e.printStackTrace();
}finally{
	/* 6. 사용한 Statement 종료 */
	if( rs != null) try{ rs.close();} catch(SQLException e){}
	if( st != null) try{ st.close();} catch(SQLException e){}
	
	/* 7. 커넥션 종료 */
	if(conn != null) try{ conn.close();} catch(SQLException e){}
}
%>


</table>
</body>
</html>