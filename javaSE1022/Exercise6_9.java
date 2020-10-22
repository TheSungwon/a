package javaSE1022;
import java.util.Scanner; //???
public class Exercise6_9 {
	public static void main(String[] args) {
		boolean run = true;
		int stuNum =0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in); //??
		
		while(run) {
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("1학생"+"2점수"+"3리스트"+"4분석"+"5종료");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
			System.out.print("선택> ");
			
			
			int selectNo = scanner.nextInt();
			
			if(selectNo == 1) {
				System.out.println("학생수");
				stuNum = scanner.nextInt();
				scores = new int[stuNum];
				
			}else if(selectNo ==2) {
				for(int i=0; i<scores.length; i++) {
					System.out.println("scores"+i);
					scores[i] = scanner.nextInt();
					
				}
			}else if(selectNo ==3) {
				for(int i=0; i<scores.length; i++) {
					System.out.println("scores"+i);
					
				}
			}else if(selectNo ==4) {
				int max = 0;
				int sum = 0;
				double avg = 0;
				for(int i=0; i<scores.length; i++) {
					max = (max<scores[i])? scores[i] : max;
					sum += scores[i];
					avg = (double) sum / stuNum;
			
				}
				System.out.println(max);
				System.out.println(sum);
				System.out.println(avg);
			}else if(selectNo ==5) {
				run = false;
				System.out.println("종료");
			}
		}
		
		
	}

}
