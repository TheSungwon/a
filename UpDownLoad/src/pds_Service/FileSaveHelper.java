//사용자가 업로드 한 파일을 지정한 디렉터리에 저장해 주는 기능을 제공
//현재 시간과 임의의 숫자를 이요해서 파일명을생성하고 InputStream으로 부터 데이터를 읽어와
//파일에 쓰는 기능을 제공

package pds_Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class FileSaveHelper {
	
	private static Random random = new Random();
	
	public static String save(String directory, InputStream is)
	throws IOException{
		long currentTime = System.currentTimeMillis();
		int randomValue = random.nextInt(50);
		String fileName = Long.toString(currentTime) + "_" + Integer.toString(randomValue);
		//19~21 현재 시간 값long 과 0~50 사이의 임의 정수 값을 이용해서 파일명생성
		
		File file = new File(directory,fileName);
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(file);
			byte[] data = new byte[8096];
			int len = -1;
			while((len = is.read(data)) != -1) {
				os.write(data,0,len);	//26~30 inputstream으로부터 데이터를 읽어와 파일에 저장
			}
		}finally {
			if(os != null)
				try {
					os.close();
				}catch(IOException e) {
					
				}
		}
		return file.getAbsolutePath(); //저장한 파일의 실제 경로를 리턴
	}
}
