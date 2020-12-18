<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import ="gBook.Message"%>
<%@ page import = "gBookService.MessageListView"%>
<%@ page import ="gBookService.GetMessageListService"%>

<%
String pageNumberStr = request.getParameter("page");
//page�Ķ���Ͱ��� �̿��ؼ� �о�� ��������ȣ ����

int pageNumber = 1;

if(pageNumberStr != null){
	pageNumber = Integer.parseInt(pageNumberStr);
}

GetMessageListService messageListService = GetMessageListService.getInstance();

MessageListView viewData = messageListService.getMessageList(pageNumber);
//������ �������� �ش��ϴ� �޽������ ���Ѵ�
%>

<html>
<head>
<title> message list</title>

</head>

<body>
<form action="writeMessage.jsp" method="post">
NAME: <input type="text" name="guestName"/><br/>
PASSWORD:<input type="password" name="password"/><br/>
MESSAGE:<textarea rows="3" cols="30" name="message"></textarea><br/>
<input type="submit" value="message"/> <!--  �޽����Է���-->
</form>
<hr>
<% if(viewData.isEmpty()){ %>
no posting
<%}else{ %>		<!-- �޽����������Ұ�� for���� �̿��ؼ� �޽����� ���ʴ����� -->
<table border="1">
<%for(Message message : viewData.getMessageList()){ %>
<tr><td>
message no:<%=message.getId() %><br/>
guest name:<%=message.getGuestName() %><br/>
message:<%=message.getMessage() %><br/>
<a href="confirmDeletion.jsp?messageId=<%=message.getId() %>">[delete]

<a href="confirmUpdate.jsp?messageId=<%=message.getId() %>">[update]</a>
</a></td></tr>

<%} %>

</table>

<%for (int i=1; i<= viewData.getPageTotalCount(); i++){ %><!-- ��ü������������ -->
<a href="list.jsp?page=<%=i %>">[<%=i %>]</a> <%}} %>
</body>
</html>