<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head><title>forTokens tag
</title></head>
<body>
�޸��� ���� �����ڷ� ��� <br>
<C:forTokens items="aaa,sssss.dddddd.ffffffff,zzzzzz,xxxxx.ccccccc" delims=",." var="token">
${token }</C:forTokens>
</body>
</html>