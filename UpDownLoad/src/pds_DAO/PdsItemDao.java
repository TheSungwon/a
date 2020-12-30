

package pds_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import JDBC_PROVIDER.ConnectionProvider;
import JDBC_PROVIDER.jdbcUtil;
import pds_DTO.PdsItem;

public class PdsItemDao {
	private static PdsItemDao instance = new PdsItemDao();
	public static PdsItemDao getInstance() {
		return instance;
	}
	private PdsItemDao() {}
	///////////////////////////
	
	
	public int selectCount(Connection conn) throws SQLException{
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select count(*) from pds_item"); //�Էµ� ���� ��
			rs.next();
			return rs.getInt(1);
			
		}finally{
			jdbcUtil.close(st);
			jdbcUtil.close(rs);
		}
	}
	
	
	
	public List<PdsItem> select(Connection conn, int firstRow, int endRow)throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("select * from (select rownum rnum, pds_item_id, filename, realpath, filesize, downloadcount, description from ( "
					+" select * from pds_item m order by m.pds_item_id desc ) where rownum <=? ) where rnum >=?" );
			
			ps.setInt(1, endRow);
			ps.setInt(2, firstRow);
			rs = ps.executeQuery();
			
			if(!rs.next()) {
				return Collections.emptyList();
			}
			
			List<PdsItem> itemList = new ArrayList<PdsItem>(); //�����Ͱ� ������ ��ü �����ؼ�
			do {
				PdsItem article = makeItemFromResultSet(rs); //rs�ڹٺ� �ֱ�
				itemList.add(article);
			}while(rs.next());
			return itemList;
			
		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(ps);
		}
	}
	
	
	private PdsItem makeItemFromResultSet(ResultSet rs)throws SQLException{
		PdsItem item = new PdsItem();
		item.setId(rs.getInt("pds_item_id"));
		item.setFileName(rs.getString("filename"));
		item.setRealPath(rs.getString("realpath"));
		item.setFileSize(rs.getLong("filesize"));
		item.setDownloadCount(rs.getInt("downloadcount"));
		item.setDescription(rs.getString("description"));
		return item;
	}
//////////////////////////////////////////////////////////Lsit���� ��
	
//÷�� ���� ������ ���� PdsItem��ü�� ��ȸ���ִ� �޼���
	public PdsItem selectById(Connection conn,int itemId)throws SQLException{
		//�� ��ȣ�� �ش��ϴ� �� �� ������ ��������
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("select * from pds_item where pds_item_id =?");
			ps.setInt(1, itemId);
			rs = ps.executeQuery();
			if(!rs.next()) {
				return null;
			}
			PdsItem item = makeItemFromResultSet(rs);
			return item;
			
		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(ps);
		}
	}
	
	//���ε� ���� db�� �����͸� �������ִ� �޼���
	public int insert(Connection conn, PdsItem item)throws SQLException{
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("insert into pds_item (pds_item_id, filename, realpath, filesize, downloadcount, description) "
					+ " values (pds_item_id_seq.NEXTVAL,?,?,?,0,?)"); //0�� �������� �������鶧 0���� ��⶧��
			ps.setString(1, item.getFileName());
			ps.setString(2, item.getRealPath());
			ps.setLong(3, item.getFileSize());
			ps.setString(4, item.getDescription());
			int insertCount = ps.executeUpdate(); //�� �� �Է��̹Ƿ� 1����
			
			if(insertCount >0) {
				st = conn.createStatement();
				rs = st.executeQuery("select pds_item_id_seq.CURRVAL from dual"); //�������̺� dual//currval��  ������ ������
				if(rs.next()){
					return rs.getInt(1);
				}
			}
			return -1;
			
		}finally {
			jdbcUtil.close(ps);
			jdbcUtil.close(rs);
			jdbcUtil.close(st);
		}
	}
	
	///////////////////////////////////////////
	
	public int increaseCount(Connection conn, int id)throws SQLException{ //�ٿ�ε�Ƚ��
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update pds_item set downloadcount = downloadcount + 1 where pds_item_id =?"	);
			ps.setInt(1, id);
			return ps.executeUpdate();
		}finally{
			jdbcUtil.close(ps);
		}
	}
	
	
	///////////////////////////////////////////////
	//�Խñ� ��ϰ��� ����
	public int selectCount(String SearchKeyword) throws SQLException{
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		try {
			ps = ConnectionProvider.getConnection().prepareStatement("select count(*) from pds_item where filename like '%'||?||'%'");
			ps.setString(1, SearchKeyword);
			rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
			
		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(ps);
		}
		
	}
	
	
	public List<PdsItem> select(int firstRow, int endRow, String searchKeyword) throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConnectionProvider.getConnection().prepareStatement("select * from (select rownum rnum, pds_item_id, filename, realpath, filesize, downloadcount, description "
					+ " from(select * from pds_item m where filename like '%'||?||'%' order by m.pds_item_id desc) where rownum <=?) "
					+ " where rnum >=? ");
			ps.setString(1, searchKeyword);
			ps.setInt(2, endRow);
			ps.setInt(3, firstRow);
			rs = ps.executeQuery();
			
			if(!rs.next()) {
				return Collections.emptyList();
			}
			List<PdsItem> itemList = new ArrayList<PdsItem>();
			do {
				PdsItem article = makeItemFromResultSet(rs);
				itemList.add(article);
			}while(rs.next());
			return itemList;
			
		}finally {
			jdbcUtil.close(ps);
			jdbcUtil.close(rs);
		}
	}
	
	/////////////////////////////////
	/*
	 * public List<PdsItem> PdsSearch(Connection conn, int firstRow, int endRow,
	 * String searchK) throws SQLException{ PreparedStatement ps = null; ResultSet
	 * rs = null; List<PdsItem> list = null;
	 * 
	 * String[] colName = {"pds_item_id","filename"}; try { ps =
	 * conn.prepareStatement(sql) }
	 * 
	 * }
	 */
}
