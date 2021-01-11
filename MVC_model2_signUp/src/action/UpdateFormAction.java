package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;
import board.BoardDataBean;

public class UpdateFormAction implements CommandAction{ //�� ���� ��
	
	@Override
	public String pro(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		
		int num = Integer.parseInt(req.getParameter("num"));
		String pageNum = req.getParameter("pageNum");
		
		BoardDBBean dbPro = BoardDBBean.getInstance();
		BoardDataBean article = dbPro.updateGetArticle(num);
		
		//�� ���� ��� �� �Ӽ�
		req.setAttribute("pageNum", new Integer(pageNum));
		req.setAttribute("article", article);
		
		return "/mvc/updateForm.jsp"; //��
	
			
	}

}
