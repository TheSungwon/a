<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- reply_form.jsp�� �Խñ� ���� �Է� ���� ���� ����. �������� �亯 ���� ����� �θ�� ID�� ���� -->

<html>
<head><title> �亯��</title></head>
<body>
<form action="./reply.jsp" method="post">
<input type="hidden" name ="parentArticleId" value="${param.parentId }"/>
<input type="hidden" name="p" value="${param.p }"/>

@TITLE<input type="text" name="title" size="20" value="re]"/><br/>
@WRITER<input type="text" name="writerName"/><br/>
@PASSWORD<input type="password" name="password"/><br/>
@CONTENT<br/>
<textarea rows="5" cols="40" name="content"></textarea><br/>
<input type="submit" value="����"/>
</form>
</body>
</html>