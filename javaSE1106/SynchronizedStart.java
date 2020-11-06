package javaSE1106;

public class SynchronizedStart {

	public static void main(String[] args) {
		Synchronized1 A = new Synchronized1();
		
		SynchronizedUser B = new SynchronizedUser(); //User스레드생성
		B.set1(A); //공유 객체 생성
		B.start(); //스레드 시작
		
		
		SynchronizedUser2 BB = new SynchronizedUser2();
		BB.set1(A);
		BB.start();
		

	}

}
