package ddddd;

import java.util.HashMap;
import java.util.Scanner;

public class Contact_1 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		HashMap<String,String> m = new HashMap<>();
		
		System.out.println("[��ȭ��ȣ �����ϱ�]");
		System.out.print("����� �� �Է�");
		int n = s.nextInt();
		
		String nm;
		String nu;
		
		s.nextLine();
		
		for(int i=0; i<n; i++) {
			System.out.print("1. �̸� �Է�");
			nm=s.nextLine();
			
			System.out.print("2. ��ȣ�Է�");
			nu=s.nextLine();
			
			m.put(nm, nu);
			
		}
		System.out.println("����Ϸ�!");
		
		System.out.println("\n[�˻��ϱ�]");
		while(true) {
			System.out.print("�˻��� �̸� �Է�");
			nm=s.nextLine();
			nu=m.get(nm);
			
			if(nm.equals("stop"))
				break;
				
			if(nu==null) {
				System.out.println("�Է��Ͻ� �̸��� �������� �ʽ��ϴ�.");
			}else if(nu != null) {
				System.out.println(nm+"���� ��ȣ��"+nu+"�Դϴ�");
			}
			
			
		}
		System.out.println("���α׷��� �����մϴ�");

	}

}
