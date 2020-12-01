package javaCookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class javaCookieBox {
		/*
		 * resoponse.addCOokie()�� �߰��Ǵ� ��Ű�� ������ set-cookie����� ���ؼ� ���޵ȴ� �� ���� set-cookie�����
		 * �� ���� ��Ű ���� ����. ��¹��ۿ� ����Ǿ� �ִ� ������ �÷��� �Ǿ� �� �������� �����Ͱ� ���۵Ǹ� �� ���� ���ʹ� ���� ����� ���ο�
		 * ������ �߰��� �� ���ٰ� �ߴ� ���� ��� ��Ű�� ���� ��� ���·� �� �������� ����. ��Ű���� ��¹��۰� �÷��� �� ���� ���Ӱ� �߰�
		 * �Ӱ�. ���� ��Ű�� �߰� �� ������ �ݵ�� ��� ���۰� �÷��� �Ǳ� ���� ó���������
		 */
//		��Ű����� �����ͼ� if esle��Ͽ��� ��Ű �̸��� ���ؼ� �ʿ��� ��Ű��
		//���ϴ�	���� ��ƿ��Ƽ Ŭ���� // ��Ű�ڽ�
		
	
		private Map<String, Cookie> cookieMap = //private
				new HashMap<>();
		//��Ű�� (��Ű�̸�, cookie��ü>�� ���·� �����ϴ� ��. generic
		
		public javaCookieBox(HttpServletRequest request) {
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for(int i=0; i<cookies.length; i++){
					cookieMap.put(cookies[i].getName(),cookies[i]);
				}
			}
		}//Ŭ����������. Ŭ���� ��ä�� ������ �� ���. ���ڷ� ���޹��� request�κ���
		//cookie�迭�� �о��[16���� ����cookie��ü�� [23���ο��� ������ cookieMap�� ���� [����31

		
		public static Cookie createCookies(String name, String value)
		throws IOException {
			return new Cookie(name, URLEncoder.encode(value, "euc-kr"));
		}//�̸��� name�̰� ���� value�� ��ü�� ������ ����
		
		public static Cookie createCookies(String name, String value, String path, int maxAge)
				throws IOException {
					Cookie cookie = new Cookie(name, URLEncoder.encode(value, "euc-kr"));
					cookie.setPath(path);
					cookie.setMaxAge(maxAge);
					return cookie;
		}//�̸���name ����value ��ΰ�path ��ȿ�ð�maxAge�� cookie��ü�� �����ؼ� ����
					
		public static Cookie createCookies(String name, String value, String path, int maxAge, String domain)
				throws IOException {
					Cookie cookie = new Cookie(name, URLEncoder.encode(value, "euc-kr"));
					cookie.setPath(path);
					cookie.setMaxAge(maxAge);
					cookie.setDomain(domain);
					return cookie;				
		}
		
		public Cookie getCookie(String name) {
			return cookieMap.get(name);
			
		}//cookieMap�� ����� ��Ű���� ������ �̸���cookie��ü�� ���Ѵ�.
		//������ �̸��� ��Ű�� �������� ������ null�� ����
		
		public String getValue(String name) throws IOException{
			Cookie cookie = cookieMap.get(name);
			if(cookie == null) {
				return null;
			}
			return URLDecoder.decode(cookie.getValue(),"euc-kr");
		}//cookieMapo�� ����� ��Ű���� ������ �̸��� cookie��ü�� ������
		//�� cookie��ü�� ���� ���Ѵ�.������ �̸��� ��Ű�� �������������� null����
		
		public boolean exists(String name) {
			return cookieMap.get(name) != null;
		}//������ �̸��� cookie�� ������ ��� true �ƴϸ� false�� ����
		//������ �̸��� ��Ű�� �������� ������ null����
		
		
		
		
		
		
}
