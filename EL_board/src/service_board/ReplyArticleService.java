/*�� Ŭ������ �亯 �Խñ��� ���� ��ȣ�� ���ؾ� �ϱ� ������ �Խñ� ���� ��ɿ� ���� ���������
������ ����

1. �亯 ���� ����� �θ� ���� ���Ѵ�. �������� ���� ��� ���� �߻�
2. �θ� ���� �ڽ� �� �߿��� ������ȣ�� ���� ���� ��ȣ ���Ѵ�
3. 	[2]���� ���� ��ȣ���� �亯 ���� ���� ���� 1 ���ҽ�Ų ���� ���� ��ȣ�� ����Ѵ�
4.  [3]���� ���� ���� ��ȣ, �θ� �۰� ������ �׷� ��ȣ�� ����ؼ� �亯 ���� ����*/

package service_board;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;

import DAO_bean.ArticleDao;
import DTO_javaBean.Article;
import DTO_javaBean.ReplyingRequest;
import DTO_javaBean.jdbcUtil;
import Exception_board.ArticleNotFoundException;
import Exception_board.CannotReplyArticleException;
import Exception_board.LastChildAleadyExistsException;
import DTO_javaBean.ConnectionProvider;

public class ReplyArticleService {
	
	private static ReplyArticleService instance = new ReplyArticleService();
	public static ReplyArticleService getInstance() {
		return instance;
	}
	private ReplyArticleService() {}
	/////////////////////////////////////////////
	
	public Article reply(ReplyingRequest replyingRequest) throws ArticleNotFoundException, CannotReplyArticleException,
	LastChildAleadyExistsException{
		Connection conn = null;
		
		Article article = replyingRequest.toArticle(); //replyingRequest�κ��� Article��ü ����
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			ArticleDao articleDao = ArticleDao.getInstance();
			Article parent = articleDao.selectById(conn, replyingRequest.getParentArticleId()); //�θ� �� Article��ü ����
			
			try {
				checkParent(parent, replyingRequest.getParentArticleId()); //�θ���� �����ϴ��� ���ο� �亯 ���� ����Ҽ��ִ��� Ȯ��
			}catch(Exception e) {	//checkParent�� ���ܹ߻���ų��� Ʈ����� �ѹ��ϰ� ���ܹ߻�
				jdbcUtil.rollback(conn);
				if(e instanceof ArticleNotFoundException) {
					throw (ArticleNotFoundException)e;
				}else if(e instanceof CannotReplyArticleException) {
					throw (CannotReplyArticleException)e;
				}else if(e instanceof LastChildAleadyExistsException) {
					throw (LastChildAleadyExistsException)e;
				}
			}
			
			String searchMaxSeqNum = parent.getSequenceNumber();
			String searchMinSeqNum = getSearchMinSeqNum(parent);	//�ڽı��� �ִ�,�ּ� ������ȣ����
			
			String lastChildSeq = articleDao.selectLastSequenceNumber(conn, searchMaxSeqNum, searchMinSeqNum);
			//�ִ��ּ� ������ȣ ������ �������� ���� ���� �ڽ� ���� ������ȣ ���Ѵ�
			
			String sequenceNumber = getSequenceNumber(parent,lastChildSeq);
			//���� ���� �ڽ� �۹�ȣ�� �̿��ؼ� �� �ڽ� ���� ������ȣ�� ���Ѵ�
			
			article.setGroupId(parent.getGroupId());
			article.setSequenceNumber(sequenceNumber); //�亯 ���� �׷��ȣ�� ������ȣ ����
			article.setPostingDate(new Date());
			
			int articleId = articleDao.insert(conn, article); //�亯 ���� ���̺� ����
			if(articleId == -1) {
				throw new RuntimeException("DB����"+articleId);
			}
			conn.commit();
			article.setId(articleId);
			return article;
		}catch(SQLException e	) {
			jdbcUtil.rollback(conn);
			throw new RuntimeException("DB����"+e.getMessage(),e);
		}finally{
			if(conn != null) {
				try {
					conn.setAutoCommit(true);
				}catch(SQLException e) {
					
				}
			}
			jdbcUtil.close(conn);
		}
	}
	
	private void checkParent(Article parent,int parentId)throws ArticleNotFoundException, CannotReplyArticleException{
		if(parent == null) {
			throw new ArticleNotFoundException("�θ�� ����"+parentId);
		}
		
		int parentLevel = parent.getLevel();
		if(parentLevel == 3) {
			throw new CannotReplyArticleException("����������"+parent.getId());
		}
	}
	
	private String getSearchMinSeqNum(Article parent) {
		String parentSeqNum = parent.getSequenceNumber();
		DecimalFormat decimalFormat = new DecimalFormat("0000000000000000");
		
		long parentSeqLongValue = Long.parseLong(parentSeqNum);
		long searchMinLongValue = 0;
		
		switch(parent.getLevel()) {
		case 0:
			searchMinLongValue = parentSeqLongValue / 1000000L * 1000000L;
			break;
			
		case 1:
			searchMinLongValue = parentSeqLongValue / 10000L * 10000L;
			break;
			
		case 2:
			searchMinLongValue = parentSeqLongValue / 100L * 100L;
			break;

		}
		return decimalFormat.format(searchMinLongValue);
	}
	
	
	private String getSequenceNumber(Article parent, String lastChildSeq)throws LastChildAleadyExistsException{
		
		long parentSeqLong = Long.parseLong(parent.getSequenceNumber());
		int parentLevel = parent.getLevel();
		
		long decUnit = 0;
		
		if(parentLevel == 0) {
			decUnit = 10000L;
		}else if(parentLevel == 1) {
			decUnit = 100L;
		}else if(parentLevel == 2) {
			decUnit = 1L;
		}
		
		String sequenceNumber = null;
		
		DecimalFormat decimalFormat = new DecimalFormat("0000000000000000");
		
		if(lastChildSeq == null) { //�亯�۾���
			sequenceNumber = decimalFormat.format(parentSeqLong - decUnit);
		}else {//�亯������
			//������ �亯������ Ȯ��
			String orderOfLastChildSeq = null;
			if(parentLevel == 0) {
				orderOfLastChildSeq = lastChildSeq.substring(10,12);
				sequenceNumber = lastChildSeq.substring(0,12)+"9999";
			}else if(parentLevel ==1) {
				orderOfLastChildSeq = lastChildSeq.substring(12,14);
				sequenceNumber = lastChildSeq.substring(0,14)+"99";
			}else if(parentLevel == 2) {
				orderOfLastChildSeq = lastChildSeq.substring(14,16);
				sequenceNumber = lastChildSeq;
			}
			if(orderOfLastChildSeq.equals("00")) {
				throw new LastChildAleadyExistsException("������ �ڽı� ����"+lastChildSeq);
			}
			long seq = Long.parseLong(sequenceNumber) - decUnit;
			sequenceNumber = decimalFormat.format(seq);
		}
		return sequenceNumber;
	}

}
