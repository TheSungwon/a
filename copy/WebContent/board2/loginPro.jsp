<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="board.LogonDBBean"%>

<% request.setCharacterEncoding("euc-kr");
%>

<%
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
//
String checkbox = request.getParameter("checkbox"); //üũ�ڽ��� üũ�ڽ����γѾ��
Cookie cookie = new Cookie("userId",id);//��Ű����
//
LogonDBBean manager = LogonDBBean.getInstance();
int check = manager.userCheck(id, passwd);
//
if(checkbox != null){ //üũ�ڽ����ο����� ��Ű����Ȯ��
	cookie.setMaxAge(60*60*24*365);
	response.addCookie(cookie); //üũ�Ǹ� ��Ű����
}else{
	cookie.setMaxAge(0);
	response.addCookie(cookie);//üũ�����ϸ� ��Ű��ȿ�ð�0���� ��������������
}


///////
if(check ==1) {
	session.setAttribute("memId", id);
	response.sendRedirect("main.jsp");
/////

/////
}else if (check==0){%>

<script>
alert("����̸����ʽ��ϴ�.1");
history.go(-1);
</script>
<%}else{%>
<script>
alert("���̵𰡸����ʽ��ϴ�1");
history.go(-1);
</script>
<%}%>