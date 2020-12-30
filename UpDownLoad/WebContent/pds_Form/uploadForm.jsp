<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>파일등록</title>

</head>
<body>
<form action ="/UpDownLoad/pds_jsp/upload.jsp" method="post" enctype="multipart/form-data">
file <input type="file" name="file" /><br/>
ex <input type="text" name="description"/> <br/>
<input type="submit" value="upload"/>

</form>

</body>
</html>