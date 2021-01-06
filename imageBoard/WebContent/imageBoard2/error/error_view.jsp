<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="javax.servlet.ServletException"%>
<%@page isErrorPage="true"%>

<html>
<head><title> error</title></head>
<body>
error message<%=exception.getMessage() %>
<%exception.printStackTrace(); %>
<p>
<% Throwable rootCause = null;
if(exception instanceof ServletException){
	rootCause = ((ServletException)exception).getRootCause();
}else{
	rootCause = exception.getCause();
}
if(rootCause != null){
	rootCause.printStackTrace();
	do{
%>
예외추적
<%=rootCause.getMessage() %> <br>
<% rootCause = rootCause.getCause();
}while(rootCause !=null);}%>
</body>
</html>