<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- update_form.jsp�� ������ Article��ü�� �о�� update_form_view.jsp�� �����ؼ�
�������� ����ϵ��� �Ѵ�-->

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