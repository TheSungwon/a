<!-- java.sql.preparedStatement�� jaava.sql.Statement �� ������ ���
preparedStatement�� sql������ Ʋ�� �̸������� ���� ����
���߿� �����Ѵ�.

1Coonnection.prepareStatement()�޼��带 ����Ͽ� preparedStatement����
2preparedStatement�� set�޼��带 ����Ͽ� �ʿ��� �� ����
3preparedStatement�� executeQuery�Ǵ� executeUpdate�޼��带 ����Ͽ� ��������
4finally��Ͽ��� ����� preparedStatement�� �ݴ´�. (close�޼ҵ����)
 -->
 
 <%@ page contentType="text/html; charset=euc-kr"%>
 
 <html>
 <head><title> member ���̺� ���ڵ����</title></head>
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