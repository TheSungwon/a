package javaSE1106;

public class ThreadB extends Thread {
	public boolean isStop = false; // �����÷���
	public boolean isWork = true; //�۾� ���� ���� �÷���
	
	
	@Override
	public void run() {
		while(!isStop) { //stop�� true�� �Ǹ� while�� ����
			if(isWork) { 
				System.out.println("TheadB");
			}else {
				Thread.yield(); //work�� false�� �Ǹ� �ٸ� �����忡�� ���� �纸
			}
		}
			System.out.println("ThreadB����");
	}

}
