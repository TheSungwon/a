<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>

<C:if test="${param.dest == '1'}">
<C:redirect url="EL/useCset.jsp"/>
</C:if>

<C:if test="${param.dest == '2'}">
<C:redirect url="/EL/useCset.jsp"/>
</C:if>

<C:if test="${param.dest == '3'}">
<C:redirect url="/EL/viewTODAY.jsp" context="/EL_JSTL"/>
</C:if>

<C:if test="${param.dest == '4'}">
<C:redirect url="http://www.youtube.com/results">
<C:param name="search_query" value="aaa"/>
</C:redirect></C:if>