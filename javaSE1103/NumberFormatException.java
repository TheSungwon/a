package javaSE1103;

public class NumberFormatException {
	public static void main(String[] args) {
		String a = "100";
		String b = "aaa";
		
		int v1 = Integer.parseInt(a);
		int v2 = Integer.parseInt(b); // NumberFormatException �߻�
		
		int result = v1 + v2;
		System.out.println(result);
		
		//���ڿ��� �Ǿ��ִ� �����͸� ���ڷ� �����ϴ� ��� Integer.parseInt , Double.parseDouble �� ���. wrapper ���� Ŭ��������Ѵ�
		//���ڸ� ���ڷ� ��ȯ�ɼ��ִٸ� ����, ���ڷ� ��ȯ�� �� ���� ���ڰ� ���ԵǾ� �ִٸ� NumberFormatException�O��
		
		
	}

}
