package javaSE1105;

public class StringBuilder1 {
	public static void main(String[] args) {
		
		//StringBuffer�� ��Ƽ������ StringBuilder�� ���� ������ ȯ��
		
		StringBuilder a = new StringBuilder(); //StringBuilder ��ü ����
		
		
		a.append("AAAAA"); //append() ���ڿ��� ���� �߰�
		a.append("BBBBB");
		System.out.println(a.toString());
		
		
		a.insert(0, "a");
		System.out.println(a); //insert() 0��°���ڵڿ� a ����
		
		
		a.setCharAt(3, '��');
		System.out.println(a); //setCharAt 3��°���ڵڿ� ������ ����
		
		a.replace(5, 7, "����");
		System.out.println(a);	//replacce ���� ���ں��� ��°���ڱ��� ~�� ��ġ
		
		a.delete(2,5);
		System.out.println(a); //2~4 ����
		
		int b = a.length();
		System.out.println(b); //�ѹ��ڼ�
		
		String c = a.toString();
		System.out.println(c); //���ۿ� �ִ� ���� StringŸ������ ����
		
	}

}
