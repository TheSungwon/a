package javaSE1022;

public class arr1 {
	public static void main(String[] args) {
		
		int arg1[] = {1,2,3,4,5}; //�迭���� ���� length 5
		int arg2[] = new int[10]; // �迭���� ����10
		
		System.arraycopy(arg1,0,arg2,3,5);//arg1�迭�� 0��°�ε�������
		//arg2�迭�� 3��° �ε������� 5�� �� ����
		
		for(int a : arg1)//for(int a=0; a<arg1.length; a++)
			System.out.println(a);
		System.out.println("--");
		for(int a : arg2)
			System.out.println(a);
			
	}

}
