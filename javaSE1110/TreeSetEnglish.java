package javaSE1110;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetEnglish {
	public static void main(String[] args) {
		TreeSet<String> a = new TreeSet<>();

		a.add("d");
		a.add("sdfd");
		a.add("retd");
		a.add("ted");
		a.add("zd");
		a.add("thd");
		a.add("yud");
		a.add("md");
		
		System.out.println("������ a~z ������ �˻��ܾ�");
		
		NavigableSet<String> b = a.subSet("a",true,"{",true); // a~z ���� �˻� (y����?)// {�� �̿��ؼ� z ������
		for(String word : b) {
			System.out.println(word);
		}
	}

}
