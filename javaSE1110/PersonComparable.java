package javaSE1110;

public class PersonComparable implements Comparable<PersonComparable>{//compareTo()�޼ҵ� ������
	public String name;
	public int age;
	
	public PersonComparable(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(PersonComparable a) {
		if(age < a.age) return -1;
		else if(age == a.age) return 0;
		else return 1;
		//��ü���� ������ -1 ������ 0 ����ũ�� 1 //��������
		//1 0 -1�� �ٲٸ� �ݴ� ��� //��������

	}
}