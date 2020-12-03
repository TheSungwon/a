<!-- 
에러페이지 작성
page디렉티브의 errorPage속성을 사용해서 에러페이지를 지정하면
에러가 발생할 때 지정된 에러페이지를 보여준다. 에러페이지에 해당하는 jsp페이지는
page디렉티브의 isErrorPage속성의 값을 true로 지정해줘야한다. -->

<%@page contentType="text/html; charset=euc-kr"%>
<%@ page isErrorPage= "true"%> <!-- 에러페이지 지정 -->
<html>
<head><title> exception</title></head>
<body>
요청처리 과정에서 예외가 발생<br>
빠른시간내에 문제를 해결하도록하겠다
<p>
에러타입 <%= exception.getClass().getName() %><br> <!-- exception기본객체의 클래스이름출력 -->
에러메시지 <b><%= exception.getMessage() %></b> <!-- 예외메시지출력 -->
</body>
</html>

<!-- 만약 에러페이지의 길이가 513바이트보다 작으면,
인터넷 익스플로러는 이 페이지가 출력하는 에러 페이지를 출력하지않고
자체적으로 제공하는 http오류메시지 화면을 출력할 것이다
만약 에러 페이지의 길이가 513바이트보다 작은데
에러 페이지의 내용이 인터넷 익스플로러에서도 올바르게 출력되길 원하다면,
응답 결과에 이 주석과 같은 내용을 포함시켜서 에러페이지의
길이가 513바이트 이상이 되도록 해주어야한다.
참고로 이 주석은 '456'바이트이다. -->