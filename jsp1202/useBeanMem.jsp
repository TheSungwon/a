<%-- �ڹٺ� ��ü�� �������ִ� ����� <jsp:useBean>
jsp: useBean id="bean�̸�" class="�ڹٺ�Ŭ�����̸�" scope="����"

id= jsp���������� �ڹٺ� ��ü�� ������ �� ����� �̸� ���
class= ��Ű���̸��� ������ �ڹٺ� Ŭ������ ������ �̸� �Է�
scope= �ڹٺ� ��ü�� ����� ������ ���� page request session application
�� �ϳ��� ������ ���´�. �⺻���� page

MemberInfo info = new MemberInfo();
request.setAttribute("info",info); �� ����� �ڵ���

������ �����׼��±״� ������ ������ �̹� id�Ӽ����� ������
�̸��� �Ӽ����� ������ ��� ��ü�� ���� �������� �ʰ� ������
�����ϴ� ��ü�� �״�� ���.

��ü�� ������ �Ӹ� �ƴ϶� ������ ������ ������ �Ѵ�. �̹� ������
��ü�� �����ϴ� ��� �� ��ü�� �״�� ��밡��
 ���� ����� �׼��±״� �� �������� ������ �����͸� ���� �����Ҽ��ִ�
 
  --%>
  <%@ page contentType="text/html; charset=euc-kr"%>
  <jsp:useBean id="a" scope="request" class="BEAN.javaBeanMem"/>
  
  <% a.setId("���̵�");
  	 a.setName("�̸�");
  %>
  
  <jsp:forward page="/jsp1202/useBeanObj.jsp" />
  
<!--  �̸��� a�� ��ü�� �����ؼ� request�⺻��ü�� ����
 ��ũ��Ʈ �ڵ忡�� �� �̸��� ����Ͽ� ������ ��ü�� �����Ѵ� -->