package javaSE1106;

public class Synchronized1 {
	private int mem;
	
	public int getMem() {
		return mem;
	}
	
	//	����ȭ �޼ҵ� ����
	
	public synchronized void setMem(int mem) {		//Synchronized1 �޸𸮿� ���� �����ϴ� �޼ҵ� // synchronized�߰�
		this.mem = mem;		//�Ű����� mem�ʵ忡 ����
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {} // �����带 2�ʰ� �Ͻ����� ��Ŵ
		System.out.println(Thread.currentThread().getName() + this.mem);
							//�������� �̸�				�޸𸮰�
	}
	
		
	
	/*
	public void setMem(int mem) {		//Synchronized1 �޸𸮿� ���� �����ϴ� �޼ҵ�
		this.mem = mem;		//�Ű����� mem�ʵ忡 ����
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {} // �����带 2�ʰ� �Ͻ����� ��Ŵ
		System.out.println(Thread.currentThread().getName() + this.mem);
							//�������� �̸�				�޸𸮰�
	}
	*/
}
