<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- read.jsp로부터 전달받은 article객체를 이용해서 읽기화면 생성 -->    

<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title> 글 읽기</title>
</head>
<body>
<table>
<tr>
	<td>TITLE</td>
	<td>${article.title }</td> </tr>
	
<tr>
	<td>WRITER</td>
	<td>${article.writerName }</td></tr>
<tr>
	<td>DATE</td>
	<td><fmt:formatDate value="${article.postingDate }" pattern="yy-MM-dd hh:mm:ss"/></td> </tr>
	
<tr>
	<td>ㄴ ㅐ용</td>
	<td>
		<pre><c:out value="${article.content }"/></pre></td></tr>
		<!-- pre태그는 입력한 내용의 공백이나 줄바꿈문자를 화면에 그대로출력해준다
		c:out태그를 이용해서 article.content를 출력 -->
	
<tr>
	<td colspan="2">
	<a href="./list.jsp?p="${param.p }">LIST@@</a>
	<a href="./reply_form.jsp?parentId=${article.id }&p=${param.p }">답변쓰기</a>
	<a href="./update_form.jsp?articleId=${article.id }&p=${param.p}">UPDATE</a>
	<a href="./delete_form.jsp?articleId=${article.id }">DELETE</a>
	 </td> </tr>
</table>
</body>
</html>