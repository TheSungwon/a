package javaSE1109;

public class ProductExample {

	public static void main(String[] args) {
		Product<Tv, String> a = new Product<>();
		a.setKind(new Tv());
		a.setModel("smartTV");
		Tv tv = a.getKind();
		String tvModel = a.getModel();
		
		
		Product<Car,String> b = new Product<>();
		b.setKind(new Car());
		b.setModel("disel");
		Car car = b.getKind();
		String carModel = b.getModel();
					
	}

}
