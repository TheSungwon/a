<%@ page contentType = "text/html; charset=euc-kr"%>
<%@ page import = "java.util.Calendar"%>

<html>
<head>
<title> Ŭ�������	</title>
</head>

<body>
<%Calendar c = Calendar.getInstance(); %> <!-- ��ũ��Ʈ�� ��𿡼����ϵ� ���X -->

������
<%= c.get(Calendar.YEAR) %>��
<%= c.get(Calendar.MONTH) %>��
<%= c.get(Calendar.DATE) %>��
�Դϴ�.

</body>
</html>
