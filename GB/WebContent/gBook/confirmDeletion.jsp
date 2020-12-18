<%@ page contentType="text/html; charset=euc-kr"%>
<!-- 메시지삭제폼 제공 jsp
삭제할때 필요한 암호를 입력받는 폼 제공

hidden타입의 input태그를 이용해서 삭제할 메시지번호를 보관하며
password타입의 input태그를 이용해서 메시지를 기록할때 입력한
암호를  입력받는다. -->

<html>
<head>
<title> delete check</title>
</head>

<body>
<form action="deleteMessage.jsp" method="post">
<input type="hidden" name="messageId"
 value="<%=request.getParameter("messageId") %>"/>
 enter password<br/>
 password:::<input type="password" name="password"/><br/>
 <input type="submit"  value="message delete"/>
</form>
</body>
</html>