package javaSE1110;

import java.util.Comparator;

public class DescendingComparator_1 implements Comparator<FruitComparable>{

	@Override
	public int compare(FruitComparable o1, FruitComparable o2) {
		if(o1.price < o2.price) return 1; //가격이 적을 경우 뒤에 오게 함 o1을 //아마 내림차순?
		else if(o1.price == o2.price) return 0;
		else return -1;
	}
	/*TreeSet의 객체와 TreeMap의 키가 Comparable을 구현하고 있지않을 경우에는 저장하는 순간 ClassCastException발생
	 * Comparable 비구현 객체를 정렬하는 방법은? Tree-- 생성자의 매개값으로 정렬자(Comparator)를 제공하면 Comparable비구현 객체로 정렬가능
	 * TreeSet<E> treeSet = new TreeSet<E>( new AscendingComparator() ); 오름차순 정렬자
	 * TreeMap<K, V> treeMap = new TreeMap<K,V>( new DescendingComparator() ); 내림차순 정렬자
	 * 
	 * 정렬자는 Comparator인터페이스를 구현한 객체를 말한다. Comparator인터페이스를 다음의 메소드로 정의되어있다.
	 * compare(T o1, T o2) o1 o2가 동등하면 0,  o1이 앞에 오게하려면 -1, 		o1이 뒤에오게하려면 1 을 리턴
	 */

	
}
