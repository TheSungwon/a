package javaSE1106;

public class Threadaaa extends Thread {
	public Threadaaa() {
		setName("Threadaaa"); //������ �̸� ����
		//super("Threadaaa"); super�� ����
		
	}
	@Override
	public void run() {
		for(int i=0; i<2; i++) {
			System.out.println(getName()); //getName() ������ �̸� ��� //Threadaaa ���� ����
		}
	}
	

}
