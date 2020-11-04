package javaSE1104;

public class Equals {
	public String id;
	
	public Equals(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Equals) {	//�Ű����� EqualsŸ������Ȯ��
			Equals a = (Equals) obj;
			if(id.equals(a.id)) { //if(this.num == a.num) ...? int String? p.476
				return true;	//����Ÿ�Ժ�ȯ�ϰ� id�ʵ尪�� �������� �˻� ��, �����ϴٸ� true����
			}
		}
		return false;	//�Ű����� EqualsŸ���� �ƴϰų� id�ʵ尪�� �ٸ���� false�� ����
	}

}
/*equals() �޼ҵ带 �������̵�. �Ű���(�񱳰�ü)�� ���ذ�ü�� ������ Ÿ������ Ȯ��. Object Ÿ���� �Ű������� ��� ��ü�� �Ű������� �����ɼ��ֱ⶧��
instanceof �����ڷ� Ȯ��*/