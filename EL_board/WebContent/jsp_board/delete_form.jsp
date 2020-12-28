<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- delete_form.jsp는 게시글 삭제를 위해 암호를 입력 받는 폼을 제공 -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><title>delete</title></head>
<body>
<form action="<c:url value='./delete.jsp'/>" method="post">
<input type="hidden" name="articleId" value="${param.articleId }"/>

password delete <input type="password" name="password"/><br/>
<input type="submit" value="delete"/>
</form>

</body>
</html>