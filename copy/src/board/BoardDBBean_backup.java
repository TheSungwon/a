package board;

import java.sql.*;
import java.util.*;

public class BoardDBBean_backup {
	//singleton pattern
	// BoardDBBean a = BoardDBBean.getInstance();...
	
	private static BoardDBBean_backup instance = new BoardDBBean_backup(); //private���� �����ʵ�
	
	public static BoardDBBean_backup getInstance() { //���� �޼ҵ� . ���ν��Ͻ��������� �ν��Ͻ�����
		return instance;
	}
	
	private BoardDBBean_backup() {
		//������
	}
	
	private Connection getConnection() throws Exception{
		String jdbc = "jdbc:apache:commons:dbcp:/connectionPool";
		return DriverManager.getConnection(jdbc);
	}
	
	//writePro �Խ����Է�
	public void insertArticle(BoardDataBean article) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//�亯 or �Ϲݱ� �����ؼ� �Է����ִ� ����
		int num = article.getNum();
		int ref = article.getRe_level();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();
		int number = 0;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement("select max(num) from board");
			rs = ps.executeQuery();
				if(rs.next()) //ref����?
					number = rs.getInt(1)+1;
				else
					number = 1;
				if(num != 0) {//�亯���̶��
					ps = conn.prepareStatement("update board set re_step = re_step+1 where ref=? and re_step > ?");
					ps.setInt(1, ref);
					ps.setInt(2, re_step);
					ps.executeUpdate();
					
					re_step = re_step+1;
					re_level = re_level+1;
				}else { //ó�� ���� ��?
					ref = number;
					re_step = 0;
					re_level = 0;
					
				}
			
