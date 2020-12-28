<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!-- 게시글 수정 폼에서 수정버튼을 클릭하면 update.jsp로 수정 요청을 전송
update.jsp는 수정 요청 정보를 담은 UpdateRequest객체를 생성한 뒤 UpdateArticleService클래스를
이용해서 수정 요청을 처리한다 

UpdateArticleService클래스의 update메서드가 정상적으로 실행되면 update_success.jsp를 이용해서
수정 결과 화면을 출력
수정이 실패할 경우 update_error.jsp를 이용해서 에러 화면을 출력
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