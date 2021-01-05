<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page errorPage="../error/error_view.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>테마개개ㅓㄹ리</title>
<style>
A{color:blue; font-weight: bold; text-decoration: none}
A:hover {
	color:blue; font-weight: bold; text-decoration: underline}
</style>
</head>
<body>

<table width="100%" border="1" cellpadding="2" ceelspacing="0">
<tr>
	<td>
	<jsp:include page="./top.jsp" flush="false"></jsp:include></td></tr>
	
<tr>
	<td>
		<jsp:include page="${param.CONTENTPAGE }" flush="false"></jsp:include></td></tr>
		
<tr>
	<td>
		<jsp:include page="./bottom.jsp" flush="false"></jsp:include></td></tr>
		

</table>

</body>
</html>