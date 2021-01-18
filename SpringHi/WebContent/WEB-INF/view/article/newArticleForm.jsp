<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시글</title>
</head>
<body>
게시글쓰기
<form method="post">
	<input type="hidden" name="parentId" value="0"/>
	제목<input type="text" name="title"/><br/>
	내용<textarea rows="0" cols="0" name="content"></textarea><br/>
	<input type="submit">
	</form>
</body>
</html>