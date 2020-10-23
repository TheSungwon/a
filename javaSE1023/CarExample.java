package javaSE1023;

public class CarExample {
	
	/*	String company = "자동차";
		String model = "그랜";
		String color = "흰";
		int maxSpeed = 350;
		int speed;
		
		static 메소드 때문에 사용할수없음 static은 위 필드가 저장되지않음
		사용하려면 CarExample my = new CarExample(); 라고 객체 생성
	*/

	
	
	public static void main(String[] args) {
		//Car 객체 생성
		
		Car my = new Car();
		
		//필드값 읽기
		
		System.out.println(my.company);
		System.out.println(my.model);
		System.out.println(my.color);
		System.out.println(my.maxSpeed);
		System.out.println(my.speed);
		
		//필드값 변경
		System.out.println();
		my.speed = 50;
		System.out.println(my.speed);
	}

}
