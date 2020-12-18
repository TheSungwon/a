<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<html>
<head>
<title> update</title>
</head>

<body>
<form action="updateMessage.jsp" method="post">
<input type="hidden" name="messageId"
 value="<%=request.getParameter("messageId") %>"/>
 enter password<br/>
 password:::<input type="password" name="password"/><br/>
 
 MESSAGE:<textarea rows="3" cols="30" name="message"></textarea><br/>
 <input type="submit"  value="내용입력"/>
</form>
</body>
</html>