package javaSE1106;

public class BeepThread2 {

	public static void main(String[] args) {//���ν�����
		Runnable beep = new BeepThread1(); //BeepThead1�� ��ü�� ����
		
		Thread thread = new Thread(beep); //beep�� �Ű������� �ؼ� �۾� �����带 ����
		
		thread.start(); //�۾��������� start()�޼ҵ带 ȣ���ϸ� �۾������忡 ���� BeepThread1 ��ü�� run()�޼ҵ尡 ����
		
		// ���ÿ� for���� �����Ų��
		
		/*
		 * �ٸ� 2���� ���
		 * �͸� ��ü) Runnable �͸� ��ü�� �Ű������� ���. �� ����� �� ���� ���ȴ�.
		 * ���ٽ�)Runnable �������̽��� run()�޼ҵ� �ϳ��� ���ǵǾ� �ֱ� ������ �Լ��� �������̽�
		 * 
		 * 
		 */
		
		for(int i=0; i<5; i++) {
			System.out.println("��");
			try {Thread.sleep(500);}catch(Exception e) {} //0.5�ʰ� ����
		}
		
		

	}

}
