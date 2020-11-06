package javaSE1106;

import java.awt.Toolkit;

public class BeepThread1 implements Runnable{

	@Override
	public void run() { //스레드 실행내용//
		Toolkit tool = Toolkit.getDefaultToolkit(); // Toolkit 객체 얻기
		for(int i=0; i<5; i++){
			tool.beep(); //비프음 발생
			try {Thread.sleep(500);}catch(Exception e) {} //0.5초간 일시정지
		
	}
	
	}

}
