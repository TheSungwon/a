package javaSE1103;

public class TryCatchFinally {
	public static void main(String[] args) {
		try {
			Class a = Class.forName("java.lang.String2");
		} catch(ClassNotFoundException e) {
			System.out.println("nothing");
		}
	}

}
//Clss.forNmae()메소드는 매개값으로 주어진 클래스가 존재하면 Class객체를 리턴, 존재하지 않으면 ClassNotFoundException 예외 발생
//java.lang.String2 클래스가 존재하지 않기 때문.