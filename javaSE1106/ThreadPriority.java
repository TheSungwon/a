package javaSE1106;

public class ThreadPriority extends Thread{
	public ThreadPriority(String a){
		setName(a);} //스레드 이름 변경		////Thread a = new ThreadPriority("--"+i);
	
	
	
	public ThreadPriority() {
		setName("name");  ////Thread a = new ThreadPriority();
	}
	
	
	
	
	@Override
	public void run() {
		for(int i=0; i<2000000000; i++) {
		}
		System.out.println(getName()); //스레드가 할 내용 20억 루핑 후 getNmae호출

	}
}
