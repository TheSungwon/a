package jajvaSE1020;

public class switchCardExample {
	public static void main(String[] args) {
		
		char grade = 'B';
		
		switch(grade) {
		case 'A':
			System.out.println("우수");
			break;
		case 'B':
			System.out.println("일반");
			break;
			
			default:
			System.out.println("일반");
		}
	}

}
