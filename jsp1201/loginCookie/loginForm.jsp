<%@ page contentType="text/html; charset=euc-kr" %>
<html>
<head><title> 로그인폼</title></head>
<body>
<form action = "<%= request.getContextPath() %>/jsp1201/loginCookie/login.jsp"
method = "post" >
아이디 <input type = "text" name = "id" size = "10">
암호 <input type = "password" name= "password" size="10">

<input type="submit" value="로그인">

<!-- 로그인 버튼을 누르면 login.jsp로 입력한 데이터 전송.  -->


</form>
</body>
</html>