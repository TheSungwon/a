package javaSE1110;

import java.util.TreeSet;

public class DescendingComparator_2 {
	//�������� �����ڸ� �̿��ؼ� TreeSet�� Fruit�� ����. �����ڸ� �����ʰ� TreeSet�� �����ϸ� ClassCasetException ���ܹ߻�������
	//�����ڸ� TreeSet�� �����ڿ� �ָ� ���ܰ� �߻����� �ʰ� �ڵ������� �������� ���ĵȴ�.
	
	public static void main(String[] args) {
		
	
	TreeSet<FruitComparable> a = new TreeSet<FruitComparable>(new DescendingComparator_1());
	
	
	
	
	}
}
