package javaSE1106;

public class ThreadPriority2 {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			
			Thread a = new ThreadPriority();
			
			Thread b = new ThreadPriority("aaa"+i);
			
			if(i !=10) {
				a.setPriority(Thread.MIN_PRIORITY);
			}else {
				a.setPriority(Thread.MAX_PRIORITY);
			}
			a.start();
		}

	}

}
