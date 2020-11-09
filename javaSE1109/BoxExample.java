package javaSE1109;

public class BoxExample {

	public static void main(String[] args) {
		Box box = new Box();
		box.set("aaa");		//String 에서 Object 자동변환
		String name = (String) box.get(); //Object 에서 String 강제타입변환
		
		
		box.set(new Apple()); //Apple 에서 Object 자동변환
		Apple apple = (Apple) box.get(); //Object 에서 Apple 강제타입변환
		

	}

}
