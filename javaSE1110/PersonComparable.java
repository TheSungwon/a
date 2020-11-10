package javaSE1110;

public class PersonComparable implements Comparable<PersonComparable>{//compareTo()메소드 재정의
	public String name;
	public int age;
	
	public PersonComparable(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(PersonComparable a) {
		if(age < a.age) return -1;
		else if(age == a.age) return 0;
		else return 1;
		//객체보다 작으면 -1 같으면 0 보다크면 1 //오름차순
		//1 0 -1로 바꾸면 반대 결과 //내림차순

	}
}