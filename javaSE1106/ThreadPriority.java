package javaSE1106;

public class ThreadPriority extends Thread{
	public ThreadPriority(String a){
		setName(a);} //������ �̸� ����		////Thread a = new ThreadPriority("--"+i);
	
	
	
	public ThreadPriority() {
		setName("name");  ////Thread a = new ThreadPriority();
	}
	
	
	
	
	@Override
	public void run() {
		for(int i=0; i<2000000000; i++) {
		}
		System.out.println(getName()); //�����尡 �� ���� 20�� ���� �� getNmaeȣ��

	}
}
