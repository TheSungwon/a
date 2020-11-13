package ddddd;

import java.util.HashMap;
import java.util.Scanner;

public class Contact_1 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		HashMap<String,String> m = new HashMap<>();
		
		System.out.println("[전화번호 저장하기]");
		System.out.print("사용자 수 입력");
		int n = s.nextInt();
		
		String nm;
		String nu;
		
		s.nextLine();
		
		for(int i=0; i<n; i++) {
			System.out.print("1. 이름 입력");
			nm=s.nextLine();
			
			System.out.print("2. 번호입력");
			nu=s.nextLine();
			
			m.put(nm, nu);
			
		}
		System.out.println("저장완료!");
		
		System.out.println("\n[검색하기]");
		while(true) {
			System.out.print("검색할 이름 입력");
			nm=s.nextLine();
			nu=m.get(nm);
			
			if(nm.equals("stop"))
				break;
				
			if(nu==null) {
				System.out.println("입력하신 이름은 존재하지 않습니다.");
			}else if(nu != null) {
				System.out.println(nm+"씨의 번호는"+nu+"입니다");
			}
			
			
		}
		System.out.println("프로그램을 종료합니다");

	}

}
