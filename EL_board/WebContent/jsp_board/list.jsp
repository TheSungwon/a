<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--
 list.jsp�� p�Ķ���ͷ� �о�� ������ ��ȣ�� ���޹��� ��, ListArticleServiceŬ������
getArticleList()�޼��忡 ����. getArticleList()�޼���� ������ ��ȣ�� ���õ� �����͸� ������
ArticleListModel��ü�� �����ϸ� list.jsp�� ArticlelistModel��ü�� list_view.jsp�� ���� -->

<%@page import="DTO_javaBean.ArticleListModel"%>
<%@page import="service_board.ListArticleService"%>

<%
String pageNumberString = request.getParameter("p"); /* p�Ķ���ͷκ��� �о�� ������ ��ȣ�� ���Ѵ� */
int pageNumber = 1;
if(pageNumberString != null&& pageNumberString.length() > 0){
	pageNumber = Integer.parseInt(pageNumberString);
}

ListArticleService listService = ListArticleService.getInstance();
ArticleListModel articleListModel = listService.getArticleList(pageNumber);
/* listService.getArticleList�� �̿��ؼ� ����ڰ� ��û�� �������� �ش��ϴ� ArticleListModel ��ü���Ѵ� */

request.setAttribute("listModel", articleListModel);

if(articleListModel.getTotalPageCount()>0){
	/* ��������� ȭ�� �ϴܿ� ������ �������̵���ũ�� ���������� ��ȣ�� ����ȣ�� ����ؼ����Ѵ� */
	int beginPageNumber = (articleListModel.getRequestPage() -1) / 3*3+1;
	
	int endPageNumber = beginPageNumber + 2;
	if(endPageNumber > articleListModel.getTotalPageCount()){
		endPageNumber = articleListModel.getTotalPageCount();
	}
	request.setAttribute("beginPage", beginPageNumber);
	request.setAttribute("endPage", endPageNumber);//���������۹�ȣ�� ����ȣ�� request��ü�� �Ӽ���������
}
%>
<jsp:forward page="./list_view.jsp"/> <!-- �ش�jsp�� �������̵� -->
