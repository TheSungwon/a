package javaSE1102;

public class Inin {
	a b; //인터페이스 타입 필드
	
	
	void A(a c) { 
		b = c;
	}//매개변수의 다형성
	
	void touch() {
		b.on();
	}//구현 객체의 on()메소드 호출
	
	interface a{
		void on();
	}//중첩 인터에피스
}
//a로 중첩인터페이스 타입으로 b 필드 선언하고 setter메소드A로 구현 객체를 받아 필드에 대입.
//touch메소드가 실행되었을때 인터페이스를 통해 구현객체의 메소드호출(b.on())