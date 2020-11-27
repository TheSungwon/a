<%@ page contentType="text/hrml; charset=utf-8"%>
<%@ page pageEncoding="euc-kr"%>
<%@ page import="java.util.Date"%>
<!-- jsp는 euc-kr -pageEncoding
브라우저는 utf-8 - charset-->

<%Date now = new Date();%>
<html>
<head><title>시간</title></head>
<body>
현재<%= now %>
</body>
</html>