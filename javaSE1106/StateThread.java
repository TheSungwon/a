package javaSE1106;

public class StateThread extends Thread{
	private Thread a;
	
	public StateThread(Thread a) { //���¸� ������ ������ Thread a
		this.a = a;
		
	}
	@Override
	public void run() {
		while(true) {
			Thread.State state = a.getState(); //������ ���� ���
			System.out.println(state);
			
			if(state == Thread.State.NEW) {
				a.start(); //��ü ���� ������ ��� ���� ��� ���·� ����
			}
			
			if(state == Thread.State.TERMINATED) {
				break; //���� ������ ��� while ���� ������
			}
			try {
				Thread.sleep(500);//0.5�ʰ� �Ͻ�����
			}catch(Exception e){}
		}
	}

}
