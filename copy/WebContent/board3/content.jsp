<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import = "board.*"%>
<%@ page import ="java.text.SimpleDateFormat"%>
<%@ include file="./color.jsp"%>

<html>
<head>
<title> BOARD</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<% int num =Integer.parseInt(request.getParameter("num")); //list�����ޱ�
String pageNum = request.getParameter("pageNum"); //list�����ޱ�

SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

try{ BoardDBBean dbPro = BoardDBBean.getInstance();//board~ ��ü����
BoardDataBean article = dbPro.getArticle(num); //�ڹٺ� ���� ��������

int ref = article.getRef();
int re_step = article.getRe_step();
int re_level = article.getRe_level(); //���� ������

%>
<body bgcolor="<%=bodyback_c %>">
<center>
<b>�ӤӤӤӤӱ۳��뺸��ӤӤӤӤӤӤӤ�</b></center>
<br><form>
<table width="500" border="1" cellspacing="0" cellpadding="0" bgcolor="<%=bodyback_c %>" align="center">
<tr height="30">
	<td align="center" width="125" bgcolor="<%=value_c %>">*NUMBER*</td>
	<td align="center" width="125" align="center">
	<%=article.getNum() %></td>
	
	<td align="center" width="125" bgcolor="<%=value_c %>">*views*</td>
	<td align="center" width="125" align="center">
	<%=article.getReadcount() %></td>
</tr>	
<tr height="30">
	<td align="center" width="125" bgcolor="<%=value_c %>">*writer*</td>
	<td align="center" width="125" align="center">
	<%=article.getWriter() %></td>
	
	<td align="center" width="125" bgcolor="<%=value_c %>">*date</td>
	<td align="center" width="125" align="center">
	<%=sdf.format(article.getReg_date()) %></td>
	</tr>
	<tr height="30">
	<td align="center" width="125" bgcolor="<%=value_c %>">*title*</td>
	<td align="center" width="125" align="center" colspan="3">
	<%=article.getSubject() %></td>
	</tr>
	<tr>
	<td align="center" width="125" bgcolor="<%=value_c %>"> *contents* </td>
	<td align="left" width="375" colspan="3"><pre><%=article.getContent() %></pre></td></tr>
	
	<tr height="30">
	<td colspan="4" bgcolor="<%=value_c %>" align="right">
	<input type="button" value="����" onclick="document.location.href='updateForm.jsp?num=<%=article.getNum() %>&pageNum=<%=pageNum %>'"><!-- /�۹�ȣ,������ �ѱ�� -->
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="����" onclick="document.location.href='deleteForm.jsp?num=<%=article.getNum() %>&pageNum=<%=pageNum %>'">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="���" onclick="document.location.href='writeForm.jsp?num=<%=num %>&ref=<%=ref %>&re_step=<%=re_step %>&re_level=<%=re_level %>'">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="���" onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'"><!-- //�۸�� Ŭ�� �� ������ �ִ������� ������ ù������ -->
	</td></tr>
</table>

<%}catch(Exception e){} %>
</form>

</center>
</body>

</html>