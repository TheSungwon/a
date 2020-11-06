package javaSE1106;

public class ThreadName {

	public static void main(String[] args) {
		
		
		Thread main = Thread.currentThread(); //이 코드를 실행하는 스레드 객체 얻기
		System.out.println(main.getName()); // 스레드 이름 얻기
		System.out.println(main);
		
		System.out.println();
		
		Threadaaa a = new Threadaaa(); //Threadaaa 생성
		System.out.println(a.getName());
		System.out.println(a);
		a.start(); //Threadaaa 2번 출력
		
		System.out.println();
		
		Threadbbb b = new Threadbbb(); //Threadaaa 생성
		System.out.println(b.getName());
		System.out.println(b);
		b.start(); //Thread 번호 2번 출력 
		
		

	}

}
