package javaSE1106;

public class StateThread extends Thread{
	private Thread a;
	
	public StateThread(Thread a) { //상태를 조사할 스레드 Thread a
		this.a = a;
		
	}
	@Override
	public void run() {
		while(true) {
			Thread.State state = a.getState(); //스레드 상태 얻기
			System.out.println(state);
			
			if(state == Thread.State.NEW) {
				a.start(); //객체 생성 상태일 경우 실행 대기 상태로 만듬
			}
			
			if(state == Thread.State.TERMINATED) {
				break; //종료 상태일 경우 while 문을 종료함
			}
			try {
				Thread.sleep(500);//0.5초간 일시정지
			}catch(Exception e){}
		}
	}

}
