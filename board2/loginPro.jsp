<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="board.LogonDBBean"%>

<% request.setCharacterEncoding("euc-kr");
%>

<%
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
//
String cb = request.getParameter("cb"); //체크박스의 체크박스여부넘어옴
Cookie cookie = new Cookie("cb",id);//쿠키생성
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
alert("비번이맞지않습니다.1");
history.go(-1);
</script>
<%}else{%>
<script>
alert("아이디가맞지않습니다1");
history.go(-1);
</script>
<%}%>