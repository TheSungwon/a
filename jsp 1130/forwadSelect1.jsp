<%@page contentType="text/html; charset=euc-kr"%>
<%
String code = request.getParameter("code");
String viewPageURI=null;

if (code.equals("A")){
viewPageURI="/jsp 1130/Module/a.jsp";
}else if (code.equals("B")){
viewPageURI="/jsp 1130/Module/b.jsp";
}else if (code.equals("c")){
viewPageURI="/jsp 1130/Module/c.jsp";
}
%>

<jsp:forward page="<%=viewPageURI%>"/>
<!-- 
code�� �������� line3

cdoe�������� ���� �̵� ������ line 6-11

�������������� �̵� line15 -->