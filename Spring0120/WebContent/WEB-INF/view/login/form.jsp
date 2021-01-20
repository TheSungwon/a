<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
<html>
<head>
<meta charset="EUC-KR">
<title>LOGIN</title>
</head>
<body>

<form:form commandName ="loginCommand">
<form:errors element="div"/>
	ID <form:input path="userId"/>
	<form:errors path="userId"/> 
	<br/>
	
	PASSWORD <form:password path="password" showPassword="false"/>
	<form:errors path="password"/>
	<br/>
	<input type="submit"/>
</form:form>

</body>
</html>