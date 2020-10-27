package javaSE1027;

public class Rectangle {
	
	//메소드 오버로딩
	
	public static void main(String[] args) {
		
		RectangleExample a = new RectangleExample();
		
		//정사각형의 넓이 구하기
		
		double result1 = a.rectangle(100);
		
		//직사각형의 넓이 구하기
		
		double result2 = a.rectangle(123.123, 321.321);
		
		//결과
		System.out.println(result1);
		System.out.println();
		System.out.println(result2);
	}

}
