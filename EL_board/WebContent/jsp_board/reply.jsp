<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- reply_fomr.jsp 결과화면에서 전송버튼을 누르면 reply.jsp로 답변쓰기 요청 전송한다
reply.jsp는 ReplyArticleService클래스의 reply()메서드를 이용해서 답변글 등록 -->

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