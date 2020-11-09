package javaSE1109;

public class Util2 {
	public static <T extends Number> int compare(T a, T b) { ////제한된 타입 파라미터 <T extends 최상위타입>
		//상위타입이거나 상위 타입의 하위 or 구현클래스만 가능
		//메소드 {}안에 타입 파라미터 변수로 사용 가능한 것은 상위 타입의 멤버(필드, 메소드)로 제한. 하위 타입에만 있는 필드와 메소드는 사용불가
		
		double a1 = a.doubleValue();
		double b1 = b.doubleValue();
		return Double.compare(a1, b1);
		
	}

}
