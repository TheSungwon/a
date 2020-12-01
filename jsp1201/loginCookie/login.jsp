<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import = "javaCookie.javaCookieBox" %>

<%
String id = request.getParameter("id");
String password = request.getParameter("password");

if(id.equals(password)){ /* id와 password가 같으면 로그인에 성공 */
	response.addCookie(
			javaCookieBox.createCookies("LOGIN","SUCCESS","/",-1) );
/* 이름이 LOGIN이고 값이 SUCCESS인 쿠키를 생성. 로그인 상태인지 여부를 판단할때사용 */
	response.addCookie(
			javaCookieBox.createCookies("ID",id,"/",-1));
/* 이름이 ID이고 입력한 아이디를 값으로 갖는 쿠키를 생성. 로긍니한 사용자의 아이디를 참조할때 사용 */
%>

<html>
<head><title>로그인성공</title></head>
<body>
성공
</body>
</html>

<%
} else{ /* 로그인실패 */
%>
<script>
alert("실패")
history.go(-1);
</script>
<%} %>




