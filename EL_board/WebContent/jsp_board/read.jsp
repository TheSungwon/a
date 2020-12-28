<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--
 articleId�Ķ���ʹ� ���� �Խñ��� ID���� �����ϰ� p�Ķ���ʹ� �Խñ� �б� ȭ�鿡�� ���ȭ������
���ư� �� ����� ������ ��ȣ���� �����Ѵ�

read.jsp�� ArticleService.readArticle()�޼��带 �̿��ؼ� ������ ID�� �ش��ϴ� Article��ü��
���� �� read_view.jsp �� �̵��ؼ� �б�ȭ���� �����ش�. ���� ������ �Խñ��� �������� �ʾƼ�
ArticleNotFountExcpetion�� �߻��ϸ� article_not_found.jsp�� �̵��ؼ� �Խñ� �������������� ������ -->

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
