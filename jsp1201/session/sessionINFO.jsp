<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=euc-kr" %>
<%-- <%@page session="true"%> 
������ ��� ����. ���� �Ӽ��� �⺻���� true�̹Ƿ� �����ص� ��밡��--%> 

<%
Date time = new Date(); 
/* longŸ���� �ð����� �����ϱ� ���� data��ü���� */
SimpleDateFormat formatter =
	new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* data��ü�� ������ �ð� ���� ������ ������� ����ϱ� ���� ���� */
%>

<html>
<head><title>session inforamtion</title></head>
<body>
���Ǿ��̵� <%= session.getId() %><br> <!-- ���Ǿ��̵���� -->

<% time.setTime(session.getCreationTime()); %> <!-- �����ǻ����ð��� date��ü�� time������ -->

���ǻ����ð�<%=formatter.format(time) %><br>

<% time.setTime(session.getLastAccessedTime()); %>

�ֱ����� <%= formatter.format(time) %>
</body>
</html>
