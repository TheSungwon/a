<%@ page contentType="text/html; charset=euc-kr" %>
<html>
<head><title>request메소드</title></head>
<body>
클라언트ip <%= request.getRemoteAddr() %>
웹서버에 연결한 클라이언트IP주소
 <br>

요청정보길이 <%= request.getContentLength() %>
클라이언트가 전송한 요청 정보의 길이. 길이를 알수없으면 -1리턴
<br>
요청정보 인코딩 <%= request.getCharacterEncoding() %>
클라이언트가 요청정보를 전송할 때 사용한 캐릭터의 인코딩
<br>
요청정보 컨텐트타입 <%= request.getContentType() %>
클라이언트가 요청정보를 전송할 때 사용한 컨텐트의 타입
<br>
요청정보 프로토콜 <%= request.getProtocol() %>
클라이언트가 요청한 프로토콜
<br>
요청정보 전송방식 <%=request.getMethod() %>
웹 브라우저가 정보를 전송할 때 사용한 방식
<br>
요청 URI <%= request.getRequestURI() %>
웹 브라우저가 요청한 URL에서 경로
<br>
컨텍스트 경로 <%= request.getContextPath() %>
JSP페이지가 속한 웹 어플리케이션의 컨텍스트경로 **
<br>
서버이름 <%= request.getServerName() %>
연결할 때 사용한 서버 이름
<br>
서버포트 <%= request.getServerPort() %>
서버가 실행 중인 포트번호
</body>

</html>