<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="EUC-KR">
<title>결과</title>
</head>
<body>
키워드, <c:forEach var="query" items="${queryList }">${query }</c:forEach>

<form action="game.do">
<select name="type">
	<c:forEach var="search" items="${searchList }">
	<option value="${search.code }" <c:if test="${command.type == search.code }">selected</c:if>>
	${search.text }</option>
	
	</c:forEach>

</select>
<input type="text" name="query" value="${command.query }"/>
<input type="submit" value="검색"/>
</form>
결과 ${searchResult }

</body>
</html>