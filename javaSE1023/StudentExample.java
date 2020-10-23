package javaSE1023;

public class StudentExample {
	public static void main(String[] args) {
		Student s1 = new Student();
										//s1 s2변수가 Student 객체를 참조한다.
		Student s2 = new Student();
		System.out.println(s1); //heap영역의 주소?
	}

}
