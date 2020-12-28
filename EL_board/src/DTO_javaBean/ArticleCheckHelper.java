/*�Խñ� ���� ���� ����� �Խñ� ����� �� �Է��� ��ȣ�� ������ ��ȣ�� �Է��ؾ�
���� �� ������ �����ϵ��� ����// ���� ��ɰ� ���� ��ɿ��� ��ȣ�� Ȯ���ϴ� �����
�ʿ���ϱ� ������ ��ȣ Ȯ�� ����� ���� Ŭ������ �з��ؼ� �ڵ尡 �ߺ����� �ʵ��� �ߴ�.

check~password�޼���� �Խñ��� �����ϴ����� ���ο� ����ڰ� �Է��� ��ȣ�� ���� �Խñ��� ��ȣ��
���������� ���θ� Ȯ��// �Խñ��� �����ϰ� ��ȣ�� ��ġ�ϸ� �ش� Article��ü�� �����Ѵ�.
*/

package DTO_javaBean;

import java.sql.Connection;
import java.sql.SQLException;

import DAO_bean.ArticleDao;
import DTO_javaBean.Article;
import Exception_board.ArticleNotFoundException;
import Exception_board.InvalidPasswordException;

public class ArticleCheckHelper {
	
	public Article checkExistsAndPassword(Connection conn, int articleId, String password)throws
	SQLException, ArticleNotFoundException,InvalidPasswordException{
		ArticleDao articleDao = ArticleDao.getInstance();
		Article article = articleDao.selectById(conn, articleId);
		if(article == null) {
			throw new ArticleNotFoundException("�Խñ۾���"+articleId);
		}
		if(!checkPassword(article.getPassword(), password)) {
			throw new InvalidPasswordException("�߸��Ⱦ�ȣ");
		}
		return article;
	}
	
	private boolean checkPassword(String realPassword, String userInputPassword) {
		
		if(realPassword == null) {
			return false;
		}
		if(realPassword.length() == 0) {
			return false;
		}
		return realPassword.equals(userInputPassword);
		
	}

}
