<%@ page contentType = "text/html; charset=euc-kr"	%>

<html>
<head><title> Make a form</title></head>

���� �����͸� �Է��� ���۹�ư Ŭ��

<form action="./requestview1.jsp" method="post">
<!-- action��� ������� -->
<!-- ./ ~.jsp 				--���� ���� .�ϳ���ٱ�����
	~.jsp					--���� ����
	http://localhost~~.jsp 	--�ּ�
	(URI) WebPjt/jsp 1127/~~.jsp  --URI -->
	
�̸�: <input type="text" name="name" size="10"> <br>
�ּ�: <input type="text" name="address" size="30"> <br>
�����ϴ� ����:
<input type="checkbox" name="pet" value="dog">������
<input type="checkbox" name="pet" value="cat">�����
<input type="checkbox" name="pet" value="pig">���� <br>
<!-- 15~20���� ��û�Ķ���� ���� -->
<input type="submit" value="����">
</form>

</html>