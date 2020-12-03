<%@page language="java" contentType="text/html; charset=euc-kr"
pageEncoding="euc-kr"%>
<%@include file="exBeanColor.jsp" %>
<%request.setCharacterEncoding("euc-kr"); %>
<jsp:useBean id="regBean" class="BEAN.exBeanJava"></jsp:useBean>
<jsp:setProperty name="regBean" property="*"/>

<html>
<head>
<meta http-equive="Content-Type" content="text/html; charset=euc-kr">

<title>회원가입</title>
<link href="exBeanCss.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="exBeanScript.js"></script>
</head>
<body bgcolor="<%= bodyback_c %>">
<table border="1" cellpadding="5" cellspacing="0" width="800">
	<colgroup>
		<col width="20%"/>
		<col width="*"/>
	</colgroup>
		
	<tr>
		<td colspan="3"><strong>회원가입</strong></td>
	</tr>
	
	<tr>
		<th bgcolor="<%= title_c %>"> ID</th>
		<td bgcolor="<%= value_c %>"><jsp:getProperty property="id" name="regBean"/></td>
	</tr>
	
	<tr>
		<th bgcolor="<%= title_c %>"> PASSWORD</th>
		<td bgcolor="<%= value_c %>"><jsp:getProperty property="passwd" name="regBean"/></td>
	</tr>
	
	<tr>
		<th bgcolor="<%= title_c %>"> PASSWORD</th>
		<td bgcolor="<%= value_c %>"><jsp:getProperty property="repasswd" name="regBean"/></td>
	</tr>
	
	<tr>
		<th bgcolor="<%= title_c %>"> NAME</th>
		<td bgcolor="<%= value_c %>"><jsp:getProperty property="name" name="regBean"/></td>
	</tr>
	<tr>
		<th bgcolor="<%= title_c %>"> EMAIL</th>
		<td bgcolor="<%= value_c %>"><jsp:getProperty property="email" name="regBean"/></td>
	</tr>
	<tr>
		<th bgcolor="<%= title_c %>"> TELE</th>
		<td bgcolor="<%= value_c %>"><jsp:getProperty property="tel" name="regBean"/></td>
	</tr>
</head>
</html>