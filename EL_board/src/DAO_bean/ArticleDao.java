//ListArticleService클래스는 요청한 페이지에 해당하는 게시글목록을 읽어오기 위해서 ArticleDao클래스사용
//selectCount(Connection conn) 게시글전체개수 구하기
//List<Article> select(Connection coon, int first~~end) 전체 게시글 중에서 시작행 끝행의 글 읽어오기
/////////////////////////
//Aricle객체를 article테이블에 삽입해주는 insert쿼리를 실행한다.
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
			rs=ps.executeQuery();
			if(!rs.next()) {
				return Collections.emptyList();
			}
			
			List<Article> articleList = new ArrayList<Article>();
			//데이터가 존재할 경우 데이터로부터 Article객체를 가져와 articleList에 저장하고
			//articleList객체를 리턴한다.
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
		//ResultSet으로부터 데이터를 읽어와 Article객체를 생성해준다. 이 코드를 분리한 이유는
		//뒤에 작성하는 selectById()메서드에서도 ResultSet에서 데이터를 읽어와 Article객체를 생성
		
		//readContent값에 따라서 article테이블로부터 content칼럼의 값을 읽어올지 여부 결정
		//게시글 목록을 읽어올 때 사용되는 ArticleDao.select()메서드는 게시글이 필요하지 않으므로
		//readContent파라미터값으로 false전달
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
	/* WriteArticleService클래스는 Article객체를 DB에 저장하기위해 
	 * ArticleDao클래스의 insert()메서드를 사용하는데
	 * public int insert(Connection conn, Article article)throws SQLException //으로 정의
	 * 
	 * insert()메서드는 파라미터로 전달받은 Article객체로부터 값을 읽어와 insert쿼리를 이용해서
	 * article테이블에 데이터를 삽입. 데이터삽입에 성공하면 신규로 삽입된 데이터의 키 값을 리턴한다 
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
			
			int insertedCount = ps.executeUpdate(); //insert쿼리를실행한뒤 결과개수를 저장
			
			if(insertedCount > 0) {
				st = conn.createStatement();
				rs = st.executeQuery("select article_id_seq.CURRVAL from dual");
				if(rs.next()) {
					return rs.getInt(1);//삽입된행이 존재하면 article_id 를 리턴
				}
			}
			return -1; //존재하지않으면 -1을 리턴
			
		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(ps);
			jdbcUtil.close(st);
			
		}
	}
	
	///////////////////////////
	/*
	 *  해당 ID에 해당하는 게시글 DB테이블에서 읽어오고, 조회수를 증가시켜주는 기능 
	 *  
	 *  selectById 지정한 ID에 해당하는 데이터를 테이블에서 읽어와 Article객체를 생성한뒤 리턴
	 *  존재하지 않으면 null리턴
	 *  
	 *  increaseReadCount 지정한 ID에 해다하는 데이터의 read_count칼럼 값을 1 증가시킨다*/
	
	public Article selectById(Connection conn, int articleId)throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("select * from article where article_id = ?");
			ps.setInt(1, articleId);
			rs=ps.executeQuery();
			if(!rs.next()) {
				return null;
			}
			
			Article article = makeArticleFromResultSet(rs, true);
			return article;	//데이터가 존재할 경우 ResultSet으로부터 Article객체를 생성한 뒤 리턴
			
		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(ps);
		}
		
	}
	
	
	public void increaseReadCount (Connection conn, int articleId)throws SQLException{
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("update article set read_count = read_count + 1 where article_id = ?");
			ps.setInt(1, articleId);
			ps.executeUpdate();
			
		}finally {
			jdbcUtil.close(ps);
		}
	}
	
	////////////////////////////////////////////////////
	/*
	 * selectLastSequenceNumber() 메서드는 지정한 두 값 사이에 있는 sequence_no칼럼의 값 중 최소값을 구해주는
	 * 기능을 제공
	 * 
	 * ReplyArticleService클래스는 ArticleDao.selectLastSequenceNumber()메서드를 이용해서
	 * 답변을 등록할 부모 게시글에 등록된 마지막 자식 게시글의 순서번호를 구한다.
	 */
	
	public String selectLastSequenceNumber(Connection conn, String searchMaxSeqNum,String searchMinSeqNum)
	throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("select min(sequence_no) from article where sequence_no <? and sequence_no >=?");
			
			ps.setString(1, searchMaxSeqNum);
			ps.setString(2, searchMinSeqNum);
			rs=ps.executeQuery();
			
			if(!rs.next()) {
				return null;
			}
			return rs.getString(1);
			
		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(ps);
		}
	}
	
	///////////////////////////////////////////
	/*
	 * update 수정 ArticleDao - DB데이터수정
	 */
	public int update(Connection conn, Article article)throws SQLException{
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update article set title =?, content=? where article_id=?");
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getContent());
			ps.setInt(3, article.getId());
			
			return ps.executeUpdate();
		}finally{
			jdbcUtil.close(ps);
		}
	}
	
	///////////////////////////////
	//DB에서 데이터를 삭제 delete메서드
	public void delete(Connection conn, int articleId)throws SQLException{
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("delete from article where article_id =?");
			ps.setInt(1, articleId);
			ps.executeUpdate();
			
		}finally{
			jdbcUtil.close(ps);
		}
	}
	
}
