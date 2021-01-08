package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;
import board.BoardDataBean;

public class ContentAction implements CommandAction	 { //�� ���� ó��
	
	@Override
	public String pro(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		
		int num = Integer.parseInt(req.getParameter("num")); //�ش� �� ��ȣ
		String pageNum = req.getParameter("pageNum");		//�ش� ������ ��ȣ
		
		BoardDBBean dbPro = BoardDBBean.getInstance(); //DBó��
		BoardDataBean article = dbPro.getArticle(num); //�ش� �۹�ȣ�� ���� �ش� ���ڵ�?
		
		//�信�� ��� �� �Ӽ�
		req.setAttribute("num", new Integer(num));
		req.setAttribute("pageNum", new Integer(pageNum));
		req.setAttribute("article", article);
		
		return "/mvc/content.jsp";
	}

}
