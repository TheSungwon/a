package javaSE1104;

public class Clone implements Cloneable{ //복제할수있다는 표시 없으면 복제X
	public String id;
	public int age;
	public boolean adult;
	
	public Clone(String id, int age, boolean adult) {
		this.id = id;
		this.age = age;
		this.adult = adult;
		
	}
	
	public Clone getClone() { //예외처리가 필요한 메소드이기때문에 try catch 구문필요
		Clone a = null;
		try {
			a = (Clone) clone(); // clone()메소드의 리턴타인은 Object이므로 Clone타입으로 캐스팅
		} catch(Exception e) {}
		return a;//getClone메소드에서 clone()메소드로 자신을 복제한 후 복제한 객체를 외부로 리턴 모르게따
	}

}
