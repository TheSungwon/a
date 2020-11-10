package javaSE1110;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparableAndComparator {
	/*TreeSet�� ��ü�� TreeMap�� Ű�� ����� ���ÿ� �ڵ������������� �����Ѵ� 	����(Integer, Double)Ÿ���� ��쿡�� ������ ����
	 * ���ڿ�(String)�� ��쿡�� �����ڵ�� ����. TreeSet,TreeMap�� ������ ���� java.lang.Comparable�� ������ ��ü�� �䱸
	 * Integer Double String�� ��� Comparable�������̽��� �����ϰ� �ִ�.
	 * ����� ���� Ŭ������ Comparable�� �����Ѵٸ� �ڵ������� ����. 	Comparable���� compareTo()�޼ҵ尡 ���ǵǾ� �ֱ⶧����
	 * ��������� Ŭ���������� �� �޼ҵ带 �������̵��Ͽ� ���ϰ��� �������Ѵ�.
	 *[��ü�� ������0 , ��ü���� ������ -1, ��ü���� ũ�� 1 �� ����]
	 *
	 */

	public static void main(String[] args) {
		TreeSet<PersonComparable> aa = new TreeSet<>();
		
		aa.add(new PersonComparable("ȫ",8));
		aa.add(new PersonComparable("��",3)); //aa.add("��",3); --X
		aa.add(new PersonComparable("��",10));
		
		Iterator<PersonComparable> bb = aa.iterator(); //���� ��������忡�� ������ ������������ �ݺ��ؼ� �������� (��������)
		while(bb.hasNext()) {
			PersonComparable person = bb.next();
			System.out.println(person.name + person.age);
			//PersonComparable ���� comparTo �޼ҵ带 �ݴ�� �ϸ� ��������
		}
	}
}
