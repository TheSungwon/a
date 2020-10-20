package jajvaSE1020;

public class breakExample {
	public static void main(String[] args) {
		
		while(true) {
			int a = (int)(Math.random() * 6) +1;
			System.out.println(a);
			
			if(a == 6) {
				break;
			}
		}
		System.out.println("Á¾·á");
	}

}
