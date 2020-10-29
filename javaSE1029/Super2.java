package javaSE1029;

public class Super2 extends Super {
	public int No;
	
	public Super2(String name, String ssn, int No) {
		super(name, ssn);
		this.No = No;
		//super2 클래스는 생성자에서 super(name,ssn)으로
		//super 클래스의 생성자를 호출해야한다
	}

}
