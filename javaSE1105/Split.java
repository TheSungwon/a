package javaSE1105;

public class Split {

	public static void main(String[] args) {
	String a = "��,��,��,��,��,.��.��.&��-��-��";
	
	String[] name = a.split("&|,|-"); //slpit()�޼ҵ�� ��ȣ���� �����ڷ� �ؼ� �κ� ���ڿ��� ����
	
	System.out.println(name);
	System.out.println(a);
	
	
	for(String b : name) {
		System.out.print(b); // .�ȵ� print�� ���
	}

	}

}
