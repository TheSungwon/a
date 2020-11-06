package javaSE1106;

public class BeepThread2 {

	public static void main(String[] args) {//메인스레드
		Runnable beep = new BeepThread1(); //BeepThead1의 객체를 생성
		
		Thread thread = new Thread(beep); //beep를 매개값으로 해서 작업 스레드를 생성
		
		thread.start(); //작업스레드의 start()메소드를 호출하면 작업스레드에 의핸 BeepThread1 객체의 run()메소드가 실행
		
		// 동시에 for문을 실행시킨다
		
		/*
		 * 다른 2가지 방법
		 * 익명 객체) Runnable 익명 객체를 매개값으로 사용. 이 방법이 더 많이 사용된다.
		 * 람다식)Runnable 인터페이스는 run()메소드 하나만 정의되어 있기 때문에 함수적 인터페이스
		 * 
		 * 
		 */
		
		for(int i=0; i<5; i++) {
			System.out.println("ㄸ");
			try {Thread.sleep(500);}catch(Exception e) {} //0.5초간 정지
		}
		
		

	}

}
