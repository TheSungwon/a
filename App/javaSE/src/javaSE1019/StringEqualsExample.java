package javaSE1019;

public class StringEqualsExample {
	public static void main(String[] args) {
		
		String s1 = "�Ź�ö";
		String s2 = "�Ź�ö";
		String s3 = new String("�Ź�ö");
		
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println();
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		//���ڿ��� ���Ϸ��� == ��ſ� equals() �޼ҵ带 ���
		
		
	}

}
