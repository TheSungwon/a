package javaSE1030;

public class AnnonymousInterface {
	public static void main(String[] args) {
		Interface1 a = new Interface1() {
			public void on() {/*실행문*/}
			public void off() {/*실행문*/}
			public void set(int volume) {/*실행문*/}
		}; //작성시 주의할점 하나의 실행문이므로 끝에는 ; 반드시 붙여야한다
	}		//익명 구현 객체
			//인터페이스 변수 = new 인터페이스(){실체 매소드 선언};

}
