<%@page contentType="text/html; charset=euc-kr"%>

<html>
<head><title>EL</title></head>
<body>
<h3>����ǥ������</h3>
<p>�����ڸ� ����� ���� ���尴ü�� ��� ��

<table border="1">
<thead>
	<td><b>ǥ����</b>
	<td><b>��</b></td>
	</thead>
	
	<tr>
	<td>\${2+5 }</td>
	<td>${2+5 }</td>
	</tr>
	<tr>
	<td>\${4/5 }</td>
	<td>${4/5 }</td>
	</tr>
	<tr>
	<td>\${5 div 6 }</td>
	<td>${5 div 6 }</td>
	</tr>
	
	<tr>
	<td>\${2<3 }</td>
	<td>${2<3 }</td>
	</tr>
	
	<tr>
	<td>\${2 gt 3 }</td>
	<td>${2 gt 3 }</td>
	</tr>
	
	<tr>
	<td>\${3.1 le 3.2 }</td>
	<td>${3.1 le 3.2 }</td>
	</tr>
	<tr>
	<td>\${(5>3)?5:3 }</td>
	<td>${(5>3)?5:3 }</td>
	</tr>
	
	<tr>
	<td>\${header.host. }</td>
	<TD>${header.host}</TD>
	</tr>
	
	<tr>
	<td>\${header.["user-agent"] }</td>
	<TD>${header["user-agent"]}</TD>
	</tr>

</table>
</body>
</html>