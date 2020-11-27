<%@ page contentType="text/html; charset=euc-kr"%>
<%@ page import = "java.io.*"%>
<%@ page import = "java.net.URL" %>

<html>
<head><title>기본객체사용하여 자원읽기</title></head>
<body>
<%
String path = "/jsp 1127/notice.txt";

BufferedReader br = null;
char[] buff= new char[512];
int len = -1;

try{
	URL url = application.getResource(path);
	
	br = new BufferedReader(new InputStreamReader(url.openStream()));
	
	while( (len=br.read(buff)) != -1){
		out.print(new String(buff,0,len));
	}
}catch(IOException e){
	out.println(e.getMessage());
}finally{
	if(br != null)
		try{br.close();
		}catch(IOException e){}
		
}
%>
</body>
</html>