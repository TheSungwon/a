<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=euc-kr" %>
<%-- <%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Map" %> --%>

<% request.setCharacterEncoding("euc-kr"); %> <%--�ʼ� --%>

<html>
<head><title> ��û�Ķ���� ���</title></head>
<body>
<b>request.getParameter()�޼ҵ��� �Ķ������ ��</b> <br>
name�Ķ���� <%= request.getParameter("name") %> <br>

address�Ķ���� <%= request.getParameter("address") %><br>

<p>
<b> request.getParameterValues()�޼ҵ� ��� ��� �Ķ�̷��� ���� �迭</b>
<%
String[] values = request.getParameterValues("pet");
if(values != null){
	for(int i=0; i<values.length; i++){ %>
		<%=values[i] %>  <% } } %>  <!-- ǥ���� -->
		
	<p>
<b> request.getParameterNames() �� �������� ������ �Ķ������ �̸�</b>
<%
Enumeration a = request.getParameterNames();
while(a.hasMoreElements()){
	String name = (String)a.nextElement();%>
	<%= name %>
	<% } %>
	
	<p>
	<b>request.getParameterMap() �� �������� ������ �Ķ������ ��
	���� <�Ķ�����̸�. ��> ������ ���� </b> <br>
	
<%
Map map = request.getParameterMap();
String[] namePara = (String[])map.get("name");
if(namePara != null){ %>
	name= <%= namePara[0] %> <%} %>




</body>

</html>
