package javaSE1112;
import java.io.File;
import java.io.FileWriter;

public class File_5 {
	/*FileWriter�� �ؽ�Ʈ �����͸� ���Ͽ� ������ �� ����ϴ� ���� ��� ��Ʈ��. ���� ������ �����ؼ� �ؽ�Ʈ�� �ƴ� �׸� ����� ���� ����
	 * �����͸� ���Ϸ� ������Ѵ�. 
	 * 
	 * FileWriter aa = new FileWriter("���");
	 * or
	 * FileWriter aa = Fiile("���");
	 * FileWriter bb = new FileWriter(aa);
	 * 
	 * ������ ������ ������ ��� �� ������ ���� ���� �ǹǷ� ���� ���� ���� �����͸� �߰��� ��쿡�� FileWriter�����ڿ� �� ��° �Ű������� true�� �ָ� �ȴ�.
	 * FileWriter�� Writer�� ����Ŭ���� �̹Ƿ� Wirter�� ������� ����. �� ���ڸ� �����ϱ� ���ؼ� wirte()�޼ҵ带 ���
	 * ���ڿ��������ϱ� ���ؼ��� Write(String str)	 �޼ҵ带 ���.
	 * wirte()�޼ҵ带 ȣ���� ���Ŀ� flush()�޼ҵ�� ��¹��ۿ��ִ� �����͸� ���Ϸ� ������ ����ϵ��� �ϰ� close()�޼ҵ带 ȣ���ؼ� ���ϴݱ�.
	 */

	
	
	public static void main(String[] args) throws Exception{
		
		File a = new File("C:\\Java2\\file.txt");
		FileWriter fw = new FileWriter(a,true);
		
		fw.write("FileWriter�� �ѱ�"+"\r\n");  //		\r\n�� ĳ�������ϰ� �����ǵ�� ����Ű�� ������ ���� ���� �ٲ۴�.
		fw.write("���ڿ����"+"\r\n");
		fw.flush();
		fw.close();
		System.out.println("��������");
	}
}
