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

}//  equals() �޼ҵ�� �������̵� O, hashCode()�޼ҵ�� �������̵� X - Object�� hashCode�޼ҵ尡 ����
