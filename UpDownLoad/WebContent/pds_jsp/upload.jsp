<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--
     ������ ���ε� ��ư Ŭ���ϸ� ������ ������ upload.jsp�� ����
    ���� ������ ���ļ� ���ε� ���� ���
FileUpload API�� �̿��ؼ� ���ε� �� ���� ������ ���� FileItem�� ���Ѵ�.

Fileitem.getInputStream()���� ���� InputStream�� FileSaveHelper�� �����Ͽ� ���ε� �� ������ ����

FileItem���κ��� ���ϸ� ���� ũ�⸦ ���ϰ� FileSaveHelper�� save()�޼��尡 ������ ���� ���� ��θ�
�̿��ؼ� AddRequest ��ü�� �����.

AddRequest��ü�� AddPdsItemService�� add()�޼��忡 �����Ͽ� ���ε� �� ���� ������ DB�� �����Ѵ� -->

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