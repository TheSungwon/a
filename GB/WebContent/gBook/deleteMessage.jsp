<%@page contentType="text/html; charset=euc-kr"%>
<%@ page errorPage="errorView.jsp"%>
<%@ page import="gBookService.DeleteMessageService"%>
<%@page import= "gBookException.InvalidMessagePasswordException"%>
<!-- �޽������� ��ûó���ϴ� jsp
���������� ����Ŭ���ϸ� ������û�� deleteMessage.jsp�� ����
deleteMessagejsp�� �޽������̵�(messageId�Ķ����) �� 
������ȣ(password�Ķ����)�� DeleteMessageService��ü�� deleteMessage()�޼��忡
�����ؼ� �޽��������� �õ��ѵ� �޽������� ����� ���� �˸��� ������� -->

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
