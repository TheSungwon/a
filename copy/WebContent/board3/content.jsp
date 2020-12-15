<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import = "board.*"%>
<%@ page import ="java.text.SimpleDateFormat"%>
<%@page import = "java.util.ArrayList"  %>
<%@ include file="./color.jsp"%>

<html>
<head>
<title> BOARD</title>
<link href="style.css" rel="stylesheet" type="text/css">
<!-- comment script 蓄亜 -->
<script>
function writeSave(){
	if(document.comment.commentt.value == ""){
		alert("拙失切脊径");
		document.comment.commentt.focus();
		return false;
	}
}
</script>

</head>

<% int num =Integer.parseInt(request.getParameter("num")); //list拭辞閤奄
String pageNum = request.getParameter("pageNum"); //list拭辞閤奄

int pageSize=3;//奇越凪戚臓
String cPageNum = request.getParameter("cPageNum");
if(cPageNum == null){
	cPageNum = "1";
}
int cCurrentPage = Integer.parseInt(cPageNum);
int startRow = (cCurrentPage * 3) -2;
int endRow = cCurrentPage * pageSize;
/////////////////////
SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

try{ BoardDBBean dbPro = BoardDBBean.getInstance();//board~ 梓端持失
BoardDataBean article = dbPro.getArticle(num); //切郊朔 廃匝 亜閃神奄


CommentDBBean cdb = CommentDBBean.getInstance();
ArrayList comments = cdb.getComments(article.getNum(), startRow, endRow); //奇越鎧遂

int count = cdb.getCommentCount(article.getNum()); //奇越戚護鯵赤澗走

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



</form>

<!-- comment html -->
<form method = "post" action = "./contentPro.jsp" name="comment" onsubmit="return writeSave()">
<tr bgcolor="<%=value_c %>" align="center">
	<td> commentSSSS </td>
	<td colspan=2>
		<textarea name="commentt" rows="6" cols="40" ></textarea>
		<input type="hidden" name="content_num" value=<%=article.getNum() %>>
		<input type="hidden" name="p_num" value=<%=pageNum %>>
		<input type="hidden" name="comment_num" value=<%=count+1 %>> </td>
		
	<td align = "center"> commenteRRRRR<br>
	<input type="text" name="commenter" size="10"><br>
	passworDDD
	<input type="password" name="passwd" size="10"><p>
	<input type="submit" value="comment含奄"></p></td></tr>

</form>
</table>

<%if(count >0){ %> <!-- 奇越呪亜 0左陥 滴檎 -->
<p> <table width="500" border="0" cellspacing="0" cellpadding="0" bgcolor="<%=bodyback_c %>" align="center">
	<tr>
		<td>comment No <%=comments.size() %>
	</td></tr>
	<%for(int i =0; i<comments.size(); i++){
	CommentDataBean dbc = (CommentDataBean)comments.get(i); //切郊朔
	%>
	
	<tr>
		<td align="left" size="250" bgcolor="<%=value_c %>">
		&nbsp; <b><%=dbc.getCommenter() %>&nbsp;還</b> (<%=sdf.format(dbc.getReg_date()) %>)</td>
		
		<td align="right" size="250" bgcolor="<%=value_c %>">IP: <%=dbc.getIp() %>&nbsp;
		<a href="delCommentForm.jsp?ctn=<%=dbc.getContent_num() %>&cmn=<%=dbc.getComment_num() %>&p_num=<%=pageNum %>"> DELETE</a>&nbsp;</td></tr>
		
	<tr><td colspan="2"><%=dbc.getCommentt() %><td>
	<%} %></td></tr>
</table>

<table width="500" border="0" cellspacing="0" cellpadding="0" bgcolor="<%=bodyback_c %>" align="center">
<tr>
<!--凪戚臓  -->
<%if(count > 0) { //穿端凪戚走呪 尻至? 
int pageCount = count / pageSize + (count%pageSize == 0?0:1);
int startPage = (int)(cCurrentPage/5)*5+1;
	int pageBlock =5 ;
int endPage = startPage + pageBlock-1;
if(endPage > pageCount) endPage = pageCount;
if(startPage > 5){ %>
<a href ="content.jsp?num=<%=num %>&pageNum=<%=pageNum %>&cPageNum=<%=startPage-5 %>">Back</a>
<%}for(int i = startPage; i<= endPage; i++){ %>
<a href="content.jsp?num=<%=num %>&pageNum=<%=pageNum %>&cPageNum=<%=i %>"> [<%=i %>]</a>
<%}if(endPage < pageCount) {%>
<a href="content.jsp?num=<%=num %>&pageNum=<%=pageNum %>&cPageNum=<%=startPage + 5 %>">Next</a>

<%}}} %>

</table>
<%}catch(Exception e){} %>
</center>
</body>

</html>