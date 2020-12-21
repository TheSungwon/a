<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@page import="java.util.HashMap" %>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <%
 HashMap<String,Object> mapData = new HashMap<String,Object>();
 mapData.put("name", "ezen");
 mapData.put("today", new java.util.Date());
 %>
 
<C:set var="intArray" value="<%=new int[] {1,2,3,4,5}%>"/>
<C:set var="map" value="<%=mapData %>"/>
<html>
<head>
<title>for each tag</title>
<body>
<h4> 1~100까지 홀수합</h4>
<C:set var="sum" value="0"/>
<C:forEach var="i" begin="1" end="100" step="2">
<C:set var="sum" value="${sum+i }"/>
</C:forEach>
결과 ${sum }

<ul>
<h4> 구구단4단</h4>
<C:forEach var="i" begin="1" end="9">
<li>4*${i } = ${4*i }
</li></C:forEach>
</ul>

<h4>Map</h4>
<C:forEach var="i" items="${map }">
${i.key }=${i.value }<br>
</C:forEach>
</body>
</head>
</html>
