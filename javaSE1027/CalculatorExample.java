package javaSE1027;

public class CalculatorExample {
	public static void main(String[] args) {
		//Calculator.powerON(); static void(){} ... static사용 후 가능
		Calculator my = new Calculator(); //Calculator 클래스의 메소드를 호출하기 위해서 객체 생성
		
		my.powerON(); //my변수에 . 와 메소드(매개값) 형태로 호출하면 메소드블록 실행
		
		int result = my.plus(1, 2);
		
		System.out.println(result);
		
		byte x = 100;
		byte y = 45;
		double result1 = my.divide(x, y);
		System.out.println(result1);
		
	}

}
