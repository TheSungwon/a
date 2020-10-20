package jajvaSE1020;

public class forMultiplicationTableExample {
	public static void main(String[] args) {
		for (int a=2; a<=9; a++) {
			System.out.println(a + "´Ü" + "\n");
			
			for(int b=1; b<=9; b++) {
				System.out.print(a + "X" + b + "=" + (a*b) + "\n");
			}
		}
	}

}
