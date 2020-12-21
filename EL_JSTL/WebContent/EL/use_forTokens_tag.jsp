<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head><title>forTokens tag
</title></head>
<body>
콤마와 점을 구분자로 사용 <br>
<C:forTokens items="aaa,sssss.dddddd.ffffffff,zzzzzz,xxxxx.ccccccc" delims=",." var="token">
${token }</C:forTokens>
</body>
</html>