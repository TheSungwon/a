<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="board.LogonDBBean"%>

<% request.setCharacterEncoding("euc-kr");
%>

<%
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
//
String checkbox = request.getParameter("checkbox"); //체크박스의 체크박스여부넘어옴
Cookie cookie = new Cookie("userId",id);//쿠키생성
//
LogonDBBean manager = LogonDBBean.getInstance();
int check = manager.userCheck(id, passwd);
//
if(checkbox != null){ //체크박스여부에따라 쿠키저장확인
	cookie.setMaxAge(60*60*24*365);
	response.addCookie(cookie); //체크되면 쿠키저장
}else{
	cookie.setMaxAge(0);
	response.addCookie(cookie);//체크해제하면 쿠키유효시간0으로 브라우저에서삭제
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