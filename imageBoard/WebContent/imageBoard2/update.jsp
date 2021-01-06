<%@page import="fileUpload.FileUploadRequestWrapper"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.io.File" %>
<%@page import ="org.apache.commons.fileupload.FileItem" %>
<%@page import="Image.ImageUtil" %>
<%@page import="DTO.Theme" %>
<%@page import="DAO.ThemeManager" %>
<%@page import="Exception.ThemeManagerException"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% FileUploadRequestWrapper requestWrap = new FileUploadRequestWrapper(request, -1, -1, "C:\\Users\\sungw\\Desktop\\Java\\imageBoard\\WebContent");
HttpServletRequest temRequest = request;
request = requestWrap; %>

<jsp:useBean id="theme" class="DTO.Theme" >
<jsp:setProperty name="theme"	 property="*"/></jsp:useBean>

<%
ThemeManager manager = ThemeManager.getInstance();
Theme oldTheme = manager.select(theme.getId());

if(theme.getPassword() == null || oldTheme.getPassword().compareTo(theme.getPassword()) ==0){
	//암호가 같은경우 처리
	FileItem imageFileItem = requestWrap.getFileItem("imageFile");
	String image ="";
	
	if(imageFileItem.getSize() >0){
		int idx = imageFileItem.getName().lastIndexOf("\\");
		
		if(idx == -1){
			idx = imageFileItem.getName().lastIndexOf("/");
		}
		
		image= imageFileItem.getName().substring(idx+1);
		
		//이미지를 지정한 경로에 저장
		File imageFile = new File("C:\\Users\\sungw\\Desktop\\Java\\imageBoard\\WebContent\\image",image);
		
		//같은이름 파일처리
		if(imageFile.exists()){
			for(int i=0; true; i++){
				imageFile = new File("C:\\Users\\sungw\\Desktop\\Java\\imageBoard\\WebContent\\image","("+i+")"+image);
				
				if(!imageFile.exists()){
					image = "("+i+")"+image;
					break;
					
				}
				
			}
		}
		
		imageFileItem.write(imageFile);
		
		//썸넬생성
		File destFile = new File("C:\\Users\\sungw\\Desktop\\Java\\imageBoard\\WebContent\\image",image+".small.jpg");
		ImageUtil.resize(imageFile, destFile, 50, ImageUtil.RATIO);
	}
	
	if(image.equals("")){
		theme.setImage(oldTheme.getImage());
	}else{
		theme.setImage(image);
		
	}
	manager.update(theme);
%>


<html>
<head>
<meta charset="EUC-KR">
<title>update</title>
</head>
<body>

<c:set var="search_cond" value='<%=requestWrap.getParameter("serach_cond") %>'/>
<c:set var="pageNo" value='<%=requestWrap.getParameter("page") %>'/>
<c:set var="search_key" value='<%=requestWrap.getParameter("serach_key") %>'/>

<form name="move"method="post">
<input type="hidden" name="page"value="${pageNo }">
<c:forEach var="searchCond"items="${search_cond }">
	<c:if test="${searchCond == 'title' }">
	<input type="hidden"name="search_cond"value="title">
	</c:if>
	<c:if test="${searchCond =='name' }">
	<input type="hidden" name="search_cond"value="name"></c:if></c:forEach>
	
	<c:if test="${!empty search_key }">
	<input type="hidden" name="search_key"value="${search_key }"></c:if>

</form>

<script language="javascript">
alert("update");
document.move.action="list.jsp";
document.move.submit();

</script>
</body>
</html>
<%}else{ %>
<script>
alert("password");
history.go(-1);
</script>
<%}%>