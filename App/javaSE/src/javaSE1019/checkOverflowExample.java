package javaSE1019;

public class checkOverflowExample {
	public static void main(String[] args) {
		try {
			int a = safeAdd(2000000000, 2000000000);
			System.out.println(a);
		} catch(ArithmeticException e) {
			System.out.println("오버플로우");
		}
		
		public static int safeAdd(int left, int right)	{
			if((right>0)) {
				if(left>(Integer.MAX_VALUE - right)) {
					throw new ArithmeticException("오버플로우")
				}
				
				}
			}
		}
	}

}
