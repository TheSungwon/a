<!-- Mem.jsp�� �����ϸ� �ڹٺ��� ��ü�� �����ؼ� request�⺻��ü�� a �Ӽ���
������ �� Obj.jsp�� �������Ѵ� Obj�� �����׼��±׸� ����Ͽ�
Mem�� ������ ��ü�� ����Ѵ�. -->

<%@ page contentType="text/html; charset=euc-kr"%>
<jsp:useBean id="a" scope="request" class="BEAN.javaBeanMem"/>

<html>
<head><title> hello</title></head>
<body>
<%= a.getName()	 %> <%= a.getId() %> ȸ���� �ȳ�
</body>
</html>