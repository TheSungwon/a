<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=euc-kr" %>
<%-- <%@page session="true"%> 
세션을 사용 지정. 세션 속성의 기본값이 true이므로 생략해도 사용가능--%> 

<%
Date time = new Date(); 
/* long타입의 시간값을 저장하기 위해 data객체생성 */
SimpleDateFormat formatter =
	new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* data객체가 저장한 시간 값을 지정한 양식으로 출력하기 위해 생성 */
%>

<html>
<head><title>session inforamtion</title></head>
<body>
세션아이디 <%= session.getId() %><br> <!-- 세션아이디출력 -->

<% time.setTime(session.getCreationTime()); %> <!-- 세션의생성시간을 date객체인 time에저장 -->

세션생성시간<%=formatter.format(time) %><br>

<% time.setTime(session.getLastAccessedTime()); %>

최근접속 <%= formatter.format(time) %>
</body>
</html>
