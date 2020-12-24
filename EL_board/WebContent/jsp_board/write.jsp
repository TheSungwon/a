<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--
 글쓰기 입력폼에서 글 내용을 입력한 뒤 submit클릭하면 write.jsp로 게시글 데이터를 전송한다
write.jsp는 요청 정보를 담은 WritingRequest객체를 생성한 뒤 
WriteArticleService.write()메서드를 실행할 때 
WritingRequest객체를 전달해서 글쓰기 기능을 실행한다. -->

<%@ page import="service_board.WriteArticleService"%>
<%@page import="DTO_javaBean.Article"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("euc-kr");%>

<jsp:useBean id="writingRequest" class="DTO_javaBean.WritingRequest"/>
<jsp:setProperty name="writingRequest" property="*"/> 
<!-- 글쓰기요청정보를 담은 WritingRequest객체생성 -->

<%
Article postedArticle = WriteArticleService.getInstance().write(writingRequest);
/* WriteArticleService.write()에 WritingRequest객체 전달 */

request.setAttribute("postedArticle", postedArticle);
%>

<html>
<head><title> 게시글작성</title></head>
<body>
게시글 등록
<br/>
<a href="<c:url value='./list.jsp'/>"> LIST</a>
<a href="<c:url value='./read.jsp?articleId=${postedArticle.id }'/>">READ</a>
</body>
</html>