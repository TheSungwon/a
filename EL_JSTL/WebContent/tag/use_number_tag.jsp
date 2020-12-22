<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head><title> numberFormat tag</title></head>
<body>
<c:set var="price" value="1000000"/>
<fmt:formatNumber value="${price }" type="number" var="numberType"/> <br/>

��ȭ <fmt:formatNumber value="${price }" type="currency" currencySymbol="��"/> <br/>

�ۼ�Ʈ <fmt:formatNumber value="${price }" type="percent" groupingUsed="false"></fmt:formatNumber><br/>

���� ${numberType } <br/>

����<fmt:formatNumber value="${price }" pattern="000000.00"></fmt:formatNumber>

</body>
</html>