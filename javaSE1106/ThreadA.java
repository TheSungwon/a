package javaSE1106;

public class ThreadA extends Thread {
	public boolean isStop = false; // �����÷���
	public boolean isWork = true; //�۾� ���� ���� �÷���
	
	
	@Override
	public void run() {
		while(!isStop) { //stop�� true�� �Ǹ� while�� ����
			if(isWork) { 
				System.out.println("TheadA");
			}else {
				Thread.yield(); //work�� false�� �Ǹ� �ٸ� �����忡�� ���� �纸
			}
		}
			System.out.println("ThreadA����");
	}

}
