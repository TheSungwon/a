package jajvaSE1020;

public class switchNoBreakCaseExample {
	public static void main(String[] args)	{
		
		int time = (int)(Math.random()*4) +8; //8<= .. <==11 사이의 정수
		
		switch(time) {

		case 8:
			System.out.println("출근");
		
		case 9:
			System.out.println("회의");
			
		case 10:
			System.out.println("업무");
			
		default:
			System.out.println("외근");
		}
	}

}
