<%@page contentType="text/html; charset=euc-kr"%>
<html>
<head>><title> 옵션선택</title></head>
<body>
<form action="<%= request.getContextPath() %>/jsp 1130/forwadSelect1.jsp">

페이지선택
	<select name="code">
		<option value="A">A</option>
		<option value="B">B</option>
		<option value="C">C</option>
		
	</select>

<input type="submit" value="이동">
</form>

</body>
</html>