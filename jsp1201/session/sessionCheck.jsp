<!-- 세션기본객체에 로그인표식을 위한 속성이 존재하는지의 여부에 따라 로그인 상태를 판단
sessionLoing.jsp에서 지정한로그인 표식을 사용하여 판단 할 경우
세션 기본객체의 memberid속성 존재 여부를 사용하여 판단. -->

<%@ page contentType="text/html; charset=euc-kr"%>
<%
String memberId = (String)session.getAttribute("memberid");
boolean login = memberId == null ? false : true ; 
/* 3항연산자 memeberId가 널이면 false 널 아니면 true */
%>

<html>
<head><title> 로그인여부검삭</title></head>

<body> 

<%
if (login){ out.println( memberId + " 로그인한상태");
	}else{ out.println("로그인 아니다"); 
}
%>
</body>
</html>
