package javaSE1027;

public class Rectangle {
	
	//�޼ҵ� �����ε�
	
	public static void main(String[] args) {
		
		RectangleExample a = new RectangleExample();
		
		//���簢���� ���� ���ϱ�
		
		double result1 = a.rectangle(100);
		
		//���簢���� ���� ���ϱ�
		
		double result2 = a.rectangle(123.123, 321.321);
		
		//���
		System.out.println(result1);
		System.out.println();
		System.out.println(result2);
	}

}
