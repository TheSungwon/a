<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    <%@ page import="board.CommentDBBean"%>
    <%@ page import="java.sql.Timestamp"%>
    
    <%
    request.setCharacterEncoding("euc-kr");
    %>
    
    <%
    int content_num = Integer.parseInt(request.getParameter("content_num"));
    int comment_num = Integer.parseInt(request.getParameter("comment_num"));
    
    String pageNum = request.getParameter("p_num");
    String passwd = request.getParameter("passwd");
    
    CommentDBBean cmPro = CommentDBBean.getInstance();
    int check = cmPro.deleteComment(content_num, passwd, comment_num);
    
    if(check == 1){
    %>
    
    <meta http-equiv=Refresh content="0;url=content.jsp?num=<%=content_num%>&pageNum=<%=pageNum%>">
    
    <%}else{%>
    <script language="javascript">
    alert("비번이맞지않습니다");
    history.go(-1);
    </script>
    <%}%>