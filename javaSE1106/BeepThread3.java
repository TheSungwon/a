package javaSE1106;

import java.awt.Toolkit;

public class BeepThread3 extends Thread{ //Runnable�� ������ �ʰ� Thread�� ����Ŭ������ �۾� �����带 ����
	// Thread Ŭ������ ����� �� run�޼ҵ带 �������̵��ؼ� �����尡 ������ �ڵ带 �ۼ�
	@Override
	public void run() {
		Toolkit tool = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++) {
			tool.beep();
			try {Thread.sleep(500);}catch(Exception e) {}
		}
		
		}
	

}
