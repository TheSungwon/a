package javaSE1106;

public class ThreadA extends Thread {
	public boolean isStop = false; // 종료플래그
	public boolean isWork = true; //작업 진행 여부 플래그
	
	
	@Override
	public void run() {
		while(!isStop) { //stop이 true가 되면 while문 종료
			if(isWork) { 
				System.out.println("TheadA");
			}else {
				Thread.yield(); //work가 false가 되면 다른 스레드에게 실행 양보
			}
		}
			System.out.println("ThreadA종료");
	}

}
