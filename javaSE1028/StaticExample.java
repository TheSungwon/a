package javaSE1028;

public class StaticExample {
	public static void main(String[] arguments) {
		double result = 10 * 10 * Static.pi;
		
		int result2 = Static.plus(2, 5);
		
		int result3 = Static.minus(1, 10);
		
		System.out.println(result);
		System.out.println();
		System.out.println(result2);
		System.out.println();
		System.out.println(result3);
		//���������� �����ʵ�� �����޼ҵ�� Ŭ�����̸����� ����
		
	}

}
