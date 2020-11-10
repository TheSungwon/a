package javaSE1110;

import java.util.Comparator;

public class DescendingComparator_1 implements Comparator<FruitComparable>{

	@Override
	public int compare(FruitComparable o1, FruitComparable o2) {
		if(o1.price < o2.price) return 1; //������ ���� ��� �ڿ� ���� �� o1�� //�Ƹ� ��������?
		else if(o1.price == o2.price) return 0;
		else return -1;
	}
	/*TreeSet�� ��ü�� TreeMap�� Ű�� Comparable�� �����ϰ� �������� ��쿡�� �����ϴ� ���� ClassCastException�߻�
	 * Comparable ���� ��ü�� �����ϴ� �����? Tree-- �������� �Ű������� ������(Comparator)�� �����ϸ� Comparable���� ��ü�� ���İ���
	 * TreeSet<E> treeSet = new TreeSet<E>( new AscendingComparator() ); �������� ������
	 * TreeMap<K, V> treeMap = new TreeMap<K,V>( new DescendingComparator() ); �������� ������
	 * 
	 * �����ڴ� Comparator�������̽��� ������ ��ü�� ���Ѵ�. Comparator�������̽��� ������ �޼ҵ�� ���ǵǾ��ִ�.
	 * compare(T o1, T o2) o1 o2�� �����ϸ� 0,  o1�� �տ� �����Ϸ��� -1, 		o1�� �ڿ������Ϸ��� 1 �� ����
	 */

	
}
