package javaSE1110;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreesetDescending {
	//descedingIterator()메소드는 내림차순으로 정렬된 Iterator객체를 리턴. 
	//오름차순으로 정렬하고 싶다면 두번 호출
	//NavigableSet<E> descendingSet = treeSet .descendingSet ();
	//NavigableSet<E> ascendingSet = descendingSet.descendingSet ();
	
	public static  void main(String[] args) {
		TreeSet<Integer> a = new TreeSet<>();
		
		a.add(1);
		a.add(new Integer(6));
		a.add(new Integer(3));
		a.add(new Integer(9));
		a.add(new Integer(-1));
		
		NavigableSet<Integer> descendingSet = a.descendingSet();//내림차순 정렬
		for(Integer b : descendingSet) {
			System.out.println(b);
		}
		System.out.println();
		
		NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();
		for(Integer c : ascendingSet) {
			System.out.println(c); //오름차순정렬
		}

}
}