package javaSE1103;

public class TryCatchFinally {
	public static void main(String[] args) {
		try {
			Class a = Class.forName("java.lang.String2");
		} catch(ClassNotFoundException e) {
			System.out.println("nothing");
		}
	}

}
//Clss.forNmae()�޼ҵ�� �Ű������� �־��� Ŭ������ �����ϸ� Class��ü�� ����, �������� ������ ClassNotFoundException ���� �߻�
//java.lang.String2 Ŭ������ �������� �ʱ� ����.