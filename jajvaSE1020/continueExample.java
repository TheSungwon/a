package jajvaSE1020;

public class continueExample {
	public static void main(String[] args) throws Exception{
		
		for(int a=1; a<=10; a++) {
			if(a%2 !=0) {
				continue;
			}
			System.out.println(a);
		}
	}

}
