<%@ page contentType = "text/html; charset=euc-kr"%>

<%! public int aaa(int a, int b){
int c = a*b;
return c; } %> <!-- 선언부 메소드 -->

<html>
<head><title>선언부</title></head>
<body>
111*11 = <%= aaa(111,11) %></body>
</html>