<!-- ���Ǳ⺻��ü�� �α���ǥ���� ���� �Ӽ��� �����ϴ����� ���ο� ���� �α��� ���¸� �Ǵ�
sessionLoing.jsp���� �����ѷα��� ǥ���� ����Ͽ� �Ǵ� �� ���
���� �⺻��ü�� memberid�Ӽ� ���� ���θ� ����Ͽ� �Ǵ�. -->

<%@ page contentType="text/html; charset=euc-kr"%>
<%
String memberId = (String)session.getAttribute("memberid");
boolean login = memberId == null ? false : true ; 
/* 3�׿����� memeberId�� ���̸� false �� �ƴϸ� true */
%>

<html>
<head><title> �α��ο��ΰ˻�</title></head>

<body> 

<%
if (login){ out.println( memberId + " �α����ѻ���");
	}else{ out.println("�α��� �ƴϴ�"); 
}
%>
</body>
</html>
