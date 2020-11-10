package javaSE1110;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMap1 {
	//HashMap은 Map 인터페이스를 구현한 대표적인 Map컬렉션. 
	//Map<String , Integer> map = new HashMap<String , Integer>();
	
	public static void main(String[] args)	{
		//Map컬렉션 생성
		Map<String, Integer> map=new HashMap<String, Integer>(); //import
			
		
		//객체 저장
		
		map.put("신", 85); //("신",new Integer(85))  원래는 이렇게 해야 하지만 autoboxing 으로 85만 써도된다
		map.put("홍", 90);
		map.put("동", 80);
		map.put("홍", 95); //'홍' 키가 같기 때문에 제일 마지막에 저장한 값으로 대치.
		System.out.println(map.size()); //저장된 총 Entry 수 얻기 3개. 키 중복 안됨 . 값은 중복 O
		
		//객체 찾기
		
		System.out.println(map.get("홍")+"\n"); //키 로 값을 검색 // 95
		
		//객체를 하나씩 처리
		
		Set<String> keySet = map.keySet(); //keySet얻기 //import
		
		
		Iterator<String> keyIterator = keySet.iterator(); //import
			while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println(key+" "+value);	//------------------반복해서 키를 얻고 값을 Map에서 얻어냄
			
		}
		//객체 삭제
			map.remove("홍"); //키로 Map.Entry를 제거
			System.out.println(map.size());
			
			
		//객체를 하나씩 처리
			//entrySet()메소드로 모든 Map.Entry를 Set컬렉션으로 얻은 다음, 반복자를 통해 Map.Entry를 하나씩 얻고
			//getKey() 와 getValue()메소드를 이용해 키와 값을 얻는다.
			Set<Map.Entry<String, Integer>> entrySet = map.entrySet(); //Map.EntrySet 얻기       ??
			Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
			
			while(entryIterator.hasNext()) {
				Map.Entry<String, Integer> entry = entryIterator.next();
				String key = entry.getKey();
				Integer value = entry.getValue();
				System.out.println(key+" "+value); //반복해서 Map.Entry를 얻고 키와 값을 얻어냄
				
				//객체 전체 삭제
				map.clear(); //모든 Map.Entry 삭제
				System.out.println(map.size());
				
						
			}
			
			
	}
}
