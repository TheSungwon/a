package javaSE1104;

public class Clone implements Cloneable{ //�����Ҽ��ִٴ� ǥ�� ������ ����X
	public String id;
	public int age;
	public boolean adult;
	
	public Clone(String id, int age, boolean adult) {
		this.id = id;
		this.age = age;
		this.adult = adult;
		
	}
	
	public Clone getClone() { //����ó���� �ʿ��� �޼ҵ��̱⶧���� try catch �����ʿ�
		Clone a = null;
		try {
			a = (Clone) clone(); // clone()�޼ҵ��� ����Ÿ���� Object�̹Ƿ� CloneŸ������ ĳ����
		} catch(Exception e) {}
		return a;//getClone�޼ҵ忡�� clone()�޼ҵ�� �ڽ��� ������ �� ������ ��ü�� �ܺη� ���� �𸣰Ե�
	}

}
