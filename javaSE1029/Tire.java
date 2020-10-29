package javaSE1029;

public class Tire {
	
	//Field
	
	public int max; //타이어 수명 max
	public int acc; //누석 회전수 acc
	public String lo; //타이어 위치 lo
	
	
	//Constructor
	//타이어 위치와 최대회전수를 매개값으로 받아 각각의 필드에 저장
	public Tire(String lo, int max) {
		this.lo = lo;		//필드에 초기화
		this.max = max;		//필드에 초기화
		
	}
}


