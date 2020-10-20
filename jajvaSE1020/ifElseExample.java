package jajvaSE1020;

public class ifElseExample {
	public static void main(String[] args) {
		
		int score = 85;
		
		if(score >= 90) {
			System.out.println("90보다 큼");
			System.out.println("A등급");
		} else { // score < 90 일 경우
			System.out.println("90보다 작음");
			System.out.println("B등급");
		}
	}

}
