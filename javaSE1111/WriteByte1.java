package javaSE1111;


import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteByte1 { //OutputStream //��½�Ʈ��//���� //���
	public static void main(String[] args) throws Exception {
	OutputStream a = new FileOutputStream("C:\\java2\\test.txt"); //FileOutputStream���� ���ܹ߻�
	
	byte[] data = "asdf".getBytes();
	
	for(int i=0; i<data.length; i++) {
		a.write(data[i]);
		//test.txt�� asdf�� �ϳ��� ������ �ۼ�
		
		//for ���� �̿����� �ʰ�
		//a.write(data);�� ���൵ �ȴ�. =WriteByte2
	}
	a.flush();//��� ��Ʈ���� ���ο� ����buffer�� �־ �����Ͱ� ��µǱ� ����
	//���ۿ� �׿��ִٰ� ������� ���. flush()�޼ҵ�� ���ۿ� �ܷ��ϰ� �ִ� �����͸�
	//��� ��½�Ű�� ���۸� ���� ����. ���α׷����� �� �̻� ����� �����Ͱ� ���ٸ�
	//flush()�޼ҵ带 ���������� ȣ���Ͽ� ���ۿ� �ܷ��ϴ� ��� �����Ͱ� ��µǵ��� �ؾ��Ѵ�.
	
	a.close();
	//OutputStream�� �� �̻� ������� ���� ��쿡�� close()�޼ҵ带 ȣ���ؼ�
	//OutputStream���� ����ߴ� �ý��� �ڿ��� Ǯ���ش�.
	}

}
