<%@page contentType="text/html; charset=euc-kr"%>
<%@page errorPage ="errorView.jsp"%>
<%@page import ="gBook.Message"%>
<%@page import="gBookService.WriteMessageService"%>
<%//�޽������ó���ϴ� jsp
//list�� �޽����Է��� ���� ���� �Է��ϸ� writeMessage.jsp�� ����
//���޹��� �Ķ���͸� �̿��ؼ� Message��ü�� �����ѵ�
//WriteMessageService�� �̿��ؼ� �޽����� ����Ѵ�.

request.setCharacterEncoding("euc-kr");
%>

<jsp:useBean id="message" class="gBook.Message">
<jsp:setProperty name="message" property="*"/>
</jsp:useBean><!-- Message��ü�� �����ϰ� ��û�Ķ������ ����
Message��ü�� ������Ƽ�� �����Ѵ�. -->

<%
WriteMessageService writeService = WriteMessageService.getInstance();
writeService.write(message);
//WriteMessageService.write()�޼��带 �����ؼ� ����ڰ� �Է��� ������ �����Ѵ�
%>

<html><!--�� �޼��尡 ����������Ǹ� ȭ���̵� ��ũ ���  -->
<head>
<title> message log</title>
</head>
<body>
Leave a message
<br/>
<a href="list.jsp">@@@list@@@</a> 
</body>
</html>