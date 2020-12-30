<!--
 GetPdsItemService를 이용해서 요청한 파일정보를 담은 PdsItem객체를 구한 뒤
FileDownloadHelper를 이용해서 파일데이터를 클라이언트에 전송한다

다운로드를 위한 콘텐츠 타입과 헤더정보를 설정하고 FileDownloadHelper를 이용해서
파일 데이터를 response.getOutputStream()으로 구한 ServletOutputstream에 출력 -->

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
	PdsItem item = GetPdsItemService.getInstance().getPdsItem(id); //지정한 ID에 해당하는 PdsItem구함
	
	//응답 헤더 다운로드로	설정?
	response.reset();
	
	String fileName = new String(item.getFileName().getBytes("euc-kr"),"iso-8859-1"); //파일이름이 올바르게 출력되도록 변환해줌
	response.setContentType("application/octet-stream"); //다운로드를 위한 콘텐츠 타입 설정
	response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\""); //파일 명 설정
	response.setHeader("Content-Transfer-Encoding", "binary");
	response.setContentLength((int)item.getFileSize());
	response.setHeader("Pragma", "no-cache;");
	response.setHeader("Expires", "-1;");
	
	FileDownloadHelper.copy(item.getRealPath(), response.getOutputStream()); //FileDownloadHelper를 이용해서 데이터전송
	
	response.getOutputStream().close();
	
	IncreaseDownloadCountService.getInstance().increaseCount(id);
}catch(PdsItemNotFoundException e){
	response.setStatus(HttpServletResponse.SC_NOT_FOUND); //지정한 ID에 해당하는 PdsItem이 존재하지 않을 경우 404상태 코드 전송
}
%>
