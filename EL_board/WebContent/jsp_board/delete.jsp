<%@page import="service_board.DeleteArticleService"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!-- 삭제 폼 화면에서 암호를 입력한 뒤 삭제버튼을 클릭하면 삭제 요청이 delete.jsp에 전송
delete.jsp는 삭제 요청 정보를 담은 DeleteRequest객체를 생성한 뒤 DeleteArticleService의
delete()메서드를 실행해서 삭제 요청을 처리 -->

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