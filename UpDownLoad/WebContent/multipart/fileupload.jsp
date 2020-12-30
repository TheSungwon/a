<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>

<html>
<head><title> upload</title></head>
<body>
<%
//1. multipart/form-data 여부확인
boolean isMultipart = ServletFileUpload.isMultipartContent(request);
if(isMultipart){
	//2.메모리가 파일 업로드 보관하는 FileItem의 Factory설정
	DiskFileItemFactory factory = new DiskFileItemFactory();
	
	//3.업로드 요청을 처리하는 ServletFileUpload 생성
	ServletFileUpload upload = new ServletFileUpload(factory);
	
	//4.업로드 요청 파싱해서 FileItem목록 구함
	List<FileItem> items = upload.parseRequest(request);
	
	Iterator<FileItem> iter = items.iterator();
	while(iter.hasNext()){
		FileItem item = iter.next();
		//FileItem이 폼 입력 항목인지 여부에 따라 알맞은 처리
		if(item.isFormField()){
			String name = item.getFieldName();
			String value = item.getString("euc-kr"); %>
요청파라미터 <%=name %> = <%=value %> <br/>			
			<%
		}else{
			String name = item.getFieldName();
			String fileName= item.getName();
			String contentType = item.getContentType();
			boolean isInMemory = item.isInMemory();
			long sizeBytes = item.getSize();
			%>
			
파일 <%=name %> , <%=fileName %> , <%=sizeBytes %>
<%= isInMemory ? "메모리저장" : "임시파일저장" %><br/>			
			
			<%
		}
	}
}else{
	//multipart/form아님
%>
multipart/form요청 아님
<%} %>
</body>
</html>