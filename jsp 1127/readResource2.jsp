<%@ page contentType="text/html; charset=euc-kr"%>
<%@ page import = "java.io.*" %>
<html>
<head><title>기본객체사용하여 자원읽기</title></head>
<body>
<%
String resourcePath = "/jsp 1127/notice.txt";
%>
자원 실제경로 <br>
<%= application.getRealPath(resourcePath) %><br>

----<br>
<%= resourcePath %> 의 내용<br>
---<br>

<%
BufferedReader br = null;
char[] buff = new char[512];
int len=-1;

try{
	br=new BufferedReader( 
			new InputStreamReader(application.getResourceAsStream(resourcePath)));
	while( (len = br.read(buff)) != -1) {
		out.print(new String(buff,0,len));
	}
}catch(IOException e){
	out.println(e.getMessage());
}finally{
	if(br != null) try{br.close();} catch(IOException e){}
}
%>
</body>
</html>