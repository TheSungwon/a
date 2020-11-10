package javaSE1110;

import java.util.TreeSet;

public class DescendingComparator_2 {
	//내림차순 정렬자를 이용해서 TreeSet에 Fruit을 저장. 정렬자를 주지않고 TreeSet에 저장하면 ClassCasetException 예외발생하지만
	//정렬자를 TreeSet의 생성자에 주면 예외가 발생하지 않고 자동적으로 내림차순 정렬된다.
	
	public static void main(String[] args) {
		
	
	TreeSet<FruitComparable> a = new TreeSet<FruitComparable>(new DescendingComparator_1());
	
	
	
	
	}
}