			//readcount �÷����� num�� ������ �ֱ�
				ps = conn.prepareStatement("insert into board(num,writer,email,subject,passwd,reg_date,ref,re_step,re_level,content,ip) values(board_num.NEXTVAL,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1, article.getWriter());
				ps.setString(2, article.getEmail());
				ps.setString(3, article.getSubject());
				ps.setString(4, article.getPasswd());
				ps.setTimestamp(5, article.getReg_date());
				ps.setInt(6, ref);
				ps.setInt(7, re_step);
				ps.setInt(8, re_level);
				ps.setString(9, article.getContent());
				ps.setString(10, article.getIp());
				
				ps.executeUpdate();
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(ps != null) try {ps.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}
	
	//����¡. �� ���ؼ� ��ü ���̺� �Էµ� ���� ���� �ʿ�..? list jsp
	
	public int getArticleCount() throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int x = 0;
	try {
		conn = getConnection();
		ps = conn.prepareStatement("select count(*) from board"); //����
		rs = ps.executeQuery();
		
		if(rs.next()) {
			x = rs.getInt(1);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		if(rs != null) try {rs.close();} catch(SQLException e) {}
		if(ps != null) try {ps.close();} catch(SQLException e) {}
		if(conn != null) try {conn.close();} catch(SQLException e) {}
}
	return x;
}
	
	////////********** list jsp.....paging db�κ��� �������� ����� ����
	public List<BoardDataBean> getArticle(int start, int end) throws Exception{ //start ~ end ���� �޾ƿ��� . list<>�� ��Ƽ� ����
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardDataBean> articleList = null;
		
		try {
			conn = getConnection();
			//�ζ��κ�, ��ȣ�Ⱥ����б�. r���� r����
			ps = conn.prepareStatement(
					"select num, writer, email, subject, passwd, reg_date, ref, re_step, re_level, content, ip, readcount, r from (select num, writer, email, subject, passwd, reg_date, ref, re_step, re_level, content, ip, readcount, rownum r from (select num, writer, email, subject, passwd, reg_date, ref, re_step, re_level, content, ip, readcount from board order by ref desc, re_step asc) order by ref desc, re_step asc) where r >=? and r <= ?");
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList<BoardDataBean>(end);
				do {
					BoardDataBean article = new BoardDataBean();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPasswd(rs.getString("passwd"));
					article.setReg_date(rs.getTimestamp("reg_date"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setRe_step(rs.getInt("re_step"));
					article.setRe_level(rs.getInt("re_level"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip")); //�ڹٺ� �ֱ�
					
					articleList.add(article);
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(ps != null) try {ps.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return articleList;
	}
/////////*********** content jsp  db�κ��� �� ���� ������ �����´�
	public BoardDataBean getArticle(int num) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardDataBean article = null;
		
	
		try {
			conn = getConnection();
			
			ps = conn.prepareStatement("update board set readcount=readcount+1 where num = ?"); //��ȸ������?
			ps.setInt(1, num);
			ps.executeUpdate();
			
			ps = conn.prepareStatement("select * from board where num = ?");
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				article = new BoardDataBean();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPasswd(rs.getString("passwd"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip")); 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(ps != null) try {ps.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return article;
	}
	///////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////������ updateForm jsp
	public BoardDataBean updateGetArticle(int num) throws Exception{ //���� ���� ���� ��ȸ�������� ����
	
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardDataBean article = null;
		
		try { conn = getConnection();
		
		ps = conn.prepareStatement("select * from board where num = ?");
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				article = new BoardDataBean();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPasswd(rs.getString("passwd"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip")); 
			}
		}catch(Exception e){
		e.printStackTrace();
		
			
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(ps != null) try {ps.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return article;
	}
	/////////////////////////////updatePro jsp ���� ������ �����ϴ¤� �ļҵ�
	public int updateArticle(BoardDataBean article) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String dbpasswd = "";
		String a = "";
		int x = -1;
		try { conn = getConnection();
		
		ps = conn.prepareStatement("select passwd from board where num = ?");
		ps.setInt(1, article.getNum());
		
		rs = ps.executeQuery();
		
		if(rs.next()) {
			dbpasswd = rs.getString("passwd");
			if(dbpasswd.equals(article.getPasswd())) {
				a = "update board set writer=?,email=?,subject=?,passwd=?,content=? where num =?";
				ps = conn.prepareStatement(a);
				
				ps.setString(1, article.getWriter());
				ps.setString(2, article.getEmail());
				ps.setString(3, article.getSubject());
				ps.setString(4, article.getPasswd());
				ps.setString(5, article.getContent());
				ps.setInt(6, article.getNum());
				ps.executeUpdate();
				x = 1;
			}else {
				x = 0;
			}
		}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(ps != null) try {ps.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return x;
		
	}
	////////////////////////////deletePro jsp ���� �����ͻ��� �޼ҵ�
	public int deleteArticle(int num, String passwd) throws Exception{
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int x = -1;
		String dbpasswd = "";
		
		try { conn = getConnection();
		ps = conn.prepareStatement("select passwd from board where num = ?");
		ps.setInt(1, num);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			dbpasswd = rs.getString("passwd");
			/////////////////////////////////////////�߰�
			if(dbpasswd.equals(passwd)) {
				ps= conn.prepareStatement("select * from board where ref = (select ref from board where num = "+num+") and re_step = (select re_step from board where num = "+num+")+1 and re_level = (select re_level from board where num= "+num+")+1");				
				rs = ps.executeQuery();
				
				if(rs.next()) {
					ps=conn.prepareStatement("update board set emila='����', writer='delete', subject='delete',content='delete' where num =?");
					ps.setInt(1, num);
					ps.executeUpdate();
					x=1;
				}else {
					ps = conn.prepareStatement("delete from board where num = ?");
					ps.setInt(1, num);
					ps.executeUpdate();
					x=1;
				}
			}else { x=0;
			
			/////////////////////////////////////////�����ȱ��Դϴ�
			/*
			 * if(dbpasswd.equals(passwd)) { ps =
			 * conn.prepareStatement("delete from board where num = ?"); ps.setInt(1, num);
			 * ps.executeUpdate();
			 * 
			 * x =1; //�ۻ� ���� }else { x = 0; //���Ʋ�� }
			 */
		//}
			}}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(ps != null) try {ps.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return x;
	}
}
		