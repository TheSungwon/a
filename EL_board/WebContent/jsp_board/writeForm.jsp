<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- �Խñ� ���ȭ�鿡�� �۾��� ��ũ�� Ŭ���ϸ� writeForm ȭ������ �̵�//�۾��� �Է��� ���� -->

<%--
 �Է����� name���� ���� WritingRequest��ü�� ������Ƽ �̸��� �����ϴ�.
�Ķ���� �̸��� ������Ƽ �̸��� �����ϰ� �� ������ <jsp:setProperty>�׼��±׸� �̿��ؼ�
�Ķ���Ͱ��� ��ü�� ��� �����̴�. --%>
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