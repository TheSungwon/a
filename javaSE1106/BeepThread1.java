package javaSE1106;

import java.awt.Toolkit;

public class BeepThread1 implements Runnable{

	@Override
	public void run() { //������ ���೻��//
		Toolkit tool = Toolkit.getDefaultToolkit(); // Toolkit ��ü ���
		for(int i=0; i<5; i++){
			tool.beep(); //������ �߻�
			try {Thread.sleep(500);}catch(Exception e) {} //0.5�ʰ� �Ͻ�����
		
	}
	
	}

}
