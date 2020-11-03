package javaSE1103;

public class Null {
	public static void main(String[] args) {
		String a;
		a = null;
		//String a = null;
		System.out.println(a.toString());
	} //NullPointerException = 객체 참조가 없는 상태
		//null 값을 갖는 참조변수로 객체접근 연사자 . 를 사용했을때 발생
		//객체가 없는 상태에서 객체를 사용하려 했으니 예외 발생
		//a는 null을 갖고있기 때문에 String 객체를 참조하고 있지 않다.

}
