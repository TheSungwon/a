package javaSE1028;

public class Block {
	int speed;
	
	void run() {
		System.out.println(speed+"�޸��ϴ�");
		
	}
	
	public static void main(String[] arguments) {
		Block a = new Block();//��ü����
		//main()�޼ҵ嵵 ����(static)�޼ҵ� �̹Ƿ�
		//��ü �������� �ν��Ͻ� �ʵ�� �ν��Ͻ��޼ҵ带
		//main()�޼ҵ忡�� �ٷλ���Ҽ�����
		
		a.speed = 1;
		a.run();
	}
	

}
