package jajvaSE1020;

public class Excercise04 {
	public static void main(String[] args) {
		while(true) {
			int a = (int)(Math.random()*6)+1;
			int b = (int)(Math.random()*6)+1;
			System.out.println(a + "," + b);
			if(a+b == 5) {
				break;
			}
		}
	}

}
