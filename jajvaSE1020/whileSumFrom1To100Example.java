package jajvaSE1020;

public class whileSumFrom1To100Example {
	public static void main(String[] args) {
		int sum = 0;
		
		int a = 1;
		
		while(a<=100) {
			sum += a;
			a++;
			}
		System.out.println("1~"+(a-1)+"гу"+"  "+sum);
	}

}
