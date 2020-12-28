<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- read.jsp�κ��� ���޹��� article��ü�� �̿��ؼ� �б�ȭ�� ���� -->    

<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title> �� �б�</title>
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
	<td>�� ����</td>
	<td>
		<pre><c:out value="${article.content }"/></pre></td></tr>
		<!-- pre�±״� �Է��� ������ �����̳� �ٹٲ޹��ڸ� ȭ�鿡 �״��������ش�
		c:out�±׸� �̿��ؼ� article.content�� ��� -->
	
<tr>
	<td colspan="2">
	<a href="./list.jsp?p="${param.p }">LIST@@</a>
	<a href="./reply_form.jsp?parentId=${article.id }&p=${param.p }">�亯����</a>
	<a href="./update_form.jsp?articleId=${article.id }&p=${param.p}">UPDATE</a>
	<a href="./delete_form.jsp?articleId=${article.id }">DELETE</a>
	 </td> </tr>
</table>
</body>
</html>