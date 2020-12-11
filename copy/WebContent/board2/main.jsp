<%@ page contentType="text/html; charset=euc-kr" %>
<%@ include file ="color.jsp"%>
<html>
<head>
<title>메인</title>
<link href="style.css" rel="stylesheet" type="text/css">
<!--  -->
<% String cookie="";
	Cookie[] cookies = request.getCookies(); //쿠키생성
	if(cookies !=null && cookies.length >0)
		for(int i=0; i<cookies.length; i++){
			if(cookies[i].getName().equals("userId"))
				cookie=cookies[i].getValue();
		}
			
%>


<% try{
	if(session.getAttribute("memId")==null){%>
<script language="javascript">
function focusIt(){
document.inform.id.focus();}

function checkIt(){
	inputForm=eval("document.inform")};
	if(!inputForm.id.value){
		alert("아이디입력");
	inputForm.id.focus();
	return false;
	}
	if(!inputForm.passwd.value){
		alert("아이디입력");
		inputForm.passwd.focus();
		return false;
	}
	

</script>
</head>
<body onLoad="focusIt();" bgcolor="<%=bodyback_c %>">
<table width=500	 cellpadding="0" cellspacing="0" align="center" border="1">
<tr>
<td width="300" bgcolor="<%=bodyback_c %>" height="20">
&nbsp;
</td>

<form name="inform" method="post" action="./loginPro.jsp" onSubmit="return checkIt();">

<td bgcolor="<%=title_c %>" width="100" align="right" > ID </td>
<td width="100" bgcolor="<%=value_c %>">
<input type="text" name="id" size="15" maxlength="10" > </td>
</tr>

<tr>
<td rowspan="2" bgcolor="<%=bodyback_c %>" width="300" > main </td>
<td bgcolor="<%=title_c %>" width="100" align="right" > password	 </td>
<td width="100" bgcolor="<%= value_c%>">
<input type="password" name="passwd" size="15" maxlength="10" > </td>
</tr>
<tr>

<td colspan="3" bgcolor="<%=title_c %>" align="center">
<input type="submit" name="Submit" value="login" >
<input type="button" value="회원가입" onclick="javascript:window.location='inputForm.jsp'">
<input type="checkbox" name="checkbox" ><font size=1 color=orange>아이디저장</font>
</td>
</form>

</table>
<%}else{%>
<table width=500 cellpadding="0" cellspacing="0" align="center" border="1">
<tr>
<td width="300" bgcolor="<%=bodyback_c %>" height="20"> zz</td>
<td rowspan="3" bgcolor="<%=value_c %>" align="center">
<%=session.getAttribute("memId")  %>님이 <br> 방문
<form method="post" action="./logout.jsp">
<input type="submit" value="logout">
<input type="button" value="정보변경" onclick="javascript:window.location='modify.jsp'">
</form></td></tr>
<tr>
<td rowspan="2" bgcolor="<%=bodyback_c %>" width="300" > main</td></tr>
</table>
<br> <%}}catch(NullPointerException e){} %>
</body>


</html>