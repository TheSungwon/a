package javaSE1109;

import java.util.*;

public class ArrayList1 {
	public static void main(String[] args) {			//<E> = 타입파라미터
		List<String> list = new ArrayList<>(); //List<E> list = new ArrayList<E>(); //뒤에 <>다이아몬드연산자 가능
		//ArrayList는 List 인터페이스의 구현 클래스. 배열은 생성할 때 크기가 고정되고 사용 중에 크기 변경 불가하지만 ArrayList는
		//capacity (저장용량) 초과한 객체들이 들어오면 자동적으로 늘어난다. 기본 생성자로 ArrayList객체를 생성하면 내부에 10개의 객체를
		//저장할수있는 초기용량을 가지게됨. 처음부터 크게 잡고 싶다면  //List<String) list = new ArrayList<String)(30); //30개 저장할수있는 용량
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("a");
		list.add(2,"d"); //2번인덱스 저장
		list.add("e"); //String 객체를 저장
		
		int size = list.size(); //저장된 총 객체 수 얻기 size()
		System.out.println(size); //6개
		System.out.println();
		
		String skill = list.get(2); //2번 인덱스의 객체 얻기 get()
		System.out.println(skill); //c
		System.out.println();
		
		for(int i=0; i<list.size(); i++) { //저장된 총 객체 수 만큼 루핑// 0~5부터 1씩 증가
			String str = list.get(i); //객체얻기 get()
			System.out.print(str);
			
		}
		System.out.println();
		
		list.remove(2); //2번인덱스 삭제 d
		list.remove(2); //2번인덱스 삭제 c
		list.remove("e"); //e 삭제
		
		for(String str2 : list) { //향상된 for문 이용 가능
			System.out.print(str2);
		}
		
	}

}
