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
code에 변수저장 line3

cdoe변수값에 따라 이동 페이지 line 6-11

선택한페이지로 이동 line15 -->