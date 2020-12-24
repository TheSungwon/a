<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!--
 list_view�� list�κ��� ���޹��� ������(articleListModel, beginPage, endPage)�� �̿��ؼ�
���ȭ���� ����. 

list�κ��� ���޹��� ��ü�� �̿��ؼ� �Խñ۸�� �������̵���ũ�� ���
-->

<%-- <%
���������� �Խñ� ����� ĳ���� ��� ���ο� ���� �߰��Ǿ ������ ��Ͽ��� �������������ֱ�
������ ĳ�ð��� ����� ���������ν� ���������� �Խñ۸���� ĳ�������ʵ��� �Ѵ�.

response.setHeader~~ �������� ĳ�û��� *�ε��ӵ� ������
%> --%>


<html>
<head><title> �Խñ۸��</title></head>
<body>
<table border="1">
<c:if test="${listModel.totalPageCount > 0 }">
<tr>
	<td colspan="5">
	${listModel.startRow } - ${listModel.endRow }
	[${listModel.requestPage }/${listModel.totalPageCount }]
	</td></tr></c:if>

<tr>
	<td>No</td>
	<td>TITLE</td>
	<td>WRITER</td>
	<td>DATE</td>
	<td>VIEWS</td>
</tr>

<c:choose>
<c:when test="${listModel.hasArticle == false }">
<tr>
	<td colspan="5">
		�Խñ۾���
		</td></tr></c:when>	
<c:otherwise>
<c:forEach var="article" items="${listModel.articleList }"> 
<tr>
	<td>${article.id }</td>
	<td>
	<c:if test="${article.level > 0 }"> 
	<c:forEach begin="1" end="${article.level }"> - </c:forEach>&gt;
	</c:if>
	
	<c:set var="query" 
	value="articleId=${article.id }&p=${listModel.requestPage }"/>
	<a href="<c:url value="./read.jsp?${query }"/>"> ${article.title }</a>
	</td> 
	
	<td>${article.writerName }</td>
	<td>${article.postingDate }</td>
	<td>${article.readCount }</td></tr> 
</c:forEach>
<tr>
	<td colspan="5">
	<c:if test="${beginPage >3 }"> 
	<a href="<c:url value="./list.jsp?p=${beginPage-1 }"/>">����</a></c:if>

<c:forEach var="pno" begin="${beginPage }" end="${endPage }">
<a href="<c:url value="./list.jsp?p=${pno }"/>"> [${pno }] </a> </c:forEach>

<c:if test="${endPage < listModel.totalPageCount }">
<a href="<c:url value="./list.jsp?p=${endPage +1 }"/>"> ����</a></c:if></td></tr>
</c:otherwise>		
</c:choose>

<tr>
	<td colspan="5">
	<a href="./writeForm.jsp"> �۾���</a>
	</td></tr>
</table></body>
</html>