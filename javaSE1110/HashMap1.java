package javaSE1110;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMap1 {
	//HashMap�� Map �������̽��� ������ ��ǥ���� Map�÷���. 
	//Map<String , Integer> map = new HashMap<String , Integer>();
	
	public static void main(String[] args)	{
		//Map�÷��� ����
		Map<String, Integer> map=new HashMap<String, Integer>(); //import
			
		
		//��ü ����
		
		map.put("��", 85); //("��",new Integer(85))  ������ �̷��� �ؾ� ������ autoboxing ���� 85�� �ᵵ�ȴ�
		map.put("ȫ", 90);
		map.put("��", 80);
		map.put("ȫ", 95); //'ȫ' Ű�� ���� ������ ���� �������� ������ ������ ��ġ.
		System.out.println(map.size()); //����� �� Entry �� ��� 3��. Ű �ߺ� �ȵ� . ���� �ߺ� O
		
		//��ü ã��
		
		System.out.println(map.get("ȫ")+"\n"); //Ű �� ���� �˻� // 95
		
		//��ü�� �ϳ��� ó��
		
		Set<String> keySet = map.keySet(); //keySet��� //import
		
		
		Iterator<String> keyIterator = keySet.iterator(); //import
			while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println(key+" "+value);	//------------------�ݺ��ؼ� Ű�� ��� ���� Map���� ��
			
		}
		//��ü ����
			map.remove("ȫ"); //Ű�� Map.Entry�� ����
			System.out.println(map.size());
			
			
		//��ü�� �ϳ��� ó��
			//entrySet()�޼ҵ�� ��� Map.Entry�� Set�÷������� ���� ����, �ݺ��ڸ� ���� Map.Entry�� �ϳ��� ���
			//getKey() �� getValue()�޼ҵ带 �̿��� Ű�� ���� ��´�.
			Set<Map.Entry<String, Integer>> entrySet = map.entrySet(); //Map.EntrySet ���       ??
			Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
			
			while(entryIterator.hasNext()) {
				Map.Entry<String, Integer> entry = entryIterator.next();
				String key = entry.getKey();
				Integer value = entry.getValue();
				System.out.println(key+" "+value); //�ݺ��ؼ� Map.Entry�� ��� Ű�� ���� ��
				
				//��ü ��ü ����
				map.clear(); //��� Map.Entry ����
				System.out.println(map.size());
				
						
			}
			
			
	}
}
