package javaSE1103;

public class Throws1 {
	public static void main(String[] args) {
	
		try {
			a();
		} catch(ClassNotFoundException e) {
			System.out.println("���������ʽ��ϴ�");
		}
	}
	
	
	
	
	public static void a() throws ClassNotFoundException{
		Class b = Class.forName("java.lang.String2");
	}

}
/*�ڹ�api��ť��Ʈ���� forName()�޼ҵ带 ���� �޼ҵ� ����εڿ� throws ClassNotFoundException �� �پ��ִ�
forname �޼ҵ带 ȣ���Ҷ� try catch ������� ����ó���ϰų� throws�� ���ܸ� ���Ѱܾ� �Ѵ�

���⿡�� a()�޼ҵ�� ���ܸ� ���Ѱ�� a()�� ȣ���ϴ� main()�޼ҵ忡�� try catch ������� ����ó�� �ߴ�.*/