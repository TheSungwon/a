/*게시글 수정 삭제 기능은 게시글 등록할 때 입력한 암호와 동일한 암호를 입력해야
수정 및 삭제가 가능하도록 구현// 수정 기능과 삭제 기능에서 암호를 확인하는 기능을
필요로하기 때문에 암호 확인 기능을 별도 클래스로 분류해서 코드가 중복되지 않도록 했다.

check~password메서드는 게시글이 존재하는지의 여부와 사용자가 입력한 암호가 실제 게시글의 암호와
동일한지의 여부를 확인// 게시글이 존재하고 암호도 일치하면 해당 Article객체를 리턴한다.
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
			throw new ArticleNotFoundException("게시글없음"+articleId);
		}
		if(!checkPassword(article.getPassword(), password)) {
			throw new InvalidPasswordException("잘못된암호");
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
