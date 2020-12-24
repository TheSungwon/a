<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 게시글 목록화면에서 글쓰기 링크를 클릭하면 writeForm 화면으로 이동//글쓰기 입력폼 제공 -->

<%--
 입력폼의 name값을 보면 WritingRequest객체의 프로퍼티 이름과 동일하다.
파라미터 이름과 프로퍼티 이름을 동일하게 한 이유는 <jsp:setProperty>액션태그를 이용해서
파라미터값을 객체에 담기 위함이다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head><title> write</title></head>
<body>
<form action="<c:url value='./write.jsp'/>" method="post">
title::<input type="text" name="title" size="20"/><br/>
writer::<input type="text" name="writerName"/><br/>
password::<input type="password" name="password"/><br/>
content::<br/>
<textarea name="content" cols="40" rows="5"></textarea><br/>
<input type="submit" value="submit"/>
</form>

</body>
</html>