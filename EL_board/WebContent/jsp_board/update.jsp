<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!-- �Խñ� ���� ������ ������ư�� Ŭ���ϸ� update.jsp�� ���� ��û�� ����
update.jsp�� ���� ��û ������ ���� UpdateRequest��ü�� ������ �� UpdateArticleServiceŬ������
�̿��ؼ� ���� ��û�� ó���Ѵ� 

UpdateArticleServiceŬ������ update�޼��尡 ���������� ����Ǹ� update_success.jsp�� �̿��ؼ�
���� ��� ȭ���� ���
������ ������ ��� update_error.jsp�� �̿��ؼ� ���� ȭ���� ���
-->

<%@page import ="service_board.UpdateArticleService"%>
<%@page import="DTO_javaBean.Article"%>
<%
request.setCharacterEncoding("euc-kr");
%>

<jsp:useBean id="updateRequest" class="DTO_javaBean.UpdateRequest"/>
<jsp:setProperty name="updateRequest" property="*"/>

<%
String viewPage=null;
try{
	Article article = UpdateArticleService.getInstance().update(updateRequest);
	request.setAttribute("updateArticle", article);
	viewPage = "./update_success.jsp";
}catch(Exception e){
	request.setAttribute("updateException", e);
	viewPage = "./update_error.jsp";
}
%>
<jsp:forward page="<%=viewPage %>"/>