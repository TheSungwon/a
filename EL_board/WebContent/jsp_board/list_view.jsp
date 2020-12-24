<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!--
 list_view는 list로부터 전달받은 데이터(articleListModel, beginPage, endPage)를 이용해서
목록화면을 생성. 

list로부터 전달받은 객체를 이용해서 게시글목록 페이지이동링크를 출력
-->

<%-- <%
웹브라우저가 게시글 목록을 캐싱할 경우 새로운 글이 추가되어도 새글이 목록에서 보이지않을수있기
때문에 캐시관련 헤더를 설정함으로써 웹브라우저가 게시글목록을 캐싱하지않도록 한다.

response.setHeader~~ 생략가능 캐시생성 *로딩속도 빠르게
%> --%>


<html>
<head><title> 게시글목록</title></head>
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
		게시글없음
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
	<a href="<c:url value="./list.jsp?p=${beginPage-1 }"/>">이전</a></c:if>

<c:forEach var="pno" begin="${beginPage }" end="${endPage }">
<a href="<c:url value="./list.jsp?p=${pno }"/>"> [${pno }] </a> </c:forEach>

<c:if test="${endPage < listModel.totalPageCount }">
<a href="<c:url value="./list.jsp?p=${endPage +1 }"/>"> 다음</a></c:if></td></tr>
</c:otherwise>		
</c:choose>

<tr>
	<td colspan="5">
	<a href="./writeForm.jsp"> 글쓰기</a>
	</td></tr>
</table></body>
</html>