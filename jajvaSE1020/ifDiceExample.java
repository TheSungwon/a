package jajvaSE1020;

public class ifDiceExample {
	public static void main(String[] args) {
		
		int num = (int)(Math.random()*6) + 1; //�ֻ��� ��ȣ. 0.1-0.9 ���̰�*6�� intȭ 0~5 ���� +1 �ؼ� 1~6
		
		
		if(num ==1) {
			System.out.println("no1");
			
		}else if(num == 2) {
			System.out.println("no2");
			
		}else if(num == 3) {
			System.out.println("no3");
			
		}else if(num == 4) {
			System.out.println("no4");
			
		}else if(num == 5) {
			System.out.println("no5");
			
		}else {
			System.out.println("no6");
		}
	}

}
