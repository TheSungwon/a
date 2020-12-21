<%@page contentType="text/html; charset=euc-kr"%>
<%@page import ="EL.Member"%>
<%@ page import = "java.util.HashMap"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<body>
<%--
set태그는 변수를 설정할때 사용한다. 그리고 기본객체의 영역에 속성설정까지한다.
<c:set var="member" value="<%= member %>" scope="request"/>
<c:set target="${member}" property="name" value="최범균" />

Member member = new Member();
member.setName("최범균");
pageContext.setAttribute("member", member);

${member.name}
Member member=(Member)pageContext.getAttribute("member");
member.getName();
 --%>
<% Member member = new Member();
HashMap<String, String> pref = new HashMap<String, String>(); %>

<c:set var ="member" value="<%=member %>" scope="page"/>
<c:set target="${member}" property="name" value="ㅁ나엄니ㅏㅇ럼ㄴㄹ"/>

<c:set var ="pref" value="<%=pref %>"/>
<c:set var="favoriateColor" value="#{pref.color }"/>

회원이름 ${member.name },
좋아하는색 ${favoriateColor } <br/>

<c:set target="${pref }"property="color" value="red"/>
설정후 좋아하는색 ${favoriateColor }


</body>
</html>