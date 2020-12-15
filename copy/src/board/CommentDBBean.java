package board;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Timestamp;
	import java.util.ArrayList;
	
	import board.jdbcUtil;
	import board.CommentDataBean;
	
	public class CommentDBBean {
		private static CommentDBBean instance = new CommentDBBean();
		public static CommentDBBean getInstance() {
			return instance;
		}
		private CommentDBBean() {
			
		}// singleton pattern
		
		private Connection getConnection() throws Exception{
			String jdbc = "jdbc:apache:commons:dbcp:/connectionPool";
			return DriverManager.getConnection(jdbc);
		}
		
		public void insertComment(CommentDataBean cdb) throws Exception{
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = getConnection();
				
				String sql="insert into b_comment values(?,?,?,?,?,?,?)";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, cdb.getContent_num());
				ps.setString(2, cdb.getCommenter());
				ps.setString(3, cdb.getCommentt());
				ps.setString(4, cdb.getPasswd());
				ps.setTimestamp(5, cdb.getReg_date());
				ps.setString(6, cdb.getIp());
				ps.setInt(7, cdb.getComment_num());
				ps.executeUpdate();
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				jdbcUtil.close(conn);
				jdbcUtil.close(ps);
			}
		}
		
		
		
		
		
		public ArrayList getComments(int con_num, int start,int end)throws Exception{
			
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList cm =null;
			
			
		try { conn = getConnection();
		
		String sql="select content_num,commenter,commentt,reg_date,ip,comment_num,r "
				+ "from (select content_num,commenter,commentt,reg_date,ip,comment_num, rownum r "
				+ "from (select content_num,commenter,commentt,reg_date,ip,comment_num "
				+ "from b_comment where content_num="+con_num+" order by reg_date desc) order by reg_date desc) where r >= ? and r <= ?";			
		ps=conn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		
		rs=ps.executeQuery();
		
		if(rs.next()){
			cm=new ArrayList();
			do{
				CommentDataBean cdb=new CommentDataBean();
				cdb.setComment_num(rs.getInt("comment_num"));
				cdb.setContent_num(rs.getInt("content_num"));
				cdb.setCommenter(rs.getString("commenter"));
				cdb.setCommentt(rs.getString("commentt"));
				cdb.setIp(rs.getString("ip"));
				cdb.setReg_date(rs.getTimestamp("reg_date"));
				cm.add(cdb);
			}while(rs.next());
		}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				jdbcUtil.close(conn);
				jdbcUtil.close(ps);
				jdbcUtil.close(rs);
			}
		return cm;
		}
	
		
		
		
		
		
	public int getCommentCount(int con_num) throws Exception{ //오라클count함수 안썼을경우
		
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList cm = null;
		int count = 0;
		
	try {	conn = getConnection();
	 
	String sql="select * from b_comment where content_num="+con_num+" order by reg_date desc";
	ps=conn.prepareStatement(sql);
	rs=ps.executeQuery();
	
	if(rs.next()){
		cm=new ArrayList();
		do{
			CommentDataBean cdb=new CommentDataBean();
			cdb.setCommenter(rs.getString("commenter"));
			cdb.setCommentt(rs.getString("commentt"));
			cdb.setIp(rs.getString("ip"));
			cdb.setReg_date(rs.getTimestamp("reg_date"));
			cm.add(cdb);
		}while(rs.next());
		count=cm.size();
	}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtil.close(conn);
			jdbcUtil.close(ps);
			jdbcUtil.close(rs);
		}
	return count;
	}
	
	
	
	
	
	
	
	public int deleteComment(int content_num,String passwd, int comment_num) throws Exception{
		
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String dbpasswd = "";
		int x = -1;
		
	try {	conn = getConnection();
			
	ps=conn.prepareStatement("select passwd from b_comment where content_num=? and comment_num=?");
	ps.setInt(1, content_num);
	ps.setInt(2, comment_num);
	rs=ps.executeQuery();
	
	if(rs.next()){
		dbpasswd=rs.getString("passwd");
		if(dbpasswd.equals(passwd)){
			ps=conn.prepareStatement("delete from b_comment where content_num=? and comment_num=?");
			ps.setInt(1, content_num);
			ps.setInt(2, comment_num);
			ps.executeUpdate();
			x=1;
		}else
			x=0;
	}
	
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtil.close(conn);
			jdbcUtil.close(ps);
			jdbcUtil.close(rs);
		}
	return x;
	}
}