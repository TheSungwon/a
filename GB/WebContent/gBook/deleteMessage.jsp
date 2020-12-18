<%@page contentType="text/html; charset=euc-kr"%>
<%@ page errorPage="errorView.jsp"%>
<%@ page import="gBookService.DeleteMessageService"%>
<%@page import= "gBookException.InvalidMessagePasswordException"%>
<!-- 메시지삭제 요청처리하는 jsp
삭제폼에서 삭제클릭하면 삭제요청이 deleteMessage.jsp에 전달
deleteMessagejsp는 메시지아이디(messageId파라미터) 와 
삭제암호(password파라미터)를 DeleteMessageService객체의 deleteMessage()메서드에
전달해서 메시지삭제를 시도한뒤 메시지삭제 결과에 따라 알맞은 문구출력 -->

<%
int messageId = Integer.parseInt(request.getParameter("messageId"));
String password = request.getParameter("password");
boolean invalidPassword = false;
try{
	DeleteMessageService deleteService =
			DeleteMessageService.getInstance();
	deleteService.deleteMessage(messageId, password);
}catch(InvalidMessagePasswordException e){
	invalidPassword = true;
}
%>

<html>
<head>
<title> gBook message delete</title>
</head>

<body>
<%	if( !invalidPassword){ 
out.println("message deleteeeeeeeeee");
}else{
out.println("password check");}%> <br/>
<a href="list.jsp">@@@list@@@</a>
</body>
</html>
