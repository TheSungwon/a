<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�ֹ�</title>
</head>
<body>

<form method="post">
��ǰ1 id<input type="text" name="orderItems[0].itemId"/>
���� 	<input type="text" name="orderItems[0].number"/>
���� <input type="text" name="orderItems[0].remark"/>
<br/>
��ǰ2 id<input type="text" name="orderItems[1].itemId"/>
���� 	<input type="text" name="orderItems[1].number"/>
���� <input type="text" name="orderItems[1].remark"/>
<br/>
��ǰ3 id<input type="text" name="orderItems[2].itemId"/>
���� 	<input type="text" name="orderItems[2].number"/>
���� <input type="text" name="orderItems[2].remark"/>
<br/>
<input type="submit"/>

</form>


</body>
</html>