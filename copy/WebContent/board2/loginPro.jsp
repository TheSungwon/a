<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="board.LogonDBBean"%>

<% request.setCharacterEncoding("euc-kr");
%>

<%
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");

LogonDBBean manager = LogonDBBean.getInstance();
int check = manager.userCheck(id, passwd);

if(check ==1) {
	session.setAttribute("memId", id);
	response.sendRedirect("main.jsp");
/////
Cookie c = new Cookie("savI",id);
c.setMaxAge(10*3);
response.addCookie(c);
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