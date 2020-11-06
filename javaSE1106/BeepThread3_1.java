package javaSE1106;

public class BeepThread3_1 {

	public static void main(String[] args) {
		Thread thread = new BeepThread3(); // BeepThread3 객체를 생성
		thread.start(); //start()메소드를 호출하여 BeepThread3가 run메소드를 실행하도록 했다
		
		for(int i=0; i<5; i++) {
			System.out.println("ㄸ");
			try {Thread.sleep(500);}catch(Exception e) {} //0.5초간 정지
		}

	}

}
