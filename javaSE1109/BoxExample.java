package javaSE1109;

public class BoxExample {

	public static void main(String[] args) {
		Box box = new Box();
		box.set("aaa");		//String ���� Object �ڵ���ȯ
		String name = (String) box.get(); //Object ���� String ����Ÿ�Ժ�ȯ
		
		
		box.set(new Apple()); //Apple ���� Object �ڵ���ȯ
		Apple apple = (Apple) box.get(); //Object ���� Apple ����Ÿ�Ժ�ȯ
		

	}

}
