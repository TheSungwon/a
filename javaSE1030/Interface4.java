package javaSE1030;

public class Interface4 {
	public static void main(String[] arguments) {
		//Interface2 a = new Interface2(); --X
		//�������̽��� ���� ��ü�� ����Ϸ��� �������̽��������� �ϰ� ������ü�� ����.
		//�������̽������� ����Ÿ��. ������ü�� ���ԵǸ� ������ü�ǹ��� ����
		//�����ڵ� -- �������̽� -- ��ü
		// [�������̽� ����;]  [���� = ������ü;] .. [�������̽� ���� = ������ü;] 
		
		//Interface1 a;
		//a = new Interface2();
		Interface1 a = new Interface2();
		
		a.set(-5); //volume... this.volume ����
		a.off();
		
		
	}

}
