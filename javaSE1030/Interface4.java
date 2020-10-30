package javaSE1030;

public class Interface4 {
	public static void main(String[] arguments) {
		//Interface2 a = new Interface2(); --X
		//인터페이스로 구현 객체를 사용하려면 인터페이스변수선언 하고 구현객체를 대입.
		//인터페이스변수는 참조타입. 구현객체가 대입되면 구현객체의번지 저장
		//개발코드 -- 인터페이스 -- 객체
		// [인터페이스 변수;]  [변수 = 구현객체;] .. [인터페이스 변수 = 구현객체;] 
		
		//Interface1 a;
		//a = new Interface2();
		Interface1 a = new Interface2();
		
		a.set(-5); //volume... this.volume 차이
		a.off();
		
		
	}

}
