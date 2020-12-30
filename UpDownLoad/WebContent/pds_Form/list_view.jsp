<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache");
response.addHeader("Cache-Control", "no-store");
response.setDateHeader("Expires", 1L);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>자료실목록</title>
</head>
<body>

<table border="1">
<c:if test="${listModel.totalPageCount >0 }">
<tr>
	<td colspan="5">
	${listModel.startRow }-${listModel.endRow }
	@@${listModel.requestPage } / ${listModel.totalPageCount }@@ </td></tr></c:if>
	
<tr>
	<td>No.</td>
	<td>file name</td>
	<td>file size</td>
	<td>download count</td>
	<td>download</td>
	</tr>
	
	<c:choose>
	<c:when test="${listModel.hasPdsItem == false }">
	<tr>
		<td colspan="5">
		게시글없음 </td></tr></c:when>
		
	<c:otherwise>
	<c:forEach var="item" items="${listModel.pdsItemList }">
	<tr>
		<td>${item.id }</td>
		<td>${item.fileName }</td>
		<td>${item.fileSize }</td>
		<td>${item.downloadCount }</td>
		<td><a href="/UpDownLoad/pds_jsp/download.jsp?id=${item.id }">download@@</a></td></tr>
	
	</c:forEach>
	
	<tr>
		<td colspan="5">
		<c:if test="${beginPage >3 }">
		<a href="/UpDownLoad/pds_jsp/list.jsp?p=${beginPage-1 }">이전</a></c:if>
		
		<c:forEach var="pno" begin="${beginPage }" end="${endPage }">
		<a href="/UpDownLoad/pds_jsp/list.jsp?p=${pno }"> @${pno }@</a> </c:forEach>
		
		<c:if test="${endPage < listModel.totalPageCount }">
		<a href="/UpDownLoad/pds_jsp/list.jsp?p=${endPage +1 }"> 다음</a> </c:if>
	
	</c:otherwise> </c:choose>
	
	<tr>
		<td colspan="5">
		<a href="/UpDownLoad/pds_Form/uploadForm.jsp"> 파일첨부</a> </td></tr>
</table>


<form> <!-- 	//action값이없으므로 자기자신url로전송 action="list.jsp" method="get" -->
 <select name="searchn">
 <option value="0">No.</option>
 <option value="1">file name</option>
 </select>
 <input type="text" name="search" size="15" maxlength="50" />
 <input type="submit" value="search"/>
</form>


</body>
</html>