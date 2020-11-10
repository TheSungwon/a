package javaSE1110;

import java.util.TreeSet;

public class TreeSet_1 {
	/*검색기능 강화시킨 컬렉션프레임워크에선 컬렉션 트리셋과 트리맵 제공 set컬렉션과 map컬렉션
	 * 이 컬렉션들은 이진트리를 이용해서 계층적 구조
	 * 이진트리는 부모노드의 값보다 작은 노드는 왼쪽 , 부모 노드의 값보다 큰 노드는오른쪽
	 * 왼쪽 마지막 노드에서부터 읽으면 오름차순( 작은수부터 큰
	 * 오른쪽 마지막 노드에서부터 읽으면 내림차순
	 * 이진트리가 범위검색을 쉽게할 수 있는 이유는 값들이 정렬되어 있어 그룹핑이 쉽다
	 * 
	 * set인터페이스 타입 변수에 대입해도 되지만 TreeSet클래스 타입으로 대입한 이유는 찾거나 범위검색과 관련된 메소드를 사용하기 위해
	 * TreeSet<E> treeSet = new TreeSet<E>();
	 * TreeSet<String> treeSet = new TreeSet<String>();
	 */
	
	
	//특정 객체 찾기
	public static  void main(String[] args) {
		TreeSet<Integer> a = new TreeSet<Integer>();
		
		a.add(1);
		a.add(new Integer(6));
		a.add(new Integer(3));
		a.add(new Integer(9));
		a.add(new Integer(-1));
		
		Integer b=null;		
	
		b=a.first();
		System.out.println("가장낮은점수"+b);
		
		b=a.last();
		System.out.println("가장높은점수"+b);
		
		b=a.lower(1);
		System.out.println("1점 아래의 점수"+b);
		
		b=a.higher(new Integer(3));
		System.out.println("3점 위의 점수"+b);
		
		b=a.floor(new Integer(3));
		System.out.println("3점이거나 바로 아래의 점수"+b);
		
		b=a.ceiling(3);
		System.out.println("3점이거나 바로 위의 점수"+b);
		
		while(!a.isEmpty()) {
			b= a.pollFirst();
			System.out.println("남은객체수"+ a.size()); //객체 하나씩 빼기
		}
		
	}
}
