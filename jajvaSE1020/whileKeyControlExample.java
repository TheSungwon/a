package jajvaSE1020;

public class whileKeyControlExample {
	public static void main(String[] args) throws Exception {
		
		boolean run = true;
		int speed = 0;
		int keyCode = 0;
		
		while(run) {
			if(keyCode!=13 && keyCode!=10) {
				System.out.println("------------");
				System.out.println("1증속 | 2감속 | 3중지");
				System.out.println("----------------");
				System.out.print("선택:");
				
			}
			
			keyCode = System.in.read();
			
			if(keyCode == 49) { //1을 읽었을 경우
				speed++;
				System.out.println("속도" + speed);
				
			}else if(keyCode == 50) {//2를 읽었을 경우
				speed--;
				System.out.println("속도" + speed);
				
			}else if(keyCode ==51) { //3을 읽었을 경우
				run = false;
			}			
		}
		System.out.println("종료");
	}

}
