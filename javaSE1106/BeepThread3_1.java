package javaSE1106;

public class BeepThread3_1 {

	public static void main(String[] args) {
		Thread thread = new BeepThread3(); // BeepThread3 ��ü�� ����
		thread.start(); //start()�޼ҵ带 ȣ���Ͽ� BeepThread3�� run�޼ҵ带 �����ϵ��� �ߴ�
		
		for(int i=0; i<5; i++) {
			System.out.println("��");
			try {Thread.sleep(500);}catch(Exception e) {} //0.5�ʰ� ����
		}

	}

}
