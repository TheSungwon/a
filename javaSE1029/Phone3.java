package javaSE1029;

public class Phone3 {
	public static void main(String[] arguments) {
		//Phone2 ��ü ����
		Phone2 phone = new Phone2("�ڹ���","����",5);
		
		//Phone1���κ��� ��ӹ��� �ʵ�
		System.out.println("model"+phone.model);
		System.out.println("color"+phone.color);
		
		//Phone2 �� �ʵ�
		
		System.out.println("channel"+phone.channel);
		
		System.out.println("------");
		//Phone1 ���κ��� ��ӹ��� �޼ҵ�ȣ��
		
		phone.On();
		phone.bell();
		phone.voice("Hi");
		phone.hangUp();
		
		System.out.println("------");
		//Phone2 �� �޼ҵ� ȣ��
		
		phone.turnOn();
		phone.changeChannel(23);
		
		
	}

}
