<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> create account</title>
</head>
<body>
<spring:hasBindErrors name="bean"/>
<form:errors path="bean"/>
<form method="post">
ID <input type="text" name="id"value="${bean.id }"/>
<form:errors path="bean.id"/> <br/>

NAME <input type="text" name="name"value="${bean.name }"/>
<form:errors path="bean.name"/> <br/>

zipcode <input type="text" name="address.zipcode" value="${bean.address.zipcode }"/>
<form:errors path="bean.address.zipcode"/> <br/>

address1 <input type="text" name="address.address1" value="${bean.address.address1 }"/>
<form:errors path="bean.address.address1"/><br/>

address2 <input type="text" name="address.address2" value="${bean.address.address2 }"/>
<form:errors path="bean.address.address2"/><br/>

<input type="submit"/>
</form>
</body>
</html>