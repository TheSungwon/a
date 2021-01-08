package action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;
import board.BoardDataBean;

public class ListAction implements CommandAction{ //글 목록 처리?
	
	@Override
	public String pro(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		
		String pageNum = req.getParameter("pageNum"); //페이지번호
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int pageSize = 3; //한 페이지에서 글 개수
		int currentPage = Integer.parseInt(pageNum);
		
		int startRow = (currentPage -1) * pageSize+1; //한 페이지에서 시작 글 번호
		int endRow = currentPage * pageSize; //한 페이지에서 마지막 글 번호
		
		int count = 0;
		int number = 0;
		
		List articleList = null;
		
		BoardDBBean dbPro = BoardDBBean.getInstance(); //DB연동
		
		count = dbPro.getArticleCount(); //전체 글의 수
		
		if(count >0) {
			articleList = dbPro.getArticle(startRow, endRow); //현재 페이지에 해당하는 글 목록
		}else {
			articleList = Collections.EMPTY_LIST;
		}
		
		
		number = count - (currentPage-1) * pageSize; //글 목록에 표시 할 글 번호
		
		//뷰에서 사용할 속성
		req.setAttribute("currentPage", new Integer(currentPage));
		req.setAttribute("startRow", new Integer(startRow));
		req.setAttribute("endRow", new Integer(endRow));
		req.setAttribute("count",new Integer(count));
		req.setAttribute("pageSize", new Integer(pageSize));
		req.setAttribute("number", new Integer(number));
		req.setAttribute("articleList", articleList);
		
				
		return "/mvc/list.jsp"; //뷰 //req영역에 저장하고 jsp로 포워딩
	}

}
