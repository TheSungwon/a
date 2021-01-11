<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check == 1 }">
<meta http-equiv="Refresh"   content="0;url=/MVC_model2_signUp/mvc/list.do?pageNum=${pageNum }">
</c:if>

<c:if test="${check == 0 }">
password <br>
<a href="javascript:history.go(-1)"> delete form</a></c:if>