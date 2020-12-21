<%@page contentType="text/html; charset=euc-kr"%>

<html>
<head><title>EL</title></head>
<body>
<h3>간단표현언어예제</h3>
<p>연산자를 사용한 예와 내장객체의 사용 예

<table border="1">
<thead>
	<td><b>표현식</b>
	<td><b>값</b></td>
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