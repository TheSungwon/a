<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- delete_form.jsp�� �Խñ� ������ ���� ��ȣ�� �Է� �޴� ���� ���� -->

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