<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--
     폼에서 업로드 버튼 클릭하면 선택한 파일이 upload.jsp로 전송
    다음 과정을 거쳐서 업로드 파일 등록
FileUpload API를 이용해서 업로드 한 파일 정보를 담은 FileItem을 구한다.

Fileitem.getInputStream()으로 구한 InputStream을 FileSaveHelper에 전달하여 업로드 한 파일을 저장

FileItem으로부터 파일명 파일 크기를 구하고 FileSaveHelper의 save()메서드가 리턴한 실제 저장 경로를
이용해서 AddRequest 객체를 만든다.

AddRequest객체를 AddPdsItemService의 add()메서드에 전달하여 업로드 한 파일 정보를 DB에 삽입한다 -->

<%@page import="pds_Service.AddPdsItemService" %>
<%@page import="pds_Service.FileSaveHelper" %>
<%@page import="pds_DTO.AddRequest" %>
<%@page import="pds_DTO.PdsItem" %>

<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>

<%
boolean isMultipart = ServletFileUpload.isMultipartContent(request);
if(!isMultipart){
	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	return;
}

DiskFileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload upload = new ServletFileUpload(factory);
List<FileItem> items = upload.parseRequest(request);
AddRequest addRequest = new AddRequest();

Iterator<FileItem> iter = items.iterator();
while(iter.hasNext()){
	FileItem item = iter.next();
	if(item.isFormField())		{
		String name = item.getFieldName();
		if(name.equals("description")){
			String value = item.getString();
			addRequest.setDescription(value);
		}
	}else{
		String name = item.getFieldName();
		if(name.equals("file")){
			String realPath = FileSaveHelper.save("C:\\Users\\sungw\\Desktop", item.getInputStream());
			addRequest.setFileName(item.getName());
			addRequest.setFileSize(item.getSize());
			addRequest.setRealPath(realPath);
			
		}
	}
}
PdsItem pdsItem = AddPdsItemService.getInstance().add(addRequest);
%>
<html>
<head><title> upload</title></head>
<body>
<%=pdsItem.getFileName() %> upload@@@
<br/>
<a href="/UpDownLoad/pds_jsp/list.jsp"> @@LIST</a>
</body>
</html>