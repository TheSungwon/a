package javaSE1110;

import java.util.Map;
import java.util.TreeMap;

public class TreeMap_1 {
	/*����Ʈ���� ������� �� Map�÷���	 TreeSet�� �������� Ű�� ���� ����� Map.Entry�� ����. TreeMap�� ��ü�� �����ϸ� �ڵ����� ����
	 * �⺻������ �θ�Ű���� ���ؼ� Ű ���� ���� ���� ���� �ڽĳ�忡 Ű ���� ���� ���� ������ �ڽĳ�忡 Map.Entry ��ü�� ����
	 * 
	 * 
	 * Map�������̽� Ÿ�Ժ����� �����ص� ������ TreepMap Ŭ���� Ÿ�����δ����� ������ Ư�� ��ü��ã�ų� ���� �˻��� ���õ� �޼ҵ带 ����ϱ� ����
	 */
	
	//Ư�� Map.Entryã��
	public static void main(String[] args) {
		TreeMap<Integer, String> a = new TreeMap<>();
		
		a.put(new Integer(1),"ȫ");
		a.put(6, "��");
		a.put(-2, "��");
		a.put(22, "��");
		a.put(12, "��");
		
		Map.Entry<Integer, String> b = null;
		
		b = a.firstEntry();
		System.out.println(b);
		System.out.println(b.getKey()); //���峷������
		System.out.println(b.getValue());//�̸�
				System.out.println("\n");
				
				/////�߷�
		
		while(!a.isEmpty()) { //���������� true �����ϴٰ� ������ false����
			b = a.pollFirstEntry();
			System.out.println(b.getKey()+" "+b.getValue()+"������ü��"+a.size());
		}
	}
}
