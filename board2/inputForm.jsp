<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@include file="./color.jsp"%>
<html>
<head>
<title>ȸ������</title>
<link href="style.css" rel="stylesheet" type="text/css">

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script><!-- ���� -->
<script language="javascript">
/* �������� API */
<!-- !!�߿�. - autoload=false �� �ݵ�� �����ּž� �մϴ�.-->
function execPostCode(){
    daum.postcode.load(function(){
        new daum.Postcode({
            oncomplete: function(data) {
            	var addr='';
            	if(data.userSelectedType === 'R'){
            		addr = data.roadAddress;
            	}else{
            		addr = data.jibunAddress;
            	}
            	document.getElementById('userZipcode').value = data.zonecode;
            	document.getElementById('userAddress').value = addr;
            	document.getElementById('userAddress').focus();
            }
        }).open();
    });
}
/*  */

/* zipcode */
  function zipCheck(){
	url="ZipCheck.jsp?check=y";
	window.open(url,"post","toolbar=no ,width=500, height=300, directories=no, status=yes, scrollbars=yes, menubar=no");
}
/*  */
function checkIt(){
	var userinput=eval("document.userinput");
	if(!userinput.id.value){
		alert("���̵��Է�");
		return false;
	}
	
	if(!userinput.passwd.value){
		alert("����Է�");
		return false;
	}
	if(userinput.passwd.value != userinput.passwd2.value){
		alert("��� �����ϰ�");
		return false;
	}
	if(!userinput.name.value){
		alert("������̸�");
		return false;
	}
	if(!userinput.jumin1.value || !userinput.jumin2.value){
		alert("�ֹ� ��ȣ�Է�");
		return false;
	}
}

function openConfirmid(userinput){
	if(userinput.id.value == ""){
		alert("id�Է�");
		return;
		
	}
	url="confirmId.jsp?id=" + userinput.id.value;
	open(url,"confirm","toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300, height=200");
	
}
</script>
</head>
<body bgcolor="<%=bodyback_c%>">

<form method="post" action="./inputPro.jsp" name="userinput" onSubmit="return checkIt()">
<table width="600" border="1" cellspacing="0" cellpadding="3" align="center" >
    <tr>
    <td colspan="2" height="39" align="center" bgcolor="<%=value_c%>" >
       <font size="+1" ><b>ȸ������</b></font></td>
    </tr>
    <tr>
      <td width="200" bgcolor="<%=value_c%>"><b>���̵� �Է�</b></td>
      <td width="400" bgcolor="<%=value_c%>"> </td>
    </tr> 

    <tr>
      <td width="200"> ����� ID</td>
      <td width="400">
        <input type="text" name="id" size="10" maxlength="12">
        <input type="button" name="confirm_id" value="ID�ߺ�Ȯ��" OnClick="openConfirmid(this.form)">
      </td>
    </tr>
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
      <td width="200" bgcolor="<%=value_c%>"><b>�������� �Է�</b></td>
      <td width="400" bgcolor="<%=value_c%>"> </td>
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
    <!-- zipcode -->    <!-- ���� api -->
    <tr>
    	<td width="200">zipcdoe</td>
    	<td><input type="text" name="zipcode" size="7" id="userZipcode">
    	<input type="button" value="�����ȣ" onclick="zipCheck()">
    	<input type="button" value="��������" onclick="execPostCode()">
    	search1</td></tr>
    <tr> <tr>
    <td> address</td>
    <td><input type="text" name="address" size="70" id="userAddress">
    address1</td></tr>
    
    <!--  -->
    


    	
    <tr>
      <td colspan="2" align="center" bgcolor="<%=value_c%>">
          <input type="submit" name="confirm" value="��   ��" >
          <input type="reset" name="reset" value="�ٽ��Է�">
          <input type="button" value="���Ծ���" onclick="javascript:window.location='main.jsp'">
      </td>
    </tr>
  </table>
</form>
</body>
</html>