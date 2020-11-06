package javaSE1106;

public class Synchronized1 {
	private int mem;
	
	public int getMem() {
		return mem;
	}
	
	//	동기화 메소드 수정
	
	public synchronized void setMem(int mem) {		//Synchronized1 메모리에 값을 저장하는 메소드 // synchronized추가
		this.mem = mem;		//매개값을 mem필드에 저장
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {} // 스레드를 2초간 일시정짓 ㅣ킴
		System.out.println(Thread.currentThread().getName() + this.mem);
							//스레드의 이름				메모리값
	}
	
		
	
	/*
	public void setMem(int mem) {		//Synchronized1 메모리에 값을 저장하는 메소드
		this.mem = mem;		//매개값을 mem필드에 저장
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {} // 스레드를 2초간 일시정짓 ㅣ킴
		System.out.println(Thread.currentThread().getName() + this.mem);
							//스레드의 이름				메모리값
	}
	*/
}
