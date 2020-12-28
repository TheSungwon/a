<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- reply_fomr.jsp ���ȭ�鿡�� ���۹�ư�� ������ reply.jsp�� �亯���� ��û �����Ѵ�
reply.jsp�� ReplyArticleServiceŬ������ reply()�޼��带 �̿��ؼ� �亯�� ��� -->

<%@page import="service_board.ReplyArticleService"%>
<%@page import="DTO_javaBean.Article"%>
<%request.setCharacterEncoding("euc-kr");%>

<jsp:useBean id="replyingRequest" class="DTO_javaBean.ReplyingRequest"/>
<jsp:setProperty name="replyingRequest" property="*"/>

<%String viewPage = null;
try{
Article postedArticle = ReplyArticleService.getInstance().reply(replyingRequest);
request.setAttribute("postedArticle", postedArticle);
viewPage ="./reply_success.jsp";
}catch(Exception e){
	viewPage = "./reply_error.jsp";
	request.setAttribute("replyException", e);
}
%>
<jsp:forward page="<%=viewPage%>"/>