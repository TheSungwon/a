package javaSE1105;

import java.util.regex.Pattern;/////


public class Pattern1 {

	public static void main(String[] args) {
	//����ǥ�������� ���ڿ��� �����ϴ� ��� java.util.regex.Pattern Ŭ������ �����޼ҵ��� matches()�� ����
	//boolean result = Pattern.matches("���Խ�", "������ ���ڿ�");
		String a = "(02|010)-\\d{3,4}-\\d{4}"; //�� ��ȣ ����ǥ����
		String b = "010-111-1111";
		boolean c = Pattern.matches(a, b);
		if(c) {
			System.out.println("��ġ");
		}else {
			System.out.println("����ġ");
		}
		
		a = "\\w-+@\\w+\\, \\w+(\\ \\w+)?"; // ""�ȿ� �ֱ⶧���� \\w , \\d ��밡�� \\�ι� .. �̸������Խ�
		b = "angel@navercom"; //.com
		c = Pattern.matches(a, b);
		if(c) {
			System.out.println("��ġ");
		}else {
			System.out.println("����ġ");//naver.com
		}
	}

}
