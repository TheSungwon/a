<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="board.LogonDBBean"%>

<% request.setCharacterEncoding("euc-kr");
%>

<%
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
//
String cb = request.getParameter("cb"); //üũ�ڽ��� üũ�ڽ����γѾ��
Cookie cookie = new Cookie("cb",id);//��Ű����
//
LogonDBBean manager = LogonDBBean.getInstance();
int check = manager.userCheck(id, passwd);
//
if(cb != null){
	cookie.setMaxAge(30*1);
	response.addCookie(cookie);
}else{
	cookie.setMaxAge(0);
	response.addCookie(cookie);
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