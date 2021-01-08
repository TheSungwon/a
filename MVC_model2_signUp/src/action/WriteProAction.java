package action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDataBean;
import board.BoardDBBean;

public class WriteProAction implements CommandAction{ //�Է� �� ó��
	
	@Override
	public String pro(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		
		req.setCharacterEncoding("euc-kr"); //�ѱ����ڵ�
		
		BoardDataBean article = new BoardDataBean(); //������ó�� ��
		
		article.setNum(Integer.parseInt(req.getParameter("num")));
		article.setWriter(req.getParameter("writer"));
		article.setEmail(req.getParameter("email"));
		article.setSubject(req.getParameter("subject"));
		article.setPasswd(req.getParameter("passwd"));
		article.setReg_date(new Timestamp(System.currentTimeMillis()));
		article.setRef(Integer.parseInt(req.getParameter("ref")));
		article.setRe_step(Integer.parseInt(req.getParameter("re_step")));
		article.setRe_level(Integer.parseInt(req.getParameter("re_level")));
		article.setContent(req.getParameter("content"));
		article.setIp(req.getRemoteAddr());		//writeFrom.jsp���� ���۵� �� �޾Ƽ� ����
		
		BoardDBBean dbPro = BoardDBBean.getInstance(); //DBó��
		dbPro.insertArticle(article);
		
		return "/mvc/writePro.jsp";
	}

}
