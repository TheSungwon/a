package javaSE1022;

public class ArrayInArray {
	public static void main(String[] args) {
		
		int[][] math = new int[2][3];
		for(int i=0; i<math.length; i++) {
			for(int k=0; k<math[i].length; k++) {
				System.out.println(math[i][k]);
			}
		}
		
		System.out.println();
		
		int[][] english = new int[2][];
		english[0] = new int[2];
		english[1] = new int[3];
			for(int i=0; i<english.length; i++) {
				for(int k=0; k<english[i].length; k++) {
					System.out.println(english[i][k]);
				}
			}
			
			System.out.println();
			
			
			int[][] java = { {1,2}, {3,4,6} };
			for(int i=0; i<java.length; i++	) {
				for(int k=0; k<java[i].length; k++) {
					System.out.println(java[i][k]);
				}
			}
	}

}
