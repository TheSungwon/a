package javaSE1029;

public class Phone3 {
	public static void main(String[] arguments) {
		//Phone2 객체 생성
		Phone2 phone = new Phone2("자바폰","검정",5);
		
		//Phone1으로부터 상속받은 필드
		System.out.println("model"+phone.model);
		System.out.println("color"+phone.color);
		
		//Phone2 의 필드
		
		System.out.println("channel"+phone.channel);
		
		System.out.println("------");
		//Phone1 으로부터 상속받은 메소드호출
		
		phone.On();
		phone.bell();
		phone.voice("Hi");
		phone.hangUp();
		
		System.out.println("------");
		//Phone2 의 메소드 호출
		
		phone.turnOn();
		phone.changeChannel(23);
		
		
	}

}
