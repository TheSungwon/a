<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@page errorPage ="errorView.jsp"%>
<%@page import ="gBook.Message"%>
<%@page import="gBookService.UpdateMessageService"%>
<%@page import= "gBookException.InvalidMessagePasswordException"%>


<%
request.setCharacterEncoding("euc-kr");
%>

<jsp:useBean id="message" class="gBook.Message">
<jsp:setProperty name="message" property="*"/>
</jsp:useBean>

<%
boolean invalidPassword = false;
int messageId = Integer.parseInt(request.getParameter("messageId"));
String password = request.getParameter("password");
try{
UpdateMessageService updateService = UpdateMessageService.getInstance();
updateService.updateMessage(message, messageId);
}catch(InvalidMessagePasswordException e){
	invalidPassword = true;
}
%>






<html>
<head>
<title> gBook message delete</title>
</head>

<body>
<%	if( invalidPassword){ 
out.println("failed");
}else{
out.println("password correct");}%> <br/>
<a href="list.jsp">@@@list@@@</a>
</body>
</html>
