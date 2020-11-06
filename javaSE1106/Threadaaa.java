package javaSE1106;

public class Threadaaa extends Thread {
	public Threadaaa() {
		setName("Threadaaa"); //스레드 이름 설정
		//super("Threadaaa"); super도 가능
		
	}
	@Override
	public void run() {
		for(int i=0; i<2; i++) {
			System.out.println(getName()); //getName() 스레드 이름 얻기 //Threadaaa 실행 내용
		}
	}
	

}
