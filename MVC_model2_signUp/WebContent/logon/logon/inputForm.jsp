<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../color.jspf" %>


<html>
<head>
<meta charset="EUC-KR">
<title>sign up</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="javascript">
function checkIt(){
	var userinput = eval("document.userinput");
	if(!userinput.id.value){
		alert("id");
		return false;
	}
	
	if(!userinput.passwd.value){
		alert("password");
		return false;
	}
	
	if(userinput.passwd.value != userinput.passwd2.value){
		alert("password not same");
		return false;
	}
	
	if(!userinput.name.value){
		alert("name");
		return false;
	}
	
	if(!userinput.jumin1.value || !userinput.jumin2.value){
		alert("jumin");
		return false;
	}
	
	
}


//���̵� �ߺ� �����Ǵ�
function openConfirmid(userinput){
	//���̵� �Է��ߴ���
	if(userinput.id.value == "")	{
		alert("id");
		return;
	}
	
	//url�� ������Է�id ����
	url ="/MVC_model2_signUp/logon/confirmId.do?id=" + userinput.id.value;
	
	//�� â
	open(url, "confirm", "toolbar=no, location=no, status=no, menubar=no, scrollbars=no, resizable=no, width=550, height=200");
		
		
}
</script>
</head>
<body bgcolor="${backc }">

<form method="post" action="/MVC_model2_signUp/logon/inputPro.do" name="userinput" onsubmit="return checkIt()">
<table width="600" border="1" cellspacing="0" cellpadding="3" align="center">
<tr>
	<td colspan="2" height="39" align="center" bgcolor="${valuec }">
	<font size="+1"><b>signUp</b></font></td>></tr>
	
<tr>
	<td width="200" bgcolor="${valuec }" ><b>ID	</b></td>
	<td width="400" bgcolor="${valuec }" >&nbsp;</td>
	</tr>
	
<tr>
	<td width="200">����� ID</td>
	<td width="400">
		<input type="text" name="id" size="10" maxlength="12">
		<input type="button" name="confirm_id" value="�ߺ�" onclick="openConfirmid(this.form)"></td></tr>



 <tr> 
      <td width="200"> ��й�ȣ</td>
      <td width="400" > 
        <input type="password" name="passwd" size="15" maxlength="12">
      </td>
    <tr>  
      <td width="200">��й�ȣ Ȯ��</td>
      <td width="400"> 
        <input type="password" name="passwd2" size="15" maxlength="12">
      </td>
    </tr>
    
    <tr> 
      <td width="200" bgcolor="${value_c}"><b>�������� �Է�</b></td>
      <td width="400" bgcolor="${value_c}">&nbsp;</td>
    <tr>  
    <tr> 
      <td width="200">����� �̸�</td>
      <td width="400"> 
        <input type="text" name="name" size="15" maxlength="10">
      </td>
    </tr>
    <tr> 
      <td width="200">�ֹε�Ϲ�ȣ</td>
      <td width="400"> 
        <input type="text" name="jumin1" size="7" maxlength="6">
        -<input type="text" name="jumin2" size="7" maxlength="7">
      </td>
    </tr>
    <tr> 
      <td width="200">E-Mail</td>
      <td width="400"> 
        <input type="text" name="email" size="40" maxlength="30">
      </td>
    </tr>
    <tr> 
      <td width="200"> Blog</td>
      <td width="400"> 
        <input type="text" name="blog" size="60" maxlength="50">
      </td>
    </tr>
    <tr> 
      <td colspan="2" align="center" bgcolor="${valuec}"> 
          <input type="submit" name="confirm" value="��   ��" >
          <input type="reset" name="reset" value="�ٽ��Է�">
          <input type="button" value="���Ծ���" onclick="document.location.href='/MVC_model2_signUp/logon/main.do'">
      </td>
    </tr>
  </table>
</form>
</body>
</html>