package javaSE1102;

public class Tire4 { //인터페이스 타입필드선언과 초기구현객체대입
	
	Tire a = new Tire2();
	Tire b = new Tire2();
	Tire c = new Tire2();
	Tire d = new Tire2();
	
	void run() {//인터페이스에서 설명된 roll()호출
		a.roll();
		b.roll();
		c.roll();
		d.roll();
		
	}

}
