package javaSE1105;

public class Math1 {

	public static void main(String[] args) {
		//java.lang.Math ���а�꿡 ����Ҽ��ִ� �޼ҵ����� // ��� static �̹Ƿ� MathŬ������ �ٷλ�밡��
		
		int a1 = Math.abs(-100); //math.abs ���밪  int or double
		double a2 = Math.abs(-1.2343);
		System.out.println(a1);
		System.out.println(a2);
		
		System.out.println();
		
		double b1 = Math.ceil(5.123); //math.ceil �ø�
		double b2 = Math.ceil(-5.123);
		System.out.println(b1);
		System.out.println(b2);
		
		System.out.println();
		
		
		double c1 = Math.floor(5.123); //����
		double c2 = Math.floor(-5.123);
		System.out.println(c1);
		System.out.println(c2);
		
		System.out.println();
		
		int d1 = Math.max(1,2); //�ִ밪 �ּҰ� Math.min
		double d2 = Math.max(1.1, 2.2);
		System.out.println(d1);
		System.out.println(d2);
		
		System.out.println();
		
		double e = Math.random();//������
		System.out.println(e);
		
		System.out.println();
		
		double aa = Math.rint(5.3); //����� ������ �Ǽ���
		double aaa = Math.rint(5.6);
		System.out.println(aa);
		System.out.println(aaa);
		
		System.out.println();
		
		double bb = Math.round(5.2); //�ݿø���
		double dd = Math.round(5.6);
		System.out.println(bb);
		System.out.println(dd);
		
		System.out.println();
		
		double v1 = 1.226;
		double v2 = v1 * 100;
		long v3 = Math.round(v2);
		System.out.println(v3);
		double v4 = v3 / 100.0;
		System.out.println(v4);
	}

}
