<%@ page contentType="text/html; charset=euc-kr"%>
<!-- �޽��������� ���� jsp
�����Ҷ� �ʿ��� ��ȣ�� �Է¹޴� �� ����

hiddenŸ���� input�±׸� �̿��ؼ� ������ �޽�����ȣ�� �����ϸ�
passwordŸ���� input�±׸� �̿��ؼ� �޽����� ����Ҷ� �Է���
��ȣ��  �Է¹޴´�. -->

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