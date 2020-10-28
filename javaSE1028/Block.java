package javaSE1028;

public class Block {
	int speed;
	
	void run() {
		System.out.println(speed+"달립니다");
		
	}
	
	public static void main(String[] arguments) {
		Block a = new Block();//객체생성
		//main()메소드도 정적(static)메소드 이므로
		//객체 생성없이 인스턴스 필드와 인스턴스메소드를
		//main()메소드에서 바로사용할수없음
		
		a.speed = 1;
		a.run();
	}
	

}
