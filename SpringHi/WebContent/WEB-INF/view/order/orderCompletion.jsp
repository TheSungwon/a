<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�ֹ��Ϸ�</title>
</head>
<body>
�ֹ��Ϸ�<br/>
�ֹ�������
<ul>
	<c:forEach var="item" items="${orderCommand.orderItems }">
	<li>${item.itemId } / ${item.number } / <${item.remark }</li>
	</c:forEach>

</ul>

����� ${orderCommand.address }
</body>
</html>