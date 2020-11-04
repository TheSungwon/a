package javaSE1104;

public class ThinClone {

	public static void main(String[] args) {
	//원본객체생성
		
		Clone ori = new Clone("홍길동",12,true);
		
		//복제 객체를 얻은 후 age 변경
		
		Clone a = ori.getClone();
		a.age = 23;
		
		System.out.println("복제필드"+a.age);
		
		System.out.println("원본"+ori.age);
	}

}
