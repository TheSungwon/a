<%@ page contentType="text/html; charset=euc-kr" %>
<%-- <%@ page errorPage = "./errorMessage.jsp"%> --%>

<html>
<head><title> parameter</title></head>
<body>
name 파라미터 값 <%= request.getParameter("name").toUpperCase()%>
</body>
</html>

<!--
에러가 발생할 경우 errorM~.jsp 페이지를 보여주도록 지정 2라인

name 파라미터의 값을 대문자로 변환하여 출력. name파라미터가 존재하지 않을경우
예외가 발생 -->