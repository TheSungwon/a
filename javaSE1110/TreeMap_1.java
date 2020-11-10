package javaSE1110;

import java.util.Map;
import java.util.TreeMap;

public class TreeMap_1 {
	/*이진트리를 기반으로 한 Map컬렉션	 TreeSet과 차이점은 키와 값이 저장된 Map.Entry를 저장. TreeMap에 객체를 저장하면 자동으로 정렬
	 * 기본적으로 부모키값과 비교해서 키 값이 낮은 것은 왼쪽 자식노드에 키 값이 노은 것은 오른쪽 자식노드에 Map.Entry 객체를 저장
	 * 
	 * 
	 * Map인터페이스 타입변수에 대입해도 되지만 TreepMap 클래스 타입으로대입한 이유는 특정 객체를찾거나 범위 검색과 관련된 메소드를 사용하기 위해
	 */
	
	//특정 Map.Entry찾기
	public static void main(String[] args) {
		TreeMap<Integer, String> a = new TreeMap<>();
		
		a.put(new Integer(1),"홍");
		a.put(6, "이");
		a.put(-2, "김");
		a.put(22, "심");
		a.put(12, "딤");
		
		Map.Entry<Integer, String> b = null;
		
		b = a.firstEntry();
		System.out.println(b);
		System.out.println(b.getKey()); //가장낮은점수
		System.out.println(b.getValue());//이름
				System.out.println("\n");
				
				/////중략
		
		while(!a.isEmpty()) { //남아있으면 true 리턴하다가 없으면 false리턴
			b = a.pollFirstEntry();
			System.out.println(b.getKey()+" "+b.getValue()+"남은객체수"+a.size());
		}
	}
}
