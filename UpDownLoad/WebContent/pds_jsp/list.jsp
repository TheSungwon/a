<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@page import="pds_Service.ListPdsItemService" %>    
<%@page import="pds_DAO.PdsItemListModel" %>
<%
String pageNumberString = request.getParameter("p");
int pageNumber = 1;
if(pageNumberString != null && pageNumberString.length() >0 ){
	pageNumber = Integer.parseInt(pageNumberString);
}

ListPdsItemService listService = ListPdsItemService.getInstance();
PdsItemListModel itemListModel = listService.getPdsItemList(pageNumber);

request.setAttribute("listModel", itemListModel);

if(itemListModel.getTotalPageCount() > 0){
	int beginPageNumber = (itemListModel.getRequestPage() -1 ) / 3*3+1;
	int endPageNumber = beginPageNumber +2;
	if(endPageNumber > itemListModel.getTotalPageCount()){
		endPageNumber = itemListModel.getTotalPageCount();
	}
	
	request.setAttribute("beginPage", beginPageNumber);
	request.setAttribute("endPage", endPageNumber);
}
%>

<jsp:forward page="/pds_Form/list_view.jsp"/>