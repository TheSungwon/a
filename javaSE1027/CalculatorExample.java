package javaSE1027;

public class CalculatorExample {
	public static void main(String[] args) {
		//Calculator.powerON(); static void(){} ... static��� �� ����
		Calculator my = new Calculator(); //Calculator Ŭ������ �޼ҵ带 ȣ���ϱ� ���ؼ� ��ü ����
		
		my.powerON(); //my������ . �� �޼ҵ�(�Ű���) ���·� ȣ���ϸ� �޼ҵ��� ����
		
		int result = my.plus(1, 2);
		
		System.out.println(result);
		
		byte x = 100;
		byte y = 45;
		double result1 = my.divide(x, y);
		System.out.println(result1);
		
	}

}
