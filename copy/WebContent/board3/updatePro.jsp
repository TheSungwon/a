<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@page import="board.BoardDBBean"%>
<%@page import ="java.sql.Timestamp"%>

<%
request.setCharacterEncoding("euc-kr");
%>

<jsp:useBean id="article" scope="page" class="board.BoardDataBean">
<jsp:setProperty name="article" property="*"/>
</jsp:useBean>

<% String pageNum = request.getParameter("pageNum");

BoardDBBean dbPro = BoardDBBean.getInstance();
int check = dbPro.updateArticle(article);
if(check == 1){ //1이면 수정
%>

<meta http-equiv="Refresh" content="0;url=list.jsp?pageNum=<%=pageNum%>" >
<!-- /* // 메타태그 수정후 0초후 url로이동 */ -->
<%}else{%>
<script language="javascript">
alert("비번");
history.go(-1);
</script> <%} %>


