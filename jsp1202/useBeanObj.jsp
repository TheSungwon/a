<!-- Mem.jsp을 실행하면 자바빈의 객체를 생성해서 request기본객체의 a 속성에
저장한 후 Obj.jsp로 포워딩한다 Obj는 유즈빈액션태그를 사용하여
Mem이 생성한 객체를 사용한다. -->

<%@ page contentType="text/html; charset=euc-kr"%>
<jsp:useBean id="a" scope="request" class="BEAN.javaBeanMem"/>

<html>
<head><title> hello</title></head>
<body>
<%= a.getName()	 %> <%= a.getId() %> 회원님 안녕
</body>
</html>