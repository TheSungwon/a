package javaSE1106;

public class SynchronizedUser extends Thread {
	
	private Synchronized1 synchronized1;
	
	public void set1(Synchronized1 b) {
		
		setName("a"); //������ �̸��� a ����
		synchronized1 = b; //���� ��ü�� b�� �ʵ忡 ����
		
	}
	
	@Override
	public void run() {
		synchronized1.setMem(100); //���� ��ü�� Synchronized1 �� �޸𸮿� 100�� ����
	}

}
