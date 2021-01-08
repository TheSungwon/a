package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;
import board.BoardDataBean;

public class ContentAction implements CommandAction	 { //글 내용 처리
	
	@Override
	public String pro(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		
		int num = Integer.parseInt(req.getParameter("num")); //해당 글 번호
		String pageNum = req.getParameter("pageNum");		//해당 페이지 번호
		
		BoardDBBean dbPro = BoardDBBean.getInstance(); //DB처리
		BoardDataBean article = dbPro.getArticle(num); //해당 글번호에 대한 해당 레코드?
		
		//뷰에서 사용 할 속성
		req.setAttribute("num", new Integer(num));
		req.setAttribute("pageNum", new Integer(pageNum));
		req.setAttribute("article", article);
		
		return "/mvc/content.jsp";
	}

}
