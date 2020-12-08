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
alert("비번이맞지않습니다.1");
history.go(-1);
</script>
<%}else{%>
<script>
alert("아이디가맞지않습니다1");
history.go(-1);
</script>
<%}%>