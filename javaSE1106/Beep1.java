package javaSE1106;

import java.awt.Toolkit;

public class Beep1 {
	public static void main(String[] args) {
		Toolkit tool = Toolkit.getDefaultToolkit(); // Toolkit ��ü ���
		for(int i=0; i<5; i++){
			tool.beep(); //������ �߻�
			try {Thread.sleep(500);}catch(Exception e) {} //0.5�ʰ� �Ͻ�����
						
		}
		
		for(int i=0; i<5; i++) {
			System.out.println("��");
			try {Thread.sleep(500);}catch(Exception e) {} //0.5�ʰ� ����
		}
	}

}
