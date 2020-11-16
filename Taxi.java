package ddddd;

public class Taxi extends Car{
	
	private int charge;
	private boolean fare;
	private String company;
	
	Taxi(String company){
		this.company=company;
				
	}
	
	public void accounts() {
		if(fare == true) {
			this.charge = this.speed*12;
		}else {
			this.charge = this.speed*10;
		}
				
	}
	public void setFare(boolean fare) {
		this.fare = fare;

		
	}
	public void display() {
		String ff = "할증";
		if(!fare) {
			ff = "일반";
		}
		System.out.println(company);
		System.out.println(charge);
		System.out.println(fare);
	}

}
