<%@ page languate="java" contentType="text/html; charset=euc-kr"
pageEncoding="euc-kr"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">

<title> ȸ������</title>

<link href="style.css" rel="stylesheet" type="text/css"/>

</head>

<body>
<% request.setCharacterEncoding("UTF-8"); %>

<div id="wrap">
	<h1>ȸ������</h1>
	<div id="body">
		<table width="500px;">
			<colgroup>
				<col width="20%"/>
				<col width="*"/>
			</colgroup>
			<tr>
				<rh colspan="2" class="subTitle">���̵��Է�</rh>
			</tr>
			
			<tr>
				<th>����ھ��̵�</th>
				<td><%=request.getParameter("id") %></td>
			</tr>
			
			<tr>
				<th>���</th>
				<td><%=request.getParameter("passwd") %></td>
			</tr>
			
			<tr>
				<th colspan="2" class="subTitle">��������</th>
			</tr>
			
			<tr>
				<th>������̸�</th>
				<td><%=request.getParameter("name") %></td>
			</tr>
			
			<tr>
				<th>�ֹ�</th>
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
				<th>�����ȣ</th>
				<td><%= request.getParameter("zipcode") %></td>
			</tr>
			<tr>
				<th>�ּ�</th>
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