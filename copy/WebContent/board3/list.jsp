<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "board.*"%>
<%@ page import = "java.util.List" %>
<%@ page import= "java.text.SimpleDateFormat" %>
<%@ include file="./color.jsp" %>

<%! int pageSize = 3; //�� �������� �����ִ� ������ �� ����
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //�� �����߰�
%>

<%
String search = request.getParameter("search");
String pageNum = request.getParameter("pageNum"); //�Ѿ�� pageNum�ޱ�
int searchn = 0;	

if(pageNum == null){
		pageNum = "1";	//pagenum�� para~���� �� �޾Ҵٸ� 1��������
	}

if(search == null){
	search="";
}else{
	searchn = Integer.parseInt(request.getParameter("searchn"));
}
	int currentPage = Integer.parseInt(pageNum); //int������ �ޱ�
	System.out.println(currentPage); //..? �ܼ�â�� �������������
	
	int startRow = (currentPage * 3) -2; //getArticles �� ?
	int endRow = currentPage * pageSize;
	int count = 0;
	int number = 0;
	
	List<BoardDataBean> articleList = null;
	BoardDBBean dbPro = BoardDBBean.getInstance();
	count = dbPro.getArticleCount(); //�� ������ count��
	
	//
	if(search.equals("") || search == null)
	count = dbPro.getArticleCount(searchn,search);
	
	///////
	CommentDBBean cdb = CommentDBBean.getInstance();
	////////
	if(count > 0){
		if(search.equals("") || search == null)
		articleList = dbPro.getArticles(startRow, endRow); //0���� Ŭ �� row�� �־ articleList��
		else
		articleList = dbPro.getArticles(startRow, endRow,searchn,search);	
	}
	number = count - (currentPage -1) * pageSize; //11 - (2-1)*3 =8 ..? ���ӵ� ������ó�� ?
			
			
%>


<html>
<head>
<title> Board</title>
<link href="style.css" rel="stylesheet" type="text/css">

</head>

<body bgcolor="<%=bodyback_c %>">
<center><b>��(��ü :<%=count %>)</b><!--  //count������� --> </center>
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
<%}else{ %> <!-- //�Խ���ȭ�鿡 �����ٳ��� -->
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
<tr height="30" bgcolor="<%=value_c %>">
	<td align="center" width="50"> No. </td>
	<td align="center" width="250"> title. </td>
	<td align="center" width="100"> writer. </td>
	<td align="center" width="150"> date. </td>
	<td align="center" width="50"> Views. </td>
	<td align="center" width="100"> IP </td>
	</tr>

<%
for (int i=0; i<articleList.size(); i++){ //�ڹٺ�ü�� ����ִ� articleList
	BoardDataBean article = (BoardDataBean)articleList.get(i); ///�ڹٺ�ü�� �̾Ƴ���
	int com_count = cdb.getCommentCount(article.getNum()); //��۰���?
%>
<tr height="30">
<td align="center" width="50" > <%=number --%> </td> <!-- 1�� �����ؼ���� -->
<td width="250">

<%
int wid = 0; //wid��������
if (article.getRe_level() > 0){ //�亯���̶�� (1�̶��)
	wid= 5*(article.getRe_level()); //5��
%>
<img src = "images/level.gif" width="<%=wid %>" height="16"> <!-- �����̹��� -->
<img src = "images/re.gif">
<% }else{ %>
<img src="images/level.gif" width="<%=wid %>" height="16">
<%} %>

<!--  -->
<%if(com_count > 0){%>


<a href="content.jsp?num=<%=article.getNum() %>&pageNum=<%=currentPage %>">
<%=article.getSubject() %>	|<%=com_count %>|</a>  <!-- �������. a�±� �۹�ȣ pageNum�� get������� �ѱ�� -->
<%}else{ %>
<a href="content.jsp?num=<%=article.getNum() %>&pageNum=<%=currentPage %>">
<%=article.getSubject() %></a>
<%} %>

<%if(article.getReadcount()>=20){ %> <!-- ��ȸ��20������ hot�̹��� -->
<img src="images/hot.gif" border="0" height="16"><%} %></td>
<td align="center" width="100">
<a href="mailto:<%=article.getEmail() %>"><%=article.getWriter() %></a></td><!-- �ۼ��� -->
<td align="center" width="150"><%=sdf.format(article.getReg_date()) %></td> <!-- ��¥ -->
<td align="center" width="50"><%=article.getReadcount() %></td> <!-- ��ȸ�� -->
<td align="center" width="100"><%=article.getIp() %></td> <!-- IP -->
</tr> <%} %></table><%} %>
<p>
<%
if(count > 0){ //����¡
	//��ü ������ ���� ����
	int pageCount = count / pageSize + ( count % pageSize == 0 ? 0:1); //�������� 1�� �ƴϸ�
	int startPage = (int)(currentPage/5)*5+1; //11?
	int pageBlock = 5; // �Խ��������� 12345..999...
	int endPage = startPage + pageBlock-1; // 11+5 -1 ??
			if(endPage > pageCount) endPage = pageCount;
		if(startPage > 5){ //6��������
		if(search.equals("") || search == null){%>
		
<a href="list.jsp?pageNum=<%=startPage - 5 %>">back</a>
<%}else{ %>
<a href="list.jsp?pageNum=<%=startPage - 5 %>&search=<%=search%>">back</a>
<%} %>

<%} for(int i=startPage; i <= endPage; i++){ 
if(search.equals("") || search == null){
%>

<a href="list.jsp?pageNum=<%=i %>"><%=i %></a>
<%}else{ %>
<a href="list.jsp?pageNum=<%=i %>&search=<%=search%>&searchn=<%=searchn %>"> <%=i %></a>
<%}%>

<%} if(endPage < pageCount){ 
if(search.equals("") || search == null){%>

<a href="list.jsp?pageNum=<%=startPage + 5 %>"> next</a>
<%}else{ %>
<a href="list.jsp?pageNum=<%=startPage + 5 %>&search=<%=search%>&searchn=<%=searchn%>"> next</a>

<%} } }%>

</p>
<!-- comment -->
<form> <!-- 	//action���̾����Ƿ� �ڱ��ڽ�url������ action="list.jsp" method="get" -->
 <select name="searchn">
 <option value="0">writer</option>
 <option value="1">title</option>
 <option value="2">content</option>
 </select>
 <input type="text" name="search" size="15" maxlength="50" />
 <input type="submit" value="search"/>
</form>
</center>
</body>
</html>
