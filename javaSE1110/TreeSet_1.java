package javaSE1110;

import java.util.TreeSet;

public class TreeSet_1 {
	/*�˻���� ��ȭ��Ų �÷��������ӿ�ũ���� �÷��� Ʈ���°� Ʈ���� ���� set�÷��ǰ� map�÷���
	 * �� �÷��ǵ��� ����Ʈ���� �̿��ؼ� ������ ����
	 * ����Ʈ���� �θ����� ������ ���� ���� ���� , �θ� ����� ������ ū ���¿�����
	 * ���� ������ ��忡������ ������ ��������( ���������� ū
	 * ������ ������ ��忡������ ������ ��������
	 * ����Ʈ���� �����˻��� ������ �� �ִ� ������ ������ ���ĵǾ� �־� �׷����� ����
	 * 
	 * set�������̽� Ÿ�� ������ �����ص� ������ TreeSetŬ���� Ÿ������ ������ ������ ã�ų� �����˻��� ���õ� �޼ҵ带 ����ϱ� ����
	 * TreeSet<E> treeSet = new TreeSet<E>();
	 * TreeSet<String> treeSet = new TreeSet<String>();
	 */
	
	
	//Ư�� ��ü ã��
	public static  void main(String[] args) {
		TreeSet<Integer> a = new TreeSet<Integer>();
		
		a.add(1);
		a.add(new Integer(6));
		a.add(new Integer(3));
		a.add(new Integer(9));
		a.add(new Integer(-1));
		
		Integer b=null;		
	
		b=a.first();
		System.out.println("���峷������"+b);
		
		b=a.last();
		System.out.println("�����������"+b);
		
		b=a.lower(1);
		System.out.println("1�� �Ʒ��� ����"+b);
		
		b=a.higher(new Integer(3));
		System.out.println("3�� ���� ����"+b);
		
		b=a.floor(new Integer(3));
		System.out.println("3���̰ų� �ٷ� �Ʒ��� ����"+b);
		
		b=a.ceiling(3);
		System.out.println("3���̰ų� �ٷ� ���� ����"+b);
		
		while(!a.isEmpty()) {
			b= a.pollFirst();
			System.out.println("������ü��"+ a.size()); //��ü �ϳ��� ����
		}
		
	}
}
