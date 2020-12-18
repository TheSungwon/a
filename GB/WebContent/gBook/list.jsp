<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import ="gBook.Message"%>
<%@ page import = "gBookService.MessageListView"%>
<%@ page import ="gBookService.GetMessageListService"%>

<%
String pageNumberStr = request.getParameter("page");
//page파라미터값을 이용해서 읽어올 페이지번호 생성

int pageNumber = 1;

if(pageNumberStr != null){
	pageNumber = Integer.parseInt(pageNumberStr);
}

GetMessageListService messageListService = GetMessageListService.getInstance();

MessageListView viewData = messageListService.getMessageList(pageNumber);
//지정한 페이지에 해당하는 메시지목록 구한다
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
<input type="submit" value="message"/> <!--  메시지입력폼-->
</form>
<hr>
<% if(viewData.isEmpty()){ %>
no posting
<%}else{ %>		<!-- 메시지가존재할경우 for문을 이용해서 메시지를 차례대로출력 -->
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

<%for (int i=1; i<= viewData.getPageTotalCount(); i++){ %><!-- 전체페이지목록출력 -->
<a href="list.jsp?page=<%=i %>">[<%=i %>]</a> <%}} %>
</body>
</html>