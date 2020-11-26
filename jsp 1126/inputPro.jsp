<%@ page languate="java" contentType="text/html; charset=euc-kr"
pageEncoding="euc-kr"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">

<title> 회원가입</title>

<link href="style.css" rel="stylesheet" type="text/css"/>

</head>

<body>
<% request.setCharacterEncoding("UTF-8"); %>

<div id="wrap">
	<h1>회원정보</h1>
	<div id="body">
		<table width="500px;">
			<colgroup>
				<col width="20%"/>
				<col width="*"/>
			</colgroup>
			<tr>
				<rh colspan="2" class="subTitle">아이디입력</rh>
			</tr>
			
			<tr>
				<th>사용자아이디</th>
				<td><%=request.getParameter("id") %></td>
			</tr>
			
			<tr>
				<th>비번</th>
				<td><%=request.getParameter("passwd") %></td>
			</tr>
			
			<tr>
				<th colspan="2" class="subTitle">개인정보</th>
			</tr>
			
			<tr>
				<th>사용자이름</th>
				<td><%=request.getParameter("name") %></td>
			</tr>
			
			<tr>
				<th>주민</th>
				<td>
					<%=request.getParameter("jumin1") %></td>
			</tr>
			
			<tr>
				<th>email</th>
				<td><%=request.getParameter("email") %></td>
			</tr>
			
			<tr>
				<th>blog</th>
				<td><%= request.getParameter("blog") %></td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td><%= request.getParameter("zipcode") %></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><%=request.getParameter("address") %></td>
			</tr>
			
			
		</table>
	</div>
	<div id="footer">
	the end
	</div>

</div>
</body>
</html>