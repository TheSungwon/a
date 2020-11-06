package javaSE1106;

public class SynchronizedUser2 extends Thread {
	
	private Synchronized1 synchronized1;
	
	public void set1(Synchronized1 b) {
		
		setName("aa"); //스레드 이름을 aa 설정
		synchronized1 = b; //공유 객체인 b를 필드에 저장
		
	}
	
	@Override
	public void run() {
		synchronized1.setMem(50); //공유 객체인 Synchronized1 의 메모리에 50을 저장
	}

}
