package javaSE1104;

import java.util.HashMap;

public class Hashcode2 {
	public static void main(String args[]) {		
		HashMap<Hashcode, String> hashMap = new HashMap<Hashcode, String>();
		
		hashMap.put(new Hashcode(1), "ȫ�浿");
		
		String v = hashMap.get(new Hashcode(1));
		System.out.println(v);	
		
	}

}
/* HashMap�� �ĺ�Ű�� Hashcode��ü�� ����ϸ� ����� ���� ã�ƿ������� �ֳ��ϸ� num�� �ʵ尪�� ������ hashcode()�޼ҵ忡�� �����ϴ�
�ؽ��ڵ尡 �ٸ��� ������ �ٸ� �ĺ�Ű�� �ν�. new Hashcode(1) ��ü�� ȫ�浿�� �����ϰ� �ٽ� ��ü�� ����� ȫ�浿�� �������� ������ null
Hashcode�� hashcode�޼ҵ� ������ �߰� �ϸ� ȫ�浿 ���*/