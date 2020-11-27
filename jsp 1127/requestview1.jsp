<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=euc-kr" %>
<%-- <%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Map" %> --%>

<% request.setCharacterEncoding("euc-kr"); %> <%--필수 --%>

<html>
<head><title> 요청파라미터 출력</title></head>
<body>
<b>request.getParameter()메소드사용 파라미터의 값</b> <br>
name파라미터 <%= request.getParameter("name") %> <br>

address파라미터 <%= request.getParameter("address") %><br>

<p>
<b> request.getParameterValues()메소드 사용 모든 파라미러의 값을 배열</b>
<%
String[] values = request.getParameterValues("pet");
if(values != null){
	for(int i=0; i<values.length; i++){ %>
		<%=values[i] %>  <% } } %>  <!-- 표현식 -->
		
	<p>
<b> request.getParameterNames() 웹 브라우저가 전송한 파라미터의 이름</b>
<%
Enumeration a = request.getParameterNames();
while(a.hasMoreElements()){
	String name = (String)a.nextElement();%>
	<%= name %>
	<% } %>
	
	<p>
	<b>request.getParameterMap() 웹 브라우저가 전송한 파라미터의 맵
	맵은 <파라미터이름. 값> 쌍으로 구성 </b> <br>
	
<%
Map map = request.getParameterMap();
String[] namePara = (String[])map.get("name");
if(namePara != null){ %>
	name= <%= namePara[0] %> <%} %>




</body>

</html>
