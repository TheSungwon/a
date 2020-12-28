<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- reply_form.jsp는 게시글 쓰기 입력 폼과 거의 동일. 차이점은 답변 글을 등록할 부모글 ID를 지정 -->

<html>
<head><title> 답변글</title></head>
<body>
<form action="./reply.jsp" method="post">
<input type="hidden" name ="parentArticleId" value="${param.parentId }"/>
<input type="hidden" name="p" value="${param.p }"/>

@TITLE<input type="text" name="title" size="20" value="re]"/><br/>
@WRITER<input type="text" name="writerName"/><br/>
@PASSWORD<input type="password" name="password"/><br/>
@CONTENT<br/>
<textarea rows="5" cols="40" name="content"></textarea><br/>
<input type="submit" value="전송"/>
</form>
</body>
</html>