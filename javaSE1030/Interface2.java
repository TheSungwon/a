package javaSE1030;

public class Interface2 implements Interface1{

	
	//클래스 선언부에 implements 키워드 추가 . 인터페이스 탕비으로 사용할 수 있음을 알려주기 위해. 구현클래스
	//인터페이스에 선언도니 추상 메소드의 실체 메소드 선언
	//Interface2에 Add unimplemented methods 자동 생성
	
	
	
	//Field
	private int volume;
	
	
	@Override
	public void on() {
		System.out.println("On");
		
	}

	@Override
	public void off() {
		System.out.println("Off");
		
	}

	
	
	//추상 메소드의 실체 메소드
	//인터페이스의 상수를 이용해서 volume필드의 값을 제한
	@Override
	public void set(int volume) {
	if(volume > Interface1.MAX_V) {
		this.volume = Interface1.MAX_V;
	} else if ( volume < Interface1.MIN_V){ 
		this.volume = Interface1.MIN_V;
	} else {
		this.volume = volume;
	}
	System.out.println("현재volume  "+this.volume);
	

}
}