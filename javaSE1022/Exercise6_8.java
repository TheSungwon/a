package javaSE1022;

public class Exercise6_8 {
	public static void main(String[] args) {
		
		int[][] array = {
				{1,2},
				{3,4,5},
				{6,7,8,9,10}
				
		};
		int count = 0; // �迭��?
		
		int sum = 0;
		double avg = 0.0;
		
		for(int i=0; i<array.length; i++) {
			for(int k=0; k<array[i].length; k++) {
				sum += array[i][k];
				
				count++; // ����
				System.out.println(count);// count 10��?
			}
		}
		System.out.println(sum);
		
		avg = (double) sum / count;
		System.out.println(avg);
		

	}

}
