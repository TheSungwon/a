<%@ page contentType="text/html; charset=euc-kr"%>
<%@ page import="java.io.*" %>

<html>
<head><title>절대경로사용하여 자원읽기</title></head>
<body>
<%
FileReader aa=null;
char[] buff = new char[512];
int len = -1;

try{
	aa=new FileReader(
			"C:\\Users\\sungw\\Desktop\\Java\\WebPjt\\WebContent\\jsp 1127\\notice.txt");
	
	while( (len=aa.read(buff)) != -1){
		out.print(new String(buff,0,len));
	}
			
} catch(IOException e){
	out.println(e.getMessage());
}finally{
	if(aa != null) try {aa.close();} catch(IOException e){}
}
%>

</body>

</html>