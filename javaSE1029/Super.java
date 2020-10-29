package javaSE1029;

public class Super {
	public String name;
	public String ssn;
	
	public Super(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
		
		//Super클래스는 기본생성자없이 name ssn을
		//매개값으로 받아 객체를 생성시키는 생성자만 있다
	}

}
