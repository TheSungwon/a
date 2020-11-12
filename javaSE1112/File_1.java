package javaSE1112;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class File_1 {
	/* IO��Ű��(java.io) ���� �����ϴ� FileŬ������ ����ũ��,�Ӽ�,�̸� ���� ������ ���� ���, ���� ���� ���� ��� ����
	 * ���丮�� �����ϰ� �����ϴ� ���ϸ���Ʈ�� ���� ���. �׷��� ������ �����͸� �а� ���� ����� ����
	 * ������ ������� ��Ʈ���� ���. // File file = new File(���); /�� ���� �̽�������\\ �ι� ����ǥ ���̴ϱ�
	 * 
	 * File��ü�� �����ߴٰ� �ؼ� �����̳� ���丮�� �����Ǵ°� �ƴ�. �����ڸŰ������� �־��� ��ΰ� ��ȿ���� �ʴ���
	 * ������ ������ ���ܰ� �߻����� ����. �����̳� ���丮�� �ִ��� Ȯ���Ϸ��� exists()�޼ҵ带 ȣ��. �����Ѵٸ� true �ƴϸ� false
	 * boolean isExist = file.exists();
	 * 
	 * exists()�޼ҵ��� ���ϰ��� false��� createNewFile(), mkdir(), mkdirs()�޼ҵ�� ����, ���丮 ��������
	 * true�� can~(), get~() �� ���� ������ ��������.
	 *  
	 *  ���丮�� txt������ �����غ���
	 */

	public static void main(String[] args) throws Exception{
		File di = new File("C:\\Java2\\dif");
		File file = new File("C:\\Java2/file.txt");
		File uri = new File(new URI("file:///C:/Java2/uri.txt"));
		
		if(di.exists() == false) {di.mkdir();}
		if(file.exists() == false) {file.createNewFile();}
		if(uri.exists() == false) {uri.createNewFile();}
		
		File a = new File("C:\\Java2");
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd a HH:mm");
		
		File[] content = a.listFiles();
		
		for(File f : content) {
			System.out.println(dt.format(new Date(f.lastModified())));			
			if(f.isDirectory()) {
				System.out.println(f.getName());
			}else {
				System.out.println(f.length() + f.getName());
			}
		}
		
		
		
		
	}
}
