package javaSE1106;

public class StateThread2 extends Thread{
	@Override
	public void run() {
		for(long i = 0; i<1000000000; i++) {} //10��� ���ε����ؼ� RUNNABLE���� ����
		
		try {
			Thread.sleep(1500);
		}catch(Exception e) {} //1.5�ʰ� TIMED_WAITHING ���¸� ����
		
		for(long i=0; i<1000000000; i++) {} //�ٽ� 10��� ���� RUNNABLE���� ����
	}

}
