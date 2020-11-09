package javaSE1109;
import java.util.*;
public class Vector1 { //Vector는 ArrayList와 동일한 내부 구조를 가지고 있다. 생성하는 방법 List<E> list = new Vector<E>() ;
						// 저장할 객체 타입을 타입파라미터로 표기하고 기본생성자를 호출.
	//ArrayList와 다른점은 Vector는 동기화된(synchronized) 메소드로 구성. 멀티스레드 불가. 하나의 스레드가 실행을 완료해야만 다른 스레드 실행가능
	//그래서 멀티스레드 환경에서 안전하게 객체를 추가 삭제. 이것을 스레드가 안전하다라고한다 Thread Safe
	
	public static void main(String[] args) {
		List<Board> list = new Vector<Board>(); //Board객체 생성. Board클래스 생성. ///객체를 추가 삭제 검색
		
		list.add(new Board("AAA","BBB","CCC")); //Board객체를 저장 //Board(String a, String b, String c) 각각 저장
		list.add(new Board("AAA1","BBB1","CCC1"));
		list.add(new Board("AAA2","BBB2","CCC2"));
		list.add(new Board("AAA3","BBB3","CCC3"));
		list.add(new Board("AAA4","BBB4","CCC4"));
		
		list.remove(2); //2번인덱스 AAA2 삭제후 1씩 당겨짐
		list.remove(3); //3번인덱스 AAA4 삭제 
		
		
		for(int i=0; i<list.size(); i++) {
			Board board = list.get(i);
			System.out.println();
		}
	}
}
