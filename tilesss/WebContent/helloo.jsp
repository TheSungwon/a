<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<% request.setAttribute("greeting", "HI"); %>    

<tiles:insertDefinition name="hello"></tiles:insertDefinition>

