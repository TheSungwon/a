package jajvaSE1020;

import java.util.Scanner;

public class doWhileExample {
	public static void main(String[] args) {
		System.out.println("입력하세요");
		System.out.println("종료하려면 q를 입력");
		
		Scanner scanner = new Scanner(System.in);
		String inputString;
		
		do {
			System.out.print(">");
			inputString = scanner.nextLine();
			System.out.println(inputString);
		} while(! inputString.contentEquals("q"));
		
		System.out.println();
		System.out.println("종료");
	}

}
