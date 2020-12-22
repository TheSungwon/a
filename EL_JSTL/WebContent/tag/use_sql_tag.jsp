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

<c:forEach var="row" items="${rs.rowsByIndex }"> <!-- ���ڵ����ŭ�ݺ� -->
<tr> <c:forEach var="column" items="${row }" varStatus="i"><!-- ���ڵ����ʵ����ŭ�ݺ� -->
<td>
<c:if test="${column!=null }"> <!-- �ش��ʵ尪 �ξƴϸ� -->
<c:out value="${column }"/>
</c:if> <!-- ���̸� -->
<c:if test="${column ==null }">&nbsp; </c:if></td></c:forEach></tr></c:forEach>

</table>
</body>
</html>
