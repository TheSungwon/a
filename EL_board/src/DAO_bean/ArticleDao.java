//ListArticleServiceŬ������ ��û�� �������� �ش��ϴ� �Խñ۸���� �о���� ���ؼ� ArticleDaoŬ�������
//selectCount(Connection conn) �Խñ���ü���� ���ϱ�
//List<Article> select(Connection coon, int first~~end) ��ü �Խñ� �߿��� ������ ������ �� �о����
/////////////////////////
//Aricle��ü�� article���̺� �������ִ� insert������ �����Ѵ�.
package DAO_bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import DTO_javaBean.Article;
import DTO_javaBean.jdbcUtil;

public class ArticleDao {
	private static ArticleDao instance = new ArticleDao();
	public static ArticleDao getInstance() {
		return instance;
	}
	private ArticleDao() {
		
	}
////////////////
	
	public int selectCount(Connection conn) throws SQLException{
		Statement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.createStatement();
			rs = ps.executeQuery("select count(*) from article");
			rs.next();
			return rs.getInt(1);
			
		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(ps);
		}
	}
	
	////////////////
	
	public List<Article> select(Connection conn, int firstRow, int endRow)throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select article_id, group_id, sequence_no, posting_date, read_count, writer_name, password, title from( "
					+" select rownum rnum, article_id, group_id, sequence_no, posting_date, read_count, writer_name, password, title from( "
					+" select * from article m order by m.sequence_no desc "
					+" ) where rownum <= ? "
					+" ) where rnum>=? ");
			ps.setInt(1, endRow);
			ps.setInt(2, firstRow);
			
			if(!rs.next()) {
				return Collections.emptyList();
			}
			
			List<Article> articleList = new ArrayList<Article>();
			//�����Ͱ� ������ ��� �����ͷκ��� Article��ü�� ������ articleList�� �����ϰ�
			//articleList��ü�� �����Ѵ�.
			do{
				Article article = makeArticleFromResultSet(rs,false);
				articleList.add(article);
			}while(rs.next());
			return articleList;
		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(ps);
		}
	}
	
	/////////////////////////
	
	private Article makeArticleFromResultSet(ResultSet rs, boolean readContent)throws SQLException{
		//ResultSet���κ��� �����͸� �о�� Article��ü�� �������ش�. �� �ڵ带 �и��� ������
		//�ڿ� �ۼ��ϴ� selectById()�޼��忡���� ResultSet���� �����͸� �о�� Article��ü�� ����
		
		//readContent���� ���� article���̺�κ��� contentĮ���� ���� �о���� ���� ����
		//�Խñ� ����� �о�� �� ���Ǵ� ArticleDao.select()�޼���� �Խñ��� �ʿ����� �����Ƿ�
		//readContent�Ķ���Ͱ����� false����
		Article article = new Article();
		article.setId(rs.getInt("article_id"));
		article.setGroupId(rs.getInt("group_id"));
		article.setSequenceNumber(rs.getString("sequence_no"));
		article.setPostingDate(rs.getTimestamp("posting_date"));
		article.setReadCount(rs.getInt("read_count"));
		article.setWriterName(rs.getString("writer_name"));
		article.setPassword(rs.getString("password"));
		article.setTitle(rs.getString("title"));
		
		if(readContent) {
			article.setContent(rs.getString("content"));
			
		}
		return article;
	}
	
	////////////////
	/* WriteArticleServiceŬ������ Article��ü�� DB�� �����ϱ����� 
	 * ArticleDaoŬ������ insert()�޼��带 ����ϴµ�
	 * public int insert(Connection conn, Article article)throws SQLException //���� ����
	 * 
	 * insert()�޼���� �Ķ���ͷ� ���޹��� Article��ü�κ��� ���� �о�� insert������ �̿��ؼ�
	 * article���̺� �����͸� ����. �����ͻ��Կ� �����ϸ� �űԷ� ���Ե� �������� Ű ���� �����Ѵ� 
	 *  */
	public int insert(Connection conn, Article article)throws SQLException{
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("insert into article "
					+" (article_id, group_id, sequence_no, posting_date, read_count, "
					+" writer_name, password, title, content) "
					+" values(article_id_seq.NEXTVAL,?,?,?,0,?,?,?,?)");
			
			ps.setInt(1, article.getGroupId());
			ps.setString(2, article.getSequenceNumber());
			ps.setTimestamp(3, new Timestamp(article.getPostingDate().getTime()));
			ps.setString(4, article.getWriterName());
			ps.setString(5, article.getPassword());
			ps.setString(6, article.getTitle());
			ps.setString(7, article.getContent());
			
			int insertedCount = ps.executeUpdate(); //insert�����������ѵ� ��������� ����
			
			if(insertedCount > 0) {
				st = conn.createStatement();
				rs = st.executeQuery("select article_id_seq.CURRVAL from dual");
				if(rs.next()) {
					return rs.getInt(1);//���Ե����� �����ϸ� article_id �� ����
				}
			}
			return -1; //�������������� -1�� ����
			
		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(ps);
			jdbcUtil.close(st);
			
		}
	}
	
}
