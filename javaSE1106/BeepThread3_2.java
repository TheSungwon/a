package javaSE1106;

import java.awt.Toolkit;

public class BeepThread3_2 {

	public static void main(String[] args) {
		
		//익명구현객체로 생선한 스레드
		Thread thread = new Thread() {
			@Override
			public void run() {		
				Toolkit toolkit = Toolkit.getDefaultToolkit();	
				for(int i=0; i<5; i++) {		
					toolkit.beep();
					try { Thread.sleep(500); } catch(Exception e) {}
				}
			}
		};

	}

}
