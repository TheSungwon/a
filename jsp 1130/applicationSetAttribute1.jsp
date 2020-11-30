<%@ page contentType="text/html; charset=euc-kr" %>
<%
	String a= request.getParameter("a");
	String b= request.getParameter("b");
	
	if(a != null && b!= null){
		application.setAttribute(a,b); 
		
	}
	%>
	
	<html>
	<head><title> application setAttribute</title></head>
	<body>
	<%
	if(a != null && b != null){
		out.println("application 기본객체의 속성설정");
		out.println(a);
		out.println(b);
	} else{ out.println("aplications 기본객체속성설정 안함");
		
	}
	%>
	</body>
	
	</html>
	
	<!-- http://localhost:9001/JSP/jsp%201130/applicationSetAttribute1.jsp?a=hello&b=word -->