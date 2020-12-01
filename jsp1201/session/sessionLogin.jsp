<%@page contentType="text/html; charset=euc-kr"%>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");

if(id.equals(password)){
	session.setAttribute("memberid",id); %>
	
<html>
<head><title>로그인성공</title></head>
<body>성공</body>
</html>
<%
}else{ /* 로그인실패 */ %>
<script>
alert("failed")
history(-1);
</script>
<%}%>
<!-- 로그인에 성공할 경우 세션기본객체에 사용자아이디 정보를 memberid속성에 저장
memberid 속성값이 존재한다면 현재 사용자는 인증된 사용자로 처리 -->