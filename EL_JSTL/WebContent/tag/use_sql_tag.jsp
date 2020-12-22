<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<html>
<head><title> jstl sql</title></head>
<body>
<sql:query var="rs" dataSource="jdbc:apache:commons:dbcp:/connectionPool">
select * from member
</sql:query>

<table border="1">
<tr>
<c:forEach var="columnName" items="${rs.columnNames }">
<th> <c:out value="${columnName }"/></th>
</c:forEach>
</tr>

<c:forEach var="row" items="${rs.rowsByIndex }"> <!-- 레코드수만큼반복 -->
<tr> <c:forEach var="column" items="${row }" varStatus="i"><!-- 레코드의필드수만큼반복 -->
<td>
<c:if test="${column!=null }"> <!-- 해당필드값 널아니면 -->
<c:out value="${column }"/>
</c:if> <!-- 널이면 -->
<c:if test="${column ==null }">&nbsp; </c:if></td></c:forEach></tr></c:forEach>

</table>
</body>
</html>
