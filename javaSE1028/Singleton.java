package javaSE1028;

public class Singleton {
	
	//�����ʵ�..?
	private static Singleton a = new Singleton();
	
	//������
	private Singleton() {
		
	}
	
	//���� �޼ҵ�
	static Singleton get() {
		return a; //�ܺο��� ��ü�� ��� ������ ��� getȣ��
	}
}
