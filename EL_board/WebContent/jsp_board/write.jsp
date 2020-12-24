<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--
 �۾��� �Է������� �� ������ �Է��� �� submitŬ���ϸ� write.jsp�� �Խñ� �����͸� �����Ѵ�
write.jsp�� ��û ������ ���� WritingRequest��ü�� ������ �� 
WriteArticleService.write()�޼��带 ������ �� 
WritingRequest��ü�� �����ؼ� �۾��� ����� �����Ѵ�. -->

<%@ page import="service_board.WriteArticleService"%>
<%@page import="DTO_javaBean.Article"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("euc-kr");%>

<jsp:useBean id="writingRequest" class="DTO_javaBean.WritingRequest"/>
<jsp:setProperty name="writingRequest" property="*"/> 
<!-- �۾����û������ ���� WritingRequest��ü���� -->

<%
Article postedArticle = WriteArticleService.getInstance().write(writingRequest);
/* WriteArticleService.write()�� WritingRequest��ü ���� */

request.setAttribute("postedArticle", postedArticle);
%>

<html>
<head><title> �Խñ��ۼ�</title></head>
<body>
�Խñ� ���
<br/>
<a href="<c:url value='./list.jsp'/>"> LIST</a>
<a href="<c:url value='./read.jsp?articleId=${postedArticle.id }'/>">READ</a>
</body>
</html>