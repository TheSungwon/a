<%@page buffer="none" page contentType="text/html; charset=euc-kr"%>
<!-- jsp:foward액션태그를 실행하면 생성했던 출력결과는 모두제거 -->

<html>
<head><title> forward</title></head>
<body>
forward1 생성한 페이지

<jsp:forward page="/jsp 1130/forward2/forward2.jsp" />
</body>
</html>
<!-- 버퍼가없으므로 -->