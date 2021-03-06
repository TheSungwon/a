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

<% int num =Integer.parseInt(request.getParameter("num")); //list拭辞閤奄
String pageNum = request.getParameter("pageNum"); //list拭辞閤奄

SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

try{ BoardDBBean dbPro = BoardDBBean.getInstance();//board~ 梓端持失
BoardDataBean article = dbPro.getArticle(num); //切郊朔 廃匝 亜閃神奄

int ref = article.getRef();
int re_step = article.getRe_step();
int re_level = article.getRe_level(); //室鯵 襖鎧奄

%>
<body bgcolor="<%=bodyback_c %>">
<center>
<b>びびびびび越鎧遂左奄びびびびびびびび</b></center>
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
	<input type="button" value="呪舛" onclick="document.location.href='updateForm.jsp?num=<%=article.getNum() %>&pageNum=<%=pageNum %>'"><!-- /越腰硲,凪戚走 角奄奄 -->
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="肢薦" onclick="document.location.href='deleteForm.jsp?num=<%=article.getNum() %>&pageNum=<%=pageNum %>'">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="岩越" onclick="document.location.href='writeForm.jsp?num=<%=num %>&ref=<%=ref %>&re_step=<%=re_step %>&re_level=<%=re_level %>'">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="鯉系" onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'"><!-- //越鯉系 適遣 板 蟹神檎 赤揮凪戚走 蒸生檎 湛凪戚走 -->
	</td></tr>
</table>

<%}catch(Exception e){} %>
</form>

</center>
</body>

</html>