<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>spring </title>
</head>
<body>

<ul>
	<li><a href="<c:url value='/hello.do'/>">/hello.do</a></li>
	
	<li><a href="<c:url value='/game/users/aaa/characters/111'/>"> /game/users/{userId}/charaters/{charaterId}</a>
	(CharaterInfoController, @PathVariable ����) </li>
	
	<li><a href="<c:url value='/login/login.do'/>"> login/login.do</a>
	(LoginController, @InitBinder @Vliad�� �̿��� �� �� ���� </li>

</ul>

</body>
</html>