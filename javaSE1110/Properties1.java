package javaSE1110;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

public class Properties1 {
	//Properties �� Hashtable�� ���� Ŭ���� �̹Ƿ� ��� Ư¡�� ������ �ִ�. �������� Ű�� ���� StringŸ������ ������ �÷���
	//���ø����̼��� �ɼ� ����, �����ͺ��̽� ���� ���� �׸��� ����ȭ(�ٱ���) ������ ����� ������Ƽ(~.properties)������ ���� �� �ַ� ���
	//������Ƽ ������ �б� ���ؼ� properties ��ü �����ϰ� load()�޼ҵ带 ȣ�� .�� �޼ҵ�� ������Ƽ ���Ϸκ��� �����͸� �б� ����
	//FileReader ��ü�� �Ű������� �޴´�.
	//Properties properties = new Properties ();
	//properties .load(new FileReader("C:/~/database.properties"));
	//									---------���ϰ��-------
	//������Ƽ ������ �Ϲ������� ~.class ���ϰ� �Բ� ����. Ŭ���������� �������� ������Ƽ�� ��θ� �������� Class�� getResource()�޼ҵ带 �̿�
	//�� �޼ҵ�� �־��� ������ ��� ��θ� URL��ü�� ����. URL�� getPath()�� ������ ���� ��θ� ����
	//Properties ��ü���� �ش� Ű�� ���� �������� getProperty()�޼ҵ带 �̿�. properties�� Map �÷����̹Ƿ� get()�޼ҵ�� ���� �������ִ�
	//�׷��� get()�޼ҵ�� ���� ObjectŸ������ �����ϹǷ� ����Ÿ�Ժ�ȯ�ؼ� String�� �����ϱ⿡ �Ϲ������� getProperty()�޼ҵ带 �̿�
	
	public static void main(String[] args) throws Exception {
		Properties a = new Properties();
		String path = Properties1.class.getResource("database.properties").getPath();
		path = URLDecoder.decode(path,"utf-8"); //�ѱۺ�ȯ
		a.load(new FileReader(path));
		
		String driver = a.getProperty("driver");
		String url = a.getProperty("url");
		//String username, String password
		
		System.out.println(driver);
		System.out.println(url);
		//System.out.println(username);
		//System.out.println(password);
	}
}
