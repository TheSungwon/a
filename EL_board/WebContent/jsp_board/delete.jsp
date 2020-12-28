<%@page import="service_board.DeleteArticleService"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!-- ���� �� ȭ�鿡�� ��ȣ�� �Է��� �� ������ư�� Ŭ���ϸ� ���� ��û�� delete.jsp�� ����
delete.jsp�� ���� ��û ������ ���� DeleteRequest��ü�� ������ �� DeleteArticleService��
delete()�޼��带 �����ؼ� ���� ��û�� ó�� -->

<%
request.setCharacterEncoding("euc-kr");
%>

<jsp:useBean id="deleteRequest" class="DTO_javaBean.DeleteRequest" />
<jsp:setProperty property="*" name="deleteRequest"/>

<%
String viewPage = null;
try{
	DeleteArticleService.getInstance().deleteArticle(deleteRequest);
	viewPage = "./delete_success.jsp";
}catch(Exception e){
	request.setAttribute("deleteException", e);
	viewPage = "./delete_error.jsp";
}
%>
<jsp:forward page="<%=viewPage %>"></jsp:forward>