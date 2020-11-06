package javaSE1106;

public class SynchronizedUser extends Thread {
	
	private Synchronized1 synchronized1;
	
	public void set1(Synchronized1 b) {
		
		setName("a"); //스레드 이름을 a 설정
		synchronized1 = b; //공유 객체인 b를 필드에 저장
		
	}
	
	@Override
	public void run() {
		synchronized1.setMem(100); //공유 객체인 Synchronized1 의 메모리에 100을 저장
	}

}
