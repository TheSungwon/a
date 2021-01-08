package action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;
import board.BoardDataBean;

public class ListAction implements CommandAction{ //�� ��� ó��?
	
	@Override
	public String pro(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		
		String pageNum = req.getParameter("pageNum"); //��������ȣ
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int pageSize = 3; //�� ���������� �� ����
		int currentPage = Integer.parseInt(pageNum);
		
		int startRow = (currentPage -1) * pageSize+1; //�� ���������� ���� �� ��ȣ
		int endRow = currentPage * pageSize; //�� ���������� ������ �� ��ȣ
		
		int count = 0;
		int number = 0;
		
		List articleList = null;
		
		BoardDBBean dbPro = BoardDBBean.getInstance(); //DB����
		
		count = dbPro.getArticleCount(); //��ü ���� ��
		
		if(count >0) {
			articleList = dbPro.getArticle(startRow, endRow); //���� �������� �ش��ϴ� �� ���
		}else {
			articleList = Collections.EMPTY_LIST;
		}
		
		
		number = count - (currentPage-1) * pageSize; //�� ��Ͽ� ǥ�� �� �� ��ȣ
		
		//�信�� ����� �Ӽ�
		req.setAttribute("currentPage", new Integer(currentPage));
		req.setAttribute("startRow", new Integer(startRow));
		req.setAttribute("endRow", new Integer(endRow));
		req.setAttribute("count",new Integer(count));
		req.setAttribute("pageSize", new Integer(pageSize));
		req.setAttribute("number", new Integer(number));
		req.setAttribute("articleList", articleList);
		
				
		return "/mvc/list.jsp"; //�� //req������ �����ϰ� jsp�� ������
	}

}
