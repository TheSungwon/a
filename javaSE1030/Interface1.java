package javaSE1030;

public interface Interface1 {
	
	//����ʵ弱�� . �������̽��� �����͸� ������ �� ���� ������ �����͸� ������ �ν��Ͻ�, ���� �ʵ带 ������ �� ����. ��� ��� �ʵ常 ������ �� �ִ�.
	// ����� public static final�� ����. �������̽��� ����� �ʵ�� ��� �� Ư���� ���´�. �����ϴ��� �ڵ������� ������ �������� �ٴ´�.
	
	int MAX_V = 10;	//public static final ����
	int MIN_V = 0;	//�������̽� ����� static{}�������� �ʱ�ȭ�� �� ����. ����� ���ÿ� �ʱⰪ ����.
	
	//�߻�޼ҵ�. �������̽��� ���� ȣ��� �޼ҵ�� ���������� ��ü���� ����. �������̽��� �޼ҵ�� ���� ������ �ʿ� ���� �߻�޼ҵ�� ����
	//����Ÿ��. �޼ҵ��. �Ű�����.�� {}������ �ʴ´�. public abstract Ư���� ���� ������ �����ϴ��� �ڵ������� ������ �������� �ٴ´�.
	
	//�߻�޼ҵ�
	
	void on();
	void off();
	void set(int volume);
	
	//����Ʈ �޼ҵ�
	//����Ʈ �޼ҵ� ���� .�ڹ� 8���� �߰��� ���ο� ���. Ŭ������ �ν��Ͻ� �޼ҵ�� ����. public Ư���� ���´� �����ص� �ٴ´�
	default void mute(boolean m) {
		if(m) {
			System.out.println("����");
		}else {
			System.out.println("��������");
		}
	}
	
	//���� �޼ҵ�
	//���� �޼ҵ� ����. �ڹ� 8���� �߰�. Ŭ������ ���� �޼ҵ�� ����. �����ص� �ٴ´�.
	static void change() {
		System.out.println("��ȯ");
	
	}
}