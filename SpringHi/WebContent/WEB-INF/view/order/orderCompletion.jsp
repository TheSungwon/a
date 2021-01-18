<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>주문완료</title>
</head>
<body>
주문완료<br/>
주문아이템
<ul>
	<c:forEach var="item" items="${orderCommand.orderItems }">
	<li>${item.itemId } / ${item.number } / <${item.remark }</li>
	</c:forEach>

</ul>

배송지 ${orderCommand.address }
</body>
</html>