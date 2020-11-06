package javaSE1106;

public class Threadbbb extends Thread {
	
	@Override
	public void run() {
		for(int i=0; i<2; i++) {
			System.out.println(getName()); //getName() 스레드 이름 얻기 //Threadaaa 실행 내용
		}
	}
	

}
