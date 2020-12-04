<!-- java.sql.preparedStatement은 jaava.sql.Statement 과 동일한 기능
preparedStatement는 sql쿼리의 틀을 미리생성해 놓고 값을
나중에 지정한다.

1Coonnection.prepareStatement()메서드를 사용하여 preparedStatement생성
2preparedStatement의 set메서드를 사용하여 필요한 값 지정
3preparedStatement의 executeQuery또는 executeUpdate메서드를 사용하여 쿼리실행
4finally블록에서 사용한 preparedStatement를 닫는다. (close메소드실행)
 -->
 
 <%@ page contentType="text/html; charset=euc-kr"%>
 
 <html>
 <head><title> member 테이블 레코드삽입</title></head>
 <body>
 <form action="./preparedSt.jsp" method="post">
 <table border="1">
 
<tr>
	<td>id</td>
	<td><input type="text" name="id" size="10"></td>
	<td>password</td>
	<td><input type="text" name="password" size="10"></td>
</tr>

<tr>
	<td>name</td>
	<td><input type="text" name="name" size="10"></td>
	<td>email</td>
	<td><input type="text" name="email" size="10"></td>
</tr>
<tr>
	<td colspan="4"><input type="submit" value="insert"	></td>

</tr>

 </table>
 
 </form>
 </body>
 </html>