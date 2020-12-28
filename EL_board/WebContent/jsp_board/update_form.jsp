<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- update_form.jsp는 수정할 Article객체를 읽어와 update_form_view.jsp에 전달해서
수정폼을 출력하도록 한다-->

<%@page import ="service_board.ReadArticleService"%>
<%@page import ="DTO_javaBean.Article" %>
<%@page import="Exception_board.ArticleNotFoundException" %>
<%String viewPage = null;
try{
	int articleId = Integer.parseInt(request.getParameter("articleId"));
	Article article = ReadArticleService.getInstance().getArticle(articleId);
	viewPage = "./update_form_view.jsp";
	request.setAttribute("article", article);
}catch(ArticleNotFoundException e){
	viewPage = "./article_not_found.jsp";
}
%>
<jsp:forward page="<%=viewPage %>"/>