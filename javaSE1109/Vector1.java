package javaSE1109;
import java.util.*;
public class Vector1 { //Vector�� ArrayList�� ������ ���� ������ ������ �ִ�. �����ϴ� ��� List<E> list = new Vector<E>() ;
						// ������ ��ü Ÿ���� Ÿ���Ķ���ͷ� ǥ���ϰ� �⺻�����ڸ� ȣ��.
	//ArrayList�� �ٸ����� Vector�� ����ȭ��(synchronized) �޼ҵ�� ����. ��Ƽ������ �Ұ�. �ϳ��� �����尡 ������ �Ϸ��ؾ߸� �ٸ� ������ ���డ��
	//�׷��� ��Ƽ������ ȯ�濡�� �����ϰ� ��ü�� �߰� ����. �̰��� �����尡 �����ϴٶ���Ѵ� Thread Safe
	
	public static void main(String[] args) {
		List<Board> list = new Vector<Board>(); //Board��ü ����. BoardŬ���� ����. ///��ü�� �߰� ���� �˻�
		
		list.add(new Board("AAA","BBB","CCC")); //Board��ü�� ���� //Board(String a, String b, String c) ���� ����
		list.add(new Board("AAA1","BBB1","CCC1"));
		list.add(new Board("AAA2","BBB2","CCC2"));
		list.add(new Board("AAA3","BBB3","CCC3"));
		list.add(new Board("AAA4","BBB4","CCC4"));
		
		list.remove(2); //2���ε��� AAA2 ������ 1�� �����
		list.remove(3); //3���ε��� AAA4 ���� 
		
		
		for(int i=0; i<list.size(); i++) {
			Board board = list.get(i);
			System.out.println();
		}
	}
}
