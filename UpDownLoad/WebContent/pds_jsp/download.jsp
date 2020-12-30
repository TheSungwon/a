<!--
 GetPdsItemService�� �̿��ؼ� ��û�� ���������� ���� PdsItem��ü�� ���� ��
FileDownloadHelper�� �̿��ؼ� ���ϵ����͸� Ŭ���̾�Ʈ�� �����Ѵ�

�ٿ�ε带 ���� ������ Ÿ�԰� ��������� �����ϰ� FileDownloadHelper�� �̿��ؼ�
���� �����͸� response.getOutputStream()���� ���� ServletOutputstream�� ��� -->

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@page trimDirectiveWhitespaces="true" %>
<%@page import="pds_Service.IncreaseDownloadCountService" %>
<%@page import="java.net.URLEncoder" %>    
<%@page import="pds_Exception.PdsItemNotFoundException" %>
<%@page import="pds_Service.FileDownloadHelper" %>
<%@page import="pds_DTO.PdsItem" %>
<%@page import="pds_Service.GetPdsItemService" %>

<% int id = Integer.parseInt(request.getParameter("id"));
try{
	PdsItem item = GetPdsItemService.getInstance().getPdsItem(id); //������ ID�� �ش��ϴ� PdsItem����
	
	//���� ��� �ٿ�ε��	����?
	response.reset();
	
	String fileName = new String(item.getFileName().getBytes("euc-kr"),"iso-8859-1"); //�����̸��� �ùٸ��� ��µǵ��� ��ȯ����
	response.setContentType("application/octet-stream"); //�ٿ�ε带 ���� ������ Ÿ�� ����
	response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\""); //���� �� ����
	response.setHeader("Content-Transfer-Encoding", "binary");
	response.setContentLength((int)item.getFileSize());
	response.setHeader("Pragma", "no-cache;");
	response.setHeader("Expires", "-1;");
	
	FileDownloadHelper.copy(item.getRealPath(), response.getOutputStream()); //FileDownloadHelper�� �̿��ؼ� ����������
	
	response.getOutputStream().close();
	
	IncreaseDownloadCountService.getInstance().increaseCount(id);
}catch(PdsItemNotFoundException e){
	response.setStatus(HttpServletResponse.SC_NOT_FOUND); //������ ID�� �ش��ϴ� PdsItem�� �������� ���� ��� 404���� �ڵ� ����
}
%>
