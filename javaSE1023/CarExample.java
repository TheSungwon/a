package javaSE1023;

public class CarExample {
	
	/*	String company = "�ڵ���";
		String model = "�׷�";
		String color = "��";
		int maxSpeed = 350;
		int speed;
		
		static �޼ҵ� ������ ����Ҽ����� static�� �� �ʵ尡 �����������
		����Ϸ��� CarExample my = new CarExample(); ��� ��ü ����
	*/

	
	
	public static void main(String[] args) {
		//Car ��ü ����
		
		Car my = new Car();
		
		//�ʵ尪 �б�
		
		System.out.println(my.company);
		System.out.println(my.model);
		System.out.println(my.color);
		System.out.println(my.maxSpeed);
		System.out.println(my.speed);
		
		//�ʵ尪 ����
		System.out.println();
		my.speed = 50;
		System.out.println(my.speed);
	}

}
