package javaSE1109;

import java.util.*;

public class ArrayList1 {
	public static void main(String[] args) {			//<E> = Ÿ���Ķ����
		List<String> list = new ArrayList<>(); //List<E> list = new ArrayList<E>(); //�ڿ� <>���̾Ƹ�忬���� ����
		//ArrayList�� List �������̽��� ���� Ŭ����. �迭�� ������ �� ũ�Ⱑ �����ǰ� ��� �߿� ũ�� ���� �Ұ������� ArrayList��
		//capacity (����뷮) �ʰ��� ��ü���� ������ �ڵ������� �þ��. �⺻ �����ڷ� ArrayList��ü�� �����ϸ� ���ο� 10���� ��ü��
		//�����Ҽ��ִ� �ʱ�뷮�� �����Ե�. ó������ ũ�� ��� �ʹٸ�  //List<String) list = new ArrayList<String)(30); //30�� �����Ҽ��ִ� �뷮
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("a");
		list.add(2,"d"); //2���ε��� ����
		list.add("e"); //String ��ü�� ����
		
		int size = list.size(); //����� �� ��ü �� ��� size()
		System.out.println(size); //6��
		System.out.println();
		
		String skill = list.get(2); //2�� �ε����� ��ü ��� get()
		System.out.println(skill); //c
		System.out.println();
		
		for(int i=0; i<list.size(); i++) { //����� �� ��ü �� ��ŭ ����// 0~5���� 1�� ����
			String str = list.get(i); //��ü��� get()
			System.out.print(str);
			
		}
		System.out.println();
		
		list.remove(2); //2���ε��� ���� d
		list.remove(2); //2���ε��� ���� c
		list.remove("e"); //e ����
		
		for(String str2 : list) { //���� for�� �̿� ����
			System.out.print(str2);
		}
		
	}

}
