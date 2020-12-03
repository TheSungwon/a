<!-- 
JDBC���α׷��� �ڵ� ��Ÿ��
������
JDBC����̹��ε�
�����ͺ��̽� Ŀ�ؼ� ����
���� ������ ���� Statement��ü����
��������
Statement����
�����ͺ��̽� Ŀ�ؼ� ���� -->

<%@page contentType="text/html; charset=euc-kr"%>
<%@page import = "java.sql.DriverManager" %>
<%@page import = "java.sql.Connection" %>
<%@page import = "java.sql.Statement" %>
<%@page import = "java.sql.ResultSet" %>
<%@page import = "java.sql.SQLException" %>

<html>
<head><title> MEMBER DB</title></head>
<body>
emp���̺�
<table width="100%" border="1">
<tr>
	<td>ename</td>
	<td>job</td>
	<td>hireDate</td>
	<td>commission</td>
</tr>
<!-- 1.jdbc ����̹��ε�  -->
<%

Class.forName("oracle.jdbc.driver.OracleDriver");

Connection conn = null;
Statement st = null;
ResultSet rs = null;

try{
	String jdbcDriver="jdbc:oracle:thin:@localhost:1521:XE";
	String dbUser="scott";
	String dbPass="tiger";
	
	String query
	="select * from emp order by empno";
	
	/* 2. �����ͺ��̽� Ŀ�ؼ� ����*/
	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
	
	/* 3. Statement ���� */
	st = conn.createStatement();
	
	/* 4. �������� */
	rs = st.executeQuery(query);
	
	/* 5. �������� ������ */
	while(rs.next()){
		out.println("<tr><td>");
		out.println(rs.getString("ename"));
		out.println("</td><td>");
		out.println(rs.getString("job"));
		out.println("</td><td>");
		out.println(rs.getString("hiredate"));
		out.println("</td><td>");
		out.println(rs.getString("comm"));
		out.println("</td>");
		out.println("</tr>");
	}
}catch(SQLException e){
	out.println(e.getMessage());
	e.printStackTrace();
}finally{
	/* 6. ����� Statement ���� */
	if( rs != null) try{ rs.close();} catch(SQLException e){}
	if( st != null) try{ st.close();} catch(SQLException e){}
	
	/* 7. Ŀ�ؼ� ���� */
	if(conn != null) try{ conn.close();} catch(SQLException e){}
}
%>


</table>
</body>
</html>