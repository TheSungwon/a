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
<!-- comment script 추가 -->
<script>
function writeSave(){
	if(document.comment.commentt.value == ""){
		alert("작성자입력");
		document.comment.commentt.focus();
		return false;
	}
}
</script>

</head>

<% int num =Integer.parseInt(request.getParameter("num")); //list에서받기
String pageNum = request.getParameter("pageNum"); //list에서받기

int pageSize=3;//댓글페이징
String cPageNum = request.getParameter("cPageNum");
if(cPageNum == null){
	cPageNum = "1";
}
int cCurrentPage = Integer.parseInt(cPageNum);
int startRow = (cCurrentPage * 3) -2;
int endRow = cCurrentPage * pageSize;
/////////////////////
SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

try{ BoardDBBean dbPro = BoardDBBean.getInstance();//board~ 객체생성
BoardDataBean article = dbPro.getArticle(num); //자바빈 한줄 가져오기


CommentDBBean cdb = CommentDBBean.getInstance();
ArrayList comments = cdb.getComments(article.getNum(), startRow, endRow); //댓글내용

int count = cdb.getCommentCount(article.getNum()); //댓글이몇개있는지

int ref = article.getRef();
int re_step = article.getRe_step();
int re_level = article.getRe_level(); //세개 꺼내기

%>
<body bgcolor="<%=bodyback_c %>">
<center>
<b>ㅣㅣㅣㅣㅣ글내용보기ㅣㅣㅣㅣㅣㅣㅣㅣ</b></center>
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
	<input type="button" value="수정" onclick="document.location.href='updateForm.jsp?num=<%=article.getNum() %>&pageNum=<%=pageNum %>'"><!-- /글번호,페이지 넘기기 -->
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="삭제" onclick="document.location.href='deleteForm.jsp?num=<%=article.getNum() %>&pageNum=<%=pageNum %>'">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="답글" onclick="document.location.href='writeForm.jsp?num=<%=num %>&ref=<%=ref %>&re_step=<%=re_step %>&re_level=<%=re_level %>'">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="목록" onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'"><!-- //글목록 클릭 후 나오면 있던페이지 없으면 첫페이지 -->
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
	<input type="submit" value="comment달기"></p></td></tr>

</form>
</table>

<%if(count >0){ %> <!-- 댓글수가 0보다 크면 -->
<p> <table width="500" border="0" cellspacing="0" cellpadding="0" bgcolor="<%=bodyback_c %>" align="center">
	<tr>
		<td>comment No <%=comments.size() %>
	</td></tr>
	<%for(int i =0; i<comments.size(); i++){
	CommentDataBean dbc = (CommentDataBean)comments.get(i); //자바빈
	%>
	
	<tr>
		<td align="left" size="250" bgcolor="<%=value_c %>">
		&nbsp; <b><%=dbc.getCommenter() %>&nbsp;님</b> (<%=sdf.format(dbc.getReg_date()) %>)</td>
		
		<td align="right" size="250" bgcolor="<%=value_c %>">IP: <%=dbc.getIp() %>&nbsp;
		<a href="delCommentForm.jsp?ctn=<%=dbc.getContent_num() %>&cmn=<%=dbc.getComment_num() %>&p_num=<%=pageNum %>"> DELETE</a>&nbsp;</td></tr>
		
	<tr><td colspan="2"><%=dbc.getCommentt() %><td>
	<%} %></td></tr>
</table>

<table width="500" border="0" cellspacing="0" cellpadding="0" bgcolor="<%=bodyback_c %>" align="center">
<tr>
<!--페이징  -->
<%if(count > 0) { //전체페이지수 연산? 
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