<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--
 articleId파라미터는 읽을 게시글의 ID값을 전송하고 p파라미터는 게시글 읽기 화면에서 목록화면으로
돌아갈 때 사용할 페이지 번호값을 전송한다

read.jsp는 ArticleService.readArticle()메서드를 이용해서 지정한 ID에 해당하는 Article객체를
구한 뒤 read_view.jsp 로 이동해서 읽기화면을 보여준다. 만약 지정한 게시글이 존재하지 않아서
ArticleNotFountExcpetion이 발생하면 article_not_found.jsp로 이동해서 게시글 존재하지않음을 보여줌 -->

<%@page import="service_board.ReadArticleService" %>
<%@page import="Exception_board.ArticleNotFoundException"%>
<%@page import="DTO_javaBean.Article" %>

<%int articleId = Integer.parseInt(request.getParameter("articleId"));
String viewPage = null;
try{
	Article article = ReadArticleService.getInstance().readArticle(articleId);
	request.setAttribute("article", article);
	viewPage = "./read_view.jsp";
}catch(ArticleNotFoundException e){
	viewPage = "./article_not_found.jsp";
}
%>
<jsp:forward page="<%=viewPage %>"></jsp:forward>
