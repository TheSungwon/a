<%@page contentType="text/html; charset=euc-kr"%>
<%@page import ="EL.Member"%>
<%@ page import = "java.util.HashMap"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<body>
<%--
set�±״� ������ �����Ҷ� ����Ѵ�. �׸��� �⺻��ü�� ������ �Ӽ����������Ѵ�.
<c:set var="member" value="<%= member %>" scope="request"/>
<c:set target="${member}" property="name" value="�ֹ���" />

Member member = new Member();
member.setName("�ֹ���");
pageContext.setAttribute("member", member);

${member.name}
Member member=(Member)pageContext.getAttribute("member");
member.getName();
 --%>
<% Member member = new Member();
HashMap<String, String> pref = new HashMap<String, String>(); %>

<c:set var ="member" value="<%=member %>" scope="page"/>
<c:set target="${member}" property="name" value="�������Ϥ���������"/>

<c:set var ="pref" value="<%=pref %>"/>
<c:set var="favoriateColor" value="#{pref.color }"/>

ȸ���̸� ${member.name },
�����ϴ»� ${favoriateColor } <br/>

<c:set target="${pref }"property="color" value="red"/>
������ �����ϴ»� ${favoriateColor }


</body>
</html>