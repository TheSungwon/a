package javaSE1106;

public class SynchronizedUser2 extends Thread {
	
	private Synchronized1 synchronized1;
	
	public void set1(Synchronized1 b) {
		
		setName("aa"); //������ �̸��� aa ����
		synchronized1 = b; //���� ��ü�� b�� �ʵ忡 ����
		
	}
	
	@Override
	public void run() {
		synchronized1.setMem(50); //���� ��ü�� Synchronized1 �� �޸𸮿� 50�� ����
	}

}
