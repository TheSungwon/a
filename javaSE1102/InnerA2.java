package javaSE1102;

public class InnerA2 {
	public static void main(String[] args) {
		InnerA a = new InnerA();
		
		//�ν��Ͻ����Ŭ���� ��ü����
		
		InnerA.InnerB b = a.new InnerB();
		b.field1 = 123;
		b.method1();
		
		//����Ŭ���� ��ü������ ���� �޼ҵ� ȣ��
		a.method();
	}

}
