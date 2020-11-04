package javaSE1104;

public class Equals {
	public String id;
	
	public Equals(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Equals) {	//매개값이 Equals타입인지확인
			Equals a = (Equals) obj;
			if(id.equals(a.id)) { //if(this.num == a.num) ...? int String? p.476
				return true;	//강제타입변환하고 id필드값이 동일한지 검사 후, 동일하다면 true리턴
			}
		}
		return false;	//매개값이 Equals타입이 아니거나 id필드값이 다른경우 false를 리턴
	}

}
/*equals() 메소드를 오버라이드. 매개값(비교객체)과 기준객체와 동일한 타입인지 확인. Object 타입의 매개변수는 모든 객체가 매개값으로 제공될수있기때문
instanceof 연산자로 확인*/