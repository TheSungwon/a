<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import ="java.util.*"%>
<%@ page import ="board.*"%>

<%request.setCharacterEncoding("euc-kr"); 
String check = request.getParameter("check");
String area3 = request.getParameter("area3");

LogonDBBean manager = LogonDBBean.getInstance();
Vector zipcodeList = manager.zipcodeRead(area3);
int totalList = zipcodeList.size();
%>


<html>
<head>
<title>����˻�</title>
<link href="style.css" rel="stylesheet" type="text/css">

<script>
function dongCheck(){
	if (document.zipForm.area3.value == ""){
		alert("���̸�");
		document.zipForm.area3.focus();
		return; //�ƹ��͵��Է¾��ϰ� Ŭ��������
	}
	document.zipForm.submit();
}

function sendAddress(zipcode, area1, area2, area3, area4){
	var address = area1+ " " + area2 + " " + area3+ " " +area4;
	opener.document.userinput.zipcode.value=zipcode;
	opener.document.userinput.address.value=address; //
	self.close();
}
</script>
</head>
<body bgcolor="#ffffcc">
<center> <b>�����ȣã��</b></center>
<table>
<form name="zipForm" method="post" action="./ZipCheck.jsp">
	<tr>
		<td><br> ���̸� �Է�=
		<input name="area3" type="text">
		<input type="button" value="search" onclick="dongCheck();">
		</td></tr>
		<input type="hidden" name="check" value="n"> 
</form>

<%if(check.equals("n")){%>
<%	if(zipcodeList.isEmpty()){
%><tr> <td align="center"><br> �˻��������</td></tr><%}else{ %>
<tr><td align="center"><br>�˻� �� �Ʒ� �����ȣ�� Ŭ���ϸ� �ڵ��Է�</td></tr>
<%
for (int i=0; i<totalList; i++){
	ZipcodeBean zipbean =(ZipcodeBean)zipcodeList.elementAt(i);
	String temZ = zipbean.getZipcode();
	String temA1 = zipbean.getArea1();
	String temA2 = zipbean.getArea2();
	String temA3 = zipbean.getArea3();
	String temA4 = zipbean.getArea4();

%> <tr><td>
<a href="javascript:sendAddress('<%=temZ %>','<%=temA1 %>','<%=temA2 %>','<%=temA3 %>','<%=temA4 %>')">
<%=temZ %>&nbsp; <%=temA1 %>&nbsp;<%=temA2 %>&nbsp; <%=temA3 %>&nbsp; <%=temA4 %></a><br>
<%}}} %>
</td></tr>
<tr><td align="center"> <br> <a href="javascript:this.close();">�ݱ�</a><tr></td>
</table>
</center>
</body>


</html>