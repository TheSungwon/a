<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import ="board.*"%>
<%@ page import = "java.sql.Timestamp"%>
<%@ page import="java.text.*"%> 
<%@ page import="java.util.*"%>
<%@ include file="color.jsp"%> 

<%
String id=(String) session.getAttribute("memIdd");
LogonDBBean dbPro = LogonDBBean.getInstance();  
LogonDataBean a = dbPro.getMemberList(id);
try{
%>


<html>
<head>
<title>회원 목록</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="<%=bodyback_c%>"> 
<b>글목록</b>
<table width="1000">

<table border="1" width="1000" cellpadding="0" cellspacing="0" align="center">
    <tr height="30" bgcolor="<%=value_c%>">
      <td align="center"  width="50"  >번 호</td>
      <td align="center"  width="100" >ID</td>
      <td align="center"  width="100" >이름</td>
      <td align="center"  width="150" >주민번호</td>
      <td align="center"  width="150" >이메일</td>
      <td align="center"  width="50" >우편번호</td>  
      <td align="center"  width="150" >주소</td> 
      <td align="center"  width="100" >가입일</td>
      <td align="center"  width="50" >비밀번호</td>
      <td align="center"  width="100" >
      수정/삭제
      </td>
    </tr>
    <table>
  <td align="center"  width="100" ><%=a.getId()%></td></table>
<%}catch(Exception e){}%>
</body>
</html>