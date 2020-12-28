<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- update_form_view는 request속성을 전달받은 Article 객체를 이용해서 수정 폼을 생성 -->

<html>
<head><title>수정</title></head>
<body>
<form action="./update.jsp" method="post">
<input type="hidden" name="articleId" value="${article.id }"/>
<input type="hidden" name="p" value="${param.p }"/>

title update <input type="text" name="title" size="20" value="${article.title }"/><br/>
password update <input type="password" name="password"/><br/>
content update <br/>
<textarea rows="5" cols="40" name="content">${article.content }</textarea> <br/>
<input type="submit" value="수정"/>
</form>
</body>
</html>