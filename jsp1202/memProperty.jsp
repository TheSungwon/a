<%@page contentType="text/html; charset=euc-kr"%>
<%
request.setCharacterEncoding("euc-kr"); %>
<!-- 읽어올 파라미터의 캐릭터인코딩을 euc-kr로 지정. 한글처리 -->


<!-- jsp:setProperty 액션태그를 사용하면 생성한 자바빈 객체의 프로퍼티값을
지정할수있다. 문법은
jsp:setProperty name="자바빈" property="이름" value="값"
name 프로퍼티의 값을 변경할 자바빈 객체이름. 유즈빈액션태그의 id속성에서
지정한 값을 사용

property 값을 지정할 프로퍼티의 이름

value 프로퍼티의 값. 표현식 사용가능

ex 자바빈 객체의 name프로퍼티의 값을 "이름" 으로 지정한다면
jsp:useBean id="aaa" class="경로"/
jsp:setProperty name="aaa" property="name" value="이름" /

value대신 param속성 사용가능. 

property속성값을 *로 지정하면 각각의 프로퍼티값을 같은 이름으로
갖는 파라미터의 값으로 설정 -->
<jsp:useBean id="a" class="BEAN.javaBeanMem" />
<jsp:setProperty name="a" property="*"/>
<%--   <% a.setId("아이디");
  		 a.setName("이름"); %>  or
  		 request 지정안하면
  		 a.setNmae(request.getParameter("name"))?--%>
<jsp:setProperty name="a" property="password"
						value="<%=a.getId() %>"/> <!-- 암호를 아이디와 같게한다 -->
						
<html>
<head><title> sign up</title></head>
<body>
<table width="400" border="1" cellpadding="0" cellspacing="0">
<tr>
	<td> ID</td>
	<td><jsp:getProperty name="a" property="id"/> </td>
	<%-- getProperty잘 안쓰는 방법 예제를 위해서 사용/ 왜냐하면
	액션태그가 간결하므로 	<%=a.getName() %> --%>
	<td> Password</td>
	<td><jsp:getProperty name="a" property="password" /> </td>
</tr>

<tr>
	<td>Name</td>
	<td><jsp:getProperty name="a" property="name" /></td>
	<td>Email</td>
	<td><jsp:getProperty name="a" property="email"/></td>
</tr>

<tr>
	<td>Address</td>
	<td colspan="3">
	<jsp:getProperty name="a" property="address"/> </td>
</tr>


</table>

</body>
</html>						
						



