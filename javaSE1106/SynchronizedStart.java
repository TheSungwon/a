package javaSE1106;

public class SynchronizedStart {

	public static void main(String[] args) {
		Synchronized1 A = new Synchronized1();
		
		SynchronizedUser B = new SynchronizedUser(); //User���������
		B.set1(A); //���� ��ü ����
		B.start(); //������ ����
		
		
		SynchronizedUser2 BB = new SynchronizedUser2();
		BB.set1(A);
		BB.start();
		

	}

}
