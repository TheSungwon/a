<%@page contentType="text/html; charset=euc-kr"%>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");

if(id.equals(password)){
	session.setAttribute("memberid",id); %>
	
<html>
<head><title>�α��μ���</title></head>
<body>����</body>
</html>
<%
}else{ /* �α��ν��� */ %>
<script>
alert("failed")
history(-1);
</script>
<%}%>
<!-- �α��ο� ������ ��� ���Ǳ⺻��ü�� ����ھ��̵� ������ memberid�Ӽ��� ����
memberid �Ӽ����� �����Ѵٸ� ���� ����ڴ� ������ ����ڷ� ó�� -->