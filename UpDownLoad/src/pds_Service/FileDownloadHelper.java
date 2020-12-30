//파일 데이터를 response에 출력한다
//이 클래스는 특정 경로의 파일 데이터를 OutputStream으로 출력하는 기능 제공

package pds_Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileDownloadHelper {
	public static void copy(String filePath, OutputStream os)throws IOException{
		FileInputStream is = null;
		try {
			is = new FileInputStream(filePath); //파일에서 데이터 읽어오는 inputstream생성
			byte[] data = new byte[8096];
			int len = -1;
			while((len = is.read(data)) != -1) { //파일에서 데이터 읽어와 출력스트림os에 데이터출력
				os.write(data,0,len);
			}
			
		}finally {
			if(is != null)
				try {
					is.close();
				}catch(IOException e) {
					
				}
		}
	}

}
