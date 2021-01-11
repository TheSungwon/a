package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;

public class DeleteProAction implements CommandAction{ //�� ����
	
	@Override
	public String pro(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		
		req.setCharacterEncoding("euc-kr");
		
		int num = Integer.parseInt(req.getParameter("num"));
		String pageNum = req.getParameter("pageNum");
		String passwd = req.getParameter("passwd");
		
		BoardDBBean dbPro = BoardDBBean.getInstance();
		int check = dbPro.deleteArticle(num, passwd);
		
		//�信�� ��� �� �Ӽ�
		
		req.setAttribute("pageNum", new Integer(pageNum));
		req.setAttribute("check", new Integer(check));
		
		return "/mvc/deletePro.jsp";
	}

}
