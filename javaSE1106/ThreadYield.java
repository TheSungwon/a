package javaSE1106;

public class ThreadYield {

	public static void main(String[] args) {
		ThreadA a = new ThreadA();
		ThreadB b = new ThreadB();
		
		a.start();
		b.start();		//A B ��� ����
		
		try {Thread.sleep(3000);}catch(InterruptedException e) {}
		a.isWork = false; //B�� ����
		
		try {Thread.sleep(3000);}catch(InterruptedException e) {}
		a.isWork = true; //A B ��� ����
		
		try {Thread.sleep(3000);}catch(InterruptedException e) {}
		a.isStop = true;
		b.isStop = true; //A B ��� ����

	}

}
