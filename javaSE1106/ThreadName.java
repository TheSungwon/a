package javaSE1106;

public class ThreadName {

	public static void main(String[] args) {
		
		
		Thread main = Thread.currentThread(); //�� �ڵ带 �����ϴ� ������ ��ü ���
		System.out.println(main.getName()); // ������ �̸� ���
		System.out.println(main);
		
		System.out.println();
		
		Threadaaa a = new Threadaaa(); //Threadaaa ����
		System.out.println(a.getName());
		System.out.println(a);
		a.start(); //Threadaaa 2�� ���
		
		System.out.println();
		
		Threadbbb b = new Threadbbb(); //Threadaaa ����
		System.out.println(b.getName());
		System.out.println(b);
		b.start(); //Thread ��ȣ 2�� ��� 
		
		

	}

}
