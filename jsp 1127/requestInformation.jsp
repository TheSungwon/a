<%@ page contentType="text/html; charset=euc-kr" %>
<html>
<head><title>request�޼ҵ�</title></head>
<body>
Ŭ���Ʈip <%= request.getRemoteAddr() %>
�������� ������ Ŭ���̾�ƮIP�ּ�
 <br>

��û�������� <%= request.getContentLength() %>
Ŭ���̾�Ʈ�� ������ ��û ������ ����. ���̸� �˼������� -1����
<br>
��û���� ���ڵ� <%= request.getCharacterEncoding() %>
Ŭ���̾�Ʈ�� ��û������ ������ �� ����� ĳ������ ���ڵ�
<br>
��û���� ����ƮŸ�� <%= request.getContentType() %>
Ŭ���̾�Ʈ�� ��û������ ������ �� ����� ����Ʈ�� Ÿ��
<br>
��û���� �������� <%= request.getProtocol() %>
Ŭ���̾�Ʈ�� ��û�� ��������
<br>
��û���� ���۹�� <%=request.getMethod() %>
�� �������� ������ ������ �� ����� ���
<br>
��û URI <%= request.getRequestURI() %>
�� �������� ��û�� URL���� ���
<br>
���ؽ�Ʈ ��� <%= request.getContextPath() %>
JSP�������� ���� �� ���ø����̼��� ���ؽ�Ʈ��� **
<br>
�����̸� <%= request.getServerName() %>
������ �� ����� ���� �̸�
<br>
������Ʈ <%= request.getServerPort() %>
������ ���� ���� ��Ʈ��ȣ
</body>

</html>