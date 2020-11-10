package javaSE1110;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparableAndComparator {
	/*TreeSet의 객체와 TreeMap의 키는 저장과 동시에 자동오름차순으로 정렬한다 	숫자(Integer, Double)타입일 경우에는 값으로 정렬
	 * 문자열(String)일 경우에는 유니코드로 정렬. TreeSet,TreeMap은 정렬을 위해 java.lang.Comparable을 구현한 객체를 요구
	 * Integer Double String은 모두 Comparable인터페이스를 구현하고 있다.
	 * 사용자 정의 클래스도 Comparable을 구현한다면 자동정렬이 가능. 	Comparable에는 compareTo()메소드가 정의되어 있기때문에
	 * 사용자정의 클래스에서는 이 메소드를 오버라이딩하여 리턴값을 만들어내야한다.
	 *[객체와 같으면0 , 객체보다 작으면 -1, 객체보다 크면 1 을 리턴]
	 *
	 */

	public static void main(String[] args) {
		TreeSet<PersonComparable> aa = new TreeSet<>();
		
		aa.add(new PersonComparable("홍",8));
		aa.add(new PersonComparable("롱",3)); //aa.add("롱",3); --X
		aa.add(new PersonComparable("옹",10));
		
		Iterator<PersonComparable> bb = aa.iterator(); //왼쪽 마지막노드에서 오른쪽 마지막노드까지 반복해서 가져오기 (오름차순)
		while(bb.hasNext()) {
			PersonComparable person = bb.next();
			System.out.println(person.name + person.age);
			//PersonComparable 에서 comparTo 메소드를 반대로 하면 내림차순
		}
	}
}
