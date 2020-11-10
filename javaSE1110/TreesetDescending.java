package javaSE1110;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreesetDescending {
	//descedingIterator()�޼ҵ�� ������������ ���ĵ� Iterator��ü�� ����. 
	//������������ �����ϰ� �ʹٸ� �ι� ȣ��
	//NavigableSet<E> descendingSet = treeSet .descendingSet ();
	//NavigableSet<E> ascendingSet = descendingSet.descendingSet ();
	
	public static  void main(String[] args) {
		TreeSet<Integer> a = new TreeSet<>();
		
		a.add(1);
		a.add(new Integer(6));
		a.add(new Integer(3));
		a.add(new Integer(9));
		a.add(new Integer(-1));
		
		NavigableSet<Integer> descendingSet = a.descendingSet();//�������� ����
		for(Integer b : descendingSet) {
			System.out.println(b);
		}
		System.out.println();
		
		NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();
		for(Integer c : ascendingSet) {
			System.out.println(c); //������������
		}

}
}