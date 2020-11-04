package javaSE1104;

public class Hashcode {
	public int num;
	
	public Hashcode(int num) {
		this.num = num;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Hashcode) {
			Hashcode a = (Hashcode) obj;
			if(this.num == a.num) { //if(num.equals(a.num))...?int String ? p.477
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
			return num; //.......?
	}

}//  equals() 메소드는 오버라이드 O, hashCode()메소드는 오버라이드 X - Object의 hashCode메소드가 사용됨
