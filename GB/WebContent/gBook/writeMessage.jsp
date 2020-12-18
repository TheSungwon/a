<%@page contentType="text/html; charset=euc-kr"%>
<%@page errorPage ="errorView.jsp"%>
<%@page import ="gBook.Message"%>
<%@page import="gBookService.WriteMessageService"%>
<%//메시지등록처리하는 jsp
//list는 메시지입력폼 제공 값을 입력하면 writeMessage.jsp로 전송
//전달받은 파라미터를 이용해서 Message객체를 생성한뒤
//WriteMessageService를 이용해서 메시지를 기록한다.

request.setCharacterEncoding("euc-kr");
%>

<jsp:useBean id="message" class="gBook.Message">
<jsp:setProperty name="message" property="*"/>
</jsp:useBean><!-- Message객체를 생성하고 요청파라미터의 값을
Message객체의 프로퍼티에 저장한다. -->

<%
WriteMessageService writeService = WriteMessageService.getInstance();
writeService.write(message);
//WriteMessageService.write()메서드를 실행해서 사용자가 입력한 정보를 저장한다
%>

<html><!--위 메서드가 정상적시행되면 화면이동 링크 출력  -->
<head>
<title> message log</title>
</head>
<body>
Leave a message
<br/>
<a href="list.jsp">@@@list@@@</a> 
</body>
</html>