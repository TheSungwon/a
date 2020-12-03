<%@page contentType="text/html; charset=euc-kr"%>
<html>
<head><title>회원가입</title></head>
<body>
<form action="<%=request.getContextPath() %>/jsp1202/memProperty.jsp"
method="post" >

<table border="1" cellpadding="0" cellspacing="0">
<tr>
	<td>ID</td>
	<td colspan="3"><input type="text" name="id" size="10"	></td>
</tr>

<tr>
	<td>name</td>
	<td><input type="text" name="name" size="10"></td>
	<td>email</td>
	<td><input type="text" name="email" size="10"></td>
</tr>

<tr>
	<td>address</td>
	<td colspan="3"><input type="text" name="address" size="30"></td>
</tr>

<tr>
	<td colspan="4" align="center">
	<input type="submit" value="회원가입">
	</td>
</tr>

</table>
</form>
</body>
</html>