<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--
 list.jsp는 p파라미터로 읽어올 페이지 번호를 전달받은 뒤, ListArticleService클래스의
getArticleList()메서드에 전달. getArticleList()메서드는 페이지 번호와 관련된 데이터를 보관한
ArticleListModel객체를 리턴하며 list.jsp는 ArticlelistModel객체를 list_view.jsp에 전달 -->

<%@page import="DTO_javaBean.ArticleListModel"%>
<%@page import="service_board.ListArticleService"%>

<%
String pageNumberString = request.getParameter("p"); /* p파라미터로부터 읽어올 페이지 번호를 구한다 */
int pageNumber = 1;
if(pageNumberString != null&& pageNumberString.length() > 0){
	pageNumber = Integer.parseInt(pageNumberString);
}

ListArticleService listService = ListArticleService.getInstance();
ArticleListModel articleListModel = listService.getArticleList(pageNumber);
/* listService.getArticleList를 이용해서 사용자가 요청한 페이지에 해당하는 ArticleListModel 객체구한다 */

request.setAttribute("listModel", articleListModel);

if(articleListModel.getTotalPageCount()>0){
	/* 페이지목록 화면 하단에 보여줄 페이지이동링크의 페이지시작 번호와 끝번호를 계산해서구한다 */
	int beginPageNumber = (articleListModel.getRequestPage() -1) / 3*3+1;
	
	int endPageNumber = beginPageNumber + 2;
	if(endPageNumber > articleListModel.getTotalPageCount()){
		endPageNumber = articleListModel.getTotalPageCount();
	}
	request.setAttribute("beginPage", beginPageNumber);
	request.setAttribute("endPage", endPageNumber);//페이지시작번호와 끝번호를 request객체에 속성으로저장
}
%>
<jsp:forward page="./list_view.jsp"/> <!-- 해당jsp로 페이지이동 -->
