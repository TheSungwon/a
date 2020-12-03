<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page buffer="1kb" autoFlush="false" %>

<html>
<head><title> flush</title></head>

<% for(int i=0; i<1000; i++) { out.println("1234");}%>
</html>