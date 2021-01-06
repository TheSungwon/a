<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import = "java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import= "DTO.Theme" %>
<%@page import="DAO.ThemeManager" %>
<%@page import= "Exception.ThemeManagerException"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%! static int PAGE_SIZE=5; %>
<% String pageNum = request.getParameter("page");
if(pageNum == null) pageNum = "1";
int currentPage = Integer.parseInt(pageNum);

String[] searchCond = request.getParameterValues("search_cond");
String searchKey = request.getParameter("search_key");

List whereCond = null;
Map whereValue = null;

boolean searchCondName = false;
boolean searchCondTitle = false;

if(searchCond != null && searchCond.length >0 && searchKey != null){
	 whereCond = new java.util.ArrayList();
     whereValue = new java.util.HashMap();
	
	for(int i=0; i<searchCond.length; i++){
		if(searchCond[i].equals("name")){
			whereCond.add("NAME =?");
			whereValue.put(new Integer(1), searchKey);
			searchCondName = true;
			
		}else if(searchCond[i].equals("title")){
			whereCond.add("TITLE LIKE '%"+searchKey+"%'");
			searchCondTitle = true;
		}
	}
}

ThemeManager manager = ThemeManager.getInstance();
List list = null;
int count = manager.count(whereCond, whereValue);

int totalPageCount =0; //전체 페이지 개수 저장
int startRow = 0;
int endRow = 0; //시작행 끝행 개수 구한다
if(count >0){
	totalPageCount = count / PAGE_SIZE;
	if(count % PAGE_SIZE >0) totalPageCount++;
	
	startRow = (currentPage -1) * PAGE_SIZE+1;
	endRow = currentPage * PAGE_SIZE;
	if(endRow > count) endRow = count;
	
	list = manager.selectList(whereCond, whereValue, startRow-1, endRow-1);
}else{
	list=java.util.Collections.EMPTY_LIST;
}
%>

<c:set var="list" value="<%=list %>"/>
<c:if test="<%=searchCondTitle || searchCondName %>">
검색[
<c:if test="<%=searchCondTitle %>"> title</c:if>
<c:if test="<%=searchCondName %>" >name </c:if>
=${param.search_key }]

</c:if>

<c:if test="<%=count > 0 %>">
<table width="100%" cellpadding="1" cellspacing="2">
<tr>
	<td align="right">
	<b> <%=startRow %>-<%=endRow %> / <%=count %><b>
	</b></td></tr>
</table>
</c:if>

<table width="100%"	 cellpadding="1" cellspacing="2">
<tr>
	<td bgcolor="#e9e9e9"><b>image</b></td>
	<td bgcolor="#e9e9e9"><b>title</b></td>
	<td bgcolor="#e9e9e9"><b>writer</b></td>
	<td bgcolor="#e9e9e9"><b>date</b></td> </tr>
	
<c:if test="${empty list }">
<tr>
	<td bgcolor="#f0f0f0" colspan="4" align="center">
	no image </td> </tr> </c:if>
	
<c:if test="${! empty list }">
<c:forEach var="theme" items="${list }">
	<td bgcolor="#f0f0f0">
	<td><c:if test="${! empty theme.image }">
	<% Theme theme = (Theme)pageContext.getAttribute("theme"); %>
	<img src="imageBoard/WebContent/image/${theme.image }.small.jpg" width="50">
	</c:if></td>
	
	<td> <a href="javascript:goView(${theme.id })">${theme.title }</a></td>
	<td>${theme.name }</td>
	<td><fmt:formatDate value="${theme.register }" pattern="yy-MM-dd hh:mm:ss"/>
	</td></c:forEach></c:if>
	
<tr>
	<td colspan="4" align="right"> <a href="writeForm.jsp"> image </a></td></tr>
</table>

<script language="javascript">
function goPage(pageNo){
	document.move.action="list.jsp";
	document.move.page.value=pageNo;
	document.move.submit();
}

function goView(id){
	document.move.action="read.jsp";
	document.move.id.value=id;
	document.move.submit();
	
}
</script>

<c:set var="count" value="<%=Integer.toString(count) %>"/>
<c:set var="PAGE_SIZE" value="<%=Integer.toString(PAGE_SIZE) %>"/>
<c:set var="currentPage" value="<%=Integer.toString(currentPage) %>"/>

<c:if test="${count >0}">
	<c:set var="pageCount" value="${count/PAGE_SIZE + (count % PAGE_SIZE==0 ? 0:1)}"/>
	<c:set var="startPage"value="${currentPage-(currentPage % 10)+1 }"/>
	<c:set var="endPage" value="${startPage+10 }"/>
	
	<c:if test="${endPage > pageCount }">
		<c:set var="endPage" value="${pageCount }"/>
		</c:if>
	<c:if test="${starPage >10 }">
	<a href="javascript:goPage(${startPage -10 })"> 이전</a>
	</c:if>
	<c:forEach var="pageNo" begin="${startPage }" end="${endPage }">
		<c:if test="${currentPage ==pageNo}"> <b></c:if>
		<a href="javascript:goPage(${pageNo })">[${pageNo }]</a>
		<c:if test="${currentPage == pageNo }"></b> </c:if></c:forEach>
		<c:if test="${endPage < pageCount }">
		<a href="javascript:goPage(${startPage+10 })">다음</a></c:if></c:if>
		

<form name="move" method="post">
<input type="hidden" name="id" value=""	>
<input type="hidden" name="page" value="${currentPage }">

<c:if test="<%=searchCondTitle %>">
<input type="hidden" name="search_cond" value="title"> </c:if>

<c:if test="${! empty param.search_key }">
<input type="hidden" name="search_key" value="${param.search_key }"> </c:if>
</form>		


<form name="serach" action="list.jsp" method="post">
<input type="checkbox" name="search_cond" value="title">title
<input type="checkbox" name="search_cond" value="name" > name
<input type="text" name="search_key" value="" size="10">
<input type="submit" value="검색">
<input type="button" value="전체목록" onClick="location.href='list.jsp?page=1'">

</form>