package javaSE1106;

import java.awt.Toolkit;

public class BeepThread3 extends Thread{ //Runnable로 만들지 않고 Thread의 하위클래스로 작업 스레드를 정의
	// Thread 클래스를 상속한 후 run메소드를 오버라이딩해서 스레드가 실행할 코드를 작성
	@Override
	public void run() {
		Toolkit tool = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++) {
			tool.beep();
			try {Thread.sleep(500);}catch(Exception e) {}
		}
		
		}
	

}
