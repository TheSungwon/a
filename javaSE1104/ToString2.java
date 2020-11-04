package javaSE1104;

public class ToString2 {
	private String company;
	private String os;
	
	public ToString2(String company, String os) {
		this.company = company;
		this.os = os;
		
		
	}
	@Override
	public String toString() {
		return company+"  "+os; //tostring ¿Á¡§¿«	
		//return super.toString();
	}

}
