package javaSE1104;

public class Equals2 {
	public static void main(String argsp[]) {
		Equals o1 = new Equals("a");
		Equals o2 = new Equals("a");
		Equals o3 = new Equals("b");
		
		if(o1.equals(o2)) {
			System.out.println("같다");			
		} else {
			System.out.println("달라");
		}//매개값 Equals 타입이고 id필드값 동일
		
		
		if(o1.equals(o3)) {
			System.out.println("같다");			
		} else {
			System.out.println("달라");
		}//매개값 Equals 타입이지만 id필드값이 다름
	}

}
