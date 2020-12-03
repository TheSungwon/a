<%@page language="java" contentType="text/html; charset=euc-kr" 
pageEncoding="euc-kr"%>
<%@include file="exBeanColor.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>회원가입</title>
<link href="exBeanCss.css" type="text/css" rel="stylesheet"/>
<script type= "text/javascript" src="exBeanScript.js"></script>
</head>

<body bgcolor="<%= bodyback_c %>">
<form action="exBeanPro.jsp" name="regForm" method="post" onsubmit="return inputCheck()">
	<table border="1" cellpadding="5" cellspacing="0" width="800">
		<colgroup>
			<col width="20%"/>
			<col width="*"/>
			<col width="30%"/>
		</colgroup>
		
		<tr>
			<td colspan="3"><strong>회원가입</strong></td>
		</tr>
		
		<tr>
			<th bgcolor="<%= title_c %>">> ID </th>
			<td bgcolor="<%= value_c %>"><input type="text" name="id" size="20"/></td>
			<td bgcolor="<%= value_c %>">> 아이디입력해 </td>
		</tr>
		
		<tr>
			<th bgcolor="<%= title_c %>">>PS</th>
			<td bgcolor="<%= value_c %>"><input type="password" name="passwd" size="20"/></td>
			<td bgcolor="<%= value_c %>">> 비번입력해 </td>
		</tr>
		
			<tr>
			<th bgcolor="<%= title_c %>">>PS</th>
			<td bgcolor="<%= value_c %>"><input type="password" name="repasswd" size="20"/></td>
			<td bgcolor="<%= value_c %>">> 비번입력해 </td>
		</tr>
		
			<tr>
			<th bgcolor="<%= title_c %>">>NAME</th>
			<td bgcolor="<%= value_c %>"><input type="text" name="name" size="20"/></td>
			<td bgcolor="<%= value_c %>">> 이름입력해 </td>
		</tr>
		
			<tr>
			<th bgcolor="<%= title_c %>">>email</th>
			<td bgcolor="<%= value_c %>"><input type="text" name="email" size="30"/></td>
			<td bgcolor="<%= value_c %>">> 이메일입력해 </td>
		</tr>
		
			<tr>
			<th bgcolor="<%= title_c %>">>tel</th>
			<td bgcolor="<%= value_c %>"><input type="text" name="tel" size="20"/></td>
			<td bgcolor="<%= value_c %>">> 전번입력해 </td>
		</tr>
		
		<tr>
			<td colspan="3" height="50" align="center"><input type="submit" value="회원가입"/></td>
		</tr>
		
	
	</table>
</form>
</body>
</html>