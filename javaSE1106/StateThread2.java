package javaSE1106;

public class StateThread2 extends Thread{
	@Override
	public void run() {
		for(long i = 0; i<1000000000; i++) {} //10억번 루핑돌게해서 RUNNABLE상태 유지
		
		try {
			Thread.sleep(1500);
		}catch(Exception e) {} //1.5초간 TIMED_WAITHING 상태를 유지
		
		for(long i=0; i<1000000000; i++) {} //다시 10억번 루핑 RUNNABLE상태 유지
	}

}
