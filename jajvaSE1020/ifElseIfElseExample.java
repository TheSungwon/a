package jajvaSE1020;

public class ifElseIfElseExample {
	public static void main(String[] args) {
		
		int score = 75;
		
		if(score >= 90) {
			System.out.println("100-90점");
			
		} else if(score >= 80) {
			System.out.println("80-89점");
		} else if(score >= 70) {
			System.out.println("70-79점");
		} else {
			System.out.println("70점 미만");
		}
	}
}
