package javaSE1022;

public class ArrauCreateByVaueListExample2 {
	public static void main(String[] args) {
		
		int[] scores;
		
		scores = new int[] {1, 2, 3};
		
		int sum1 = 0;
		
		for(int i=0; i<scores.length; i++) {
			sum1 += scores[i];
			
		}
		System.out.println("��"+sum1);
		//���ϵ� ������ sum2�� ����
		
		int sum2 = add( new int[] {5, 6, 7});
		System.out.println("����"+sum2);
		System.out.println();
	}
	//������ ����ؼ� �����ϴ� �޼ҵ�
	public static int add( int[] scores) {
		int sum = 0;
		for(int i=0; i<scores.length; i++) {
			sum += scores[i];
			
		}
		return sum;
	}

}
