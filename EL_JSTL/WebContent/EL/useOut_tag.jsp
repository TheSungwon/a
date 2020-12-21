<%@page contentType="text/html; charset=euc-kr"%>
<%@page import="java.io.IOException, java.io.FileReader"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>소스</title></head>
<body>
<%
FileReader reader = null;
try{
	String path = request.getParameter("path");
	reader = new FileReader(getServletContext().getRealPath(path));
%>
<pre>
소스= <%=path %>
<c:out value="<%=reader %>" escapeXml="true"/>
</pre>
<%}catch(IOException e){ %>

error <%=e.getMessage() %>
<%}finally{
	if(reader != null)
	try{reader.close();}
	catch(IOException e){} }%>
</body>
</html>
<!-- ?path=/EL/useOut_tag.jsp 추가 -->