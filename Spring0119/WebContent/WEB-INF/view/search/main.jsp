<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>search</title>
</head>
<body>

키워드 <c:forEach var="query"items="${queryList }">${query }</c:forEach>

<form action="game.do">
<select name="type">
	<c:forEach var="searchType" items="${searchList }">
	<option value="${searchType.code }">${searchType.text }</option> </c:forEach>
</select>
<input type="text" name="query"value=""/>
<input type="submit"value="검색"/>
</form>

</body>
</html>