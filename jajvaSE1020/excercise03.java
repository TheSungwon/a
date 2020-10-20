package jajvaSE1020;

public class excercise03 {
	public static void main(String[] args) {
		int a = 0;
		int b = 1;
		for(b=1; b<=100; b++) {
			if(b%3 ==0) {
				a += b;
			}
		}
		System.out.println(a);
	}

}
