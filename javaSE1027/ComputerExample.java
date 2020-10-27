package javaSE1027;

public class ComputerExample {
	public static void main(String[] args) {
		Computer my = new Computer();
		
		int[] a1 = {1,2,3,4,5};
		int result1 = my.sum1(a1);
		System.out.println(result1);
		
		System.out.println();
		
		int result2 = my.sum1(new int[] {1,2,3});
		System.out.println(result2);
		
		System.out.println();
		
		
		int result3 = my.sum2(2,3,4);
		System.out.println(result3);
		
		System.out.println();
		
		int result4 = my.sum2(5,3,2);
		System.out.println(result4);
	}

}
