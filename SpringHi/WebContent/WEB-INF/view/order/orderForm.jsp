<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>주문</title>
</head>
<body>

<form method="post">
상품1 id<input type="text" name="orderItems[0].itemId"/>
개수 	<input type="text" name="orderItems[0].number"/>
주의 <input type="text" name="orderItems[0].remark"/>
<br/>
상품2 id<input type="text" name="orderItems[1].itemId"/>
개수 	<input type="text" name="orderItems[1].number"/>
주의 <input type="text" name="orderItems[1].remark"/>
<br/>
상품3 id<input type="text" name="orderItems[2].itemId"/>
개수 	<input type="text" name="orderItems[2].number"/>
주의 <input type="text" name="orderItems[2].remark"/>
<br/>
<input type="submit"/>

</form>


</body>
</html>