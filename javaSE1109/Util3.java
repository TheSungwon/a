package javaSE1109;

public class Util3 {
			//제한된 타입 파라미터 <T extends 최상위타입>
	public static void main(String[] args) {
		
		int result = Util2.compare(2, 3); //int
		
		System.out.println(result);
		
		int result2 = Util2.compare(1.1, 2.2); //double
		System.out.println(result2);

	}

}
