package javaSE1109;

public class Util2 {
	public static <T extends Number> int compare(T a, T b) { ////���ѵ� Ÿ�� �Ķ���� <T extends �ֻ���Ÿ��>
		//����Ÿ���̰ų� ���� Ÿ���� ���� or ����Ŭ������ ����
		//�޼ҵ� {}�ȿ� Ÿ�� �Ķ���� ������ ��� ������ ���� ���� Ÿ���� ���(�ʵ�, �޼ҵ�)�� ����. ���� Ÿ�Կ��� �ִ� �ʵ�� �޼ҵ�� ���Ұ�
		
		double a1 = a.doubleValue();
		double b1 = b.doubleValue();
		return Double.compare(a1, b1);
		
	}

}
