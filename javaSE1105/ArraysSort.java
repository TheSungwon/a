package javaSE1105;

public class ArraysSort implements Comparable<ArraysSort>{ //�迭�׸����� . Arrays.sort()�޼ҵ��� �Ű������� �������ָ� �ڵ����� �������� ����
	// Comparable �������̽��� �����ϰ� �־�� ������ �ȴ�
	
		String name;
		ArraysSort(String name){
			this.name = name;
			
		}
		//Comparable<ArraysSort>�� ArraysSortŸ�Ը� ���ϱ� ���� ���׸�<>�� ���
		//compareTo()�޼ҵ�� �񱳰��� �����ϵ��� �������̵�. �� �޼ҵ��� ���ϰ��� ���������� �� �ڽ��� �Ű������� ���� ��� ���, ������� 0, ������� ������ ����
		//name�ʵ尪���� �����Ѵٰ� ������ �����ڵ�� �񱳸� �ؾ��Ѵ�. String�� compareTo() ���ϰ��� ���.. ������?

	
	
	
	@Override
	public int compareTo(ArraysSort a) {
		
		return name.compareTo(a.name);
	}
	

}
