<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "board.*"%>
<%@ page import = "java.util.List" %>
<%@ page import= "java.text.SimpleDateFormat" %>
<%@ include file="./color.jsp" %>

<%! int pageSize = 3; //한 페이지에 보여주는 데이터 행 개수
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //초 단위추가
%>

<%
String pageNum = request.getParameter("pageNum"); //넘어온 pageNum받기
	if(pageNum == null){
		pageNum = "1";
	}

	int currentPage = Integer.parseInt(pageNum); //int값으로 받기
	System.out.println(currentPage); //..? 콘솔창에 현재페이지출력
	
	int startRow = (currentPage * 3) -2; //getArticles 에 ?
	int endRow = currentPage * pageSize;
	int count = 0;
	int number = 0;
	
	List<BoardDataBean> articleList = null;
	BoardDBBean dbPro = BoardDBBean.getInstance();
	count = dbPro.getArticleCount(); //몇 줄인지 count에
	
	if(count > 0){
		articleList = dbPro.getArticle(startRow, endRow); //0보다 클 때 row에 넣어서 articleList로
		
	}
	number = count - (currentPage -1) * pageSize; //11 - (2-1)*3 =8 ..? 연속된 페이지처럼 ?
			
			
%>


<html>
<head>
<title> Board</title>
<link href="style.css" rel="stylesheet" type="text/css">

</head>

<body bgcolor="<%=bodyback_c %>">
<center><b>글(전체 :<%=count %>)</b><!--  //count변수출력 --></center>
<table width="700">
<tr>
	<td align="right" bgcolor="<%=value_c %>">
	<a href="./writeForm.jsp">@@@@@write@@@@</a></td>
	
</table>

<%
if(count == 0){
%>
<table width="700" border="1" cellpadding="0" cellspacing="0">
<tr>
<td align="center"> no posting</td>

</table>
<%}else{ %> <!-- //게시판화면에 보여줄내용 -->
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
<tr height="30" bgcolor="<%=value_c %>">
	<td align="center" width="50"> No. </td>
	<td align="center" width="250"> title. </td>
	<td align="center" width="100"> writer. </td>
	<td align="center" width="150"> date. </td>
	<td align="center" width="50"> Look. </td>
	<td align="center" width="100"> IP </td>
	</tr>

<%
for (int i=0; i<articleList.size(); i++){ //자바빈객체가 들어있는 articleList
	BoardDataBean article = (BoardDataBean)articleList.get(i); ///자바빈객체로 뽑아내기
%>
<tr height="30">
<td align="center" width="50" > <%=number --%> </td> <!-- 1씩 감소해서출력 -->
<td width="250">

<%
int wid = 0; //wid변수생성
if (article.getRe_level() > 0){ //답변글이라면 (1이라면)
	wid= 5*(article.getRe_level()); //5곱
%>
<img src = "images/level.gif" width="<%=wid %>" height="16"> <!-- 투명이미지 -->
<img src = "images/re.gif">
<% }else{ %>
<img src="images/level.gif" width="<%=wid %>" height="16">
<%} %>
<a href="content.jsp?num=<%=article.getNum() %>&pageNum=<%=currentPage %>">
<%=article.getSubject() %></a>  <!-- 제목출력. a태그 글번호 pageNum을 get방식으로 넘기기 -->
<%if(article.getReadcount()>=20){ %> <!-- 조회수20넘으면 hot이미지 -->
<img src="images/hot.gif" border="0" height="16"><%} %></td>
<td align="center" width="100">
<a href="mailto:<%=article.getEmail() %>"><%=article.getWriter() %></a></td><!-- 작성자 -->
<td align="center" width="150"><%=sdf.format(article.getReg_date()) %></td> <!-- 날짜 -->
<td align="center" width="50"><%=article.getReadcount() %></td> <!-- 조회수 -->
<td align="center" width="100"><%=article.getIp() %></td> <!-- IP -->
</tr> <%} %></table><%} %>

<%
if(count > 0){ //페이징
	//전체 페이지 수를 연산
	int pageCount = count / pageSize + ( count % pageSize == 0 ? 0:1); //나머지가 1이 아니면
	int startPage = (int)(currentPage/5)*5+1; //11?
	int pageBlock = 5; // 게시판페이지 12345..999...
	int endPage = startPage + pageBlock-1; // 11+5 -1 ??
			if(endPage > pageCount) endPage = pageCount;
		if(startPage > 5){ //6페이지면%>
<a href="list.jsp?pageNum=<%=startPage - 5 %>">back</a>
<%} for(int i=startPage; i <= endPage; i++){ %>
<a href = "list.jsp?pageNum=<%=i %>"> <%=i %></a>
<%} if(endPage < pageCount){ %>
<a href="list.jsp?pageNum=<%=startPage + 5 %>"> next</a>
<%} } %>


</center>
</body>
</html>
