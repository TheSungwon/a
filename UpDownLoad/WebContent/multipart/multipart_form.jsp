<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<html>
<head><title> multipart form</title></head>
<body>
<form action="./multipart_data.jsp" method="post" enctype="multipart/form-data">
1 <input type="text" name="1"/><br/>
2<input type="file" name="2"/><br/>
3<input type="file" name="3" /><br/>
<input type="submit" value="submit"/>
</form>
</body>
</html>