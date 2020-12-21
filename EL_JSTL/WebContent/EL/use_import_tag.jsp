<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="C"	uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("euc-kr");
%>

<C:choose>
<C:when test="${param.type == 'flickr' }">
<C:import url="https://www.flickr.com/search">
<C:param name="f" value="ht"/>
<C:param name="q" value="보라매공원"/>
</C:import></C:when>

<C:when test="${param.type == 'youtube' }">
<C:import url="https://www.youtube.com/results">
<C:param name="search_query" value="ezen"/>
</C:import></C:when>

<C:otherwise>
<C:import url="use_import_tag_help.jsp">
<C:param name="message" value="선택"/>
</C:import>
</C:otherwise></C:choose>

