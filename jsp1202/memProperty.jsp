<%@page contentType="text/html; charset=euc-kr"%>
<%
request.setCharacterEncoding("euc-kr"); %>
<!-- �о�� �Ķ������ ĳ�������ڵ��� euc-kr�� ����. �ѱ�ó�� -->


<!-- jsp:setProperty �׼��±׸� ����ϸ� ������ �ڹٺ� ��ü�� ������Ƽ����
�����Ҽ��ִ�. ������
jsp:setProperty name="�ڹٺ�" property="�̸�" value="��"
name ������Ƽ�� ���� ������ �ڹٺ� ��ü�̸�. �����׼��±��� id�Ӽ�����
������ ���� ���

property ���� ������ ������Ƽ�� �̸�

value ������Ƽ�� ��. ǥ���� ��밡��

ex �ڹٺ� ��ü�� name������Ƽ�� ���� "�̸�" ���� �����Ѵٸ�
jsp:useBean id="aaa" class="���"/
jsp:setProperty name="aaa" property="name" value="�̸�" /

value��� param�Ӽ� ��밡��. 

property�Ӽ����� *�� �����ϸ� ������ ������Ƽ���� ���� �̸�����
���� �Ķ������ ������ ���� -->
<jsp:useBean id="a" class="BEAN.javaBeanMem" />
<jsp:setProperty name="a" property="*"/>
<%--   <% a.setId("���̵�");
  		 a.setName("�̸�"); %>  or
  		 request �������ϸ�
  		 a.setNmae(request.getParameter("name"))?--%>
<jsp:setProperty name="a" property="password"
						value="<%=a.getId() %>"/> <!-- ��ȣ�� ���̵�� �����Ѵ� -->
						
<html>
<head><title> sign up</title></head>
<body>
<table width="400" border="1" cellpadding="0" cellspacing="0">
<tr>
	<td> ID</td>
	<td><jsp:getProperty name="a" property="id"/> </td>
	<%-- getProperty�� �Ⱦ��� ��� ������ ���ؼ� ���/ �ֳ��ϸ�
	�׼��±װ� �����ϹǷ� 	<%=a.getName() %> --%>
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
						



