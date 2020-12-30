//AddRequest��ü�� ���� �޾� ���ε� �� ���� ������ DB�� ����
//���ε� �� ���Ϥ��� ���� ó������ �ʰ� DB�� ���� ������ �߰��� �ִ� ��ɸ� ����
package pds_Service;

import java.sql.Connection;
import java.sql.SQLException;

import pds_DAO.PdsItemDao;
import pds_DTO.AddRequest;
import pds_DTO.PdsItem;
import JDBC_PROVIDER.jdbcUtil;
import JDBC_PROVIDER.ConnectionProvider;

public class AddPdsItemService {
	private static AddPdsItemService instance = new AddPdsItemService();
	public static AddPdsItemService getInstance() {
		return instance;
	}
	private AddPdsItemService() {
		
	}
//////////////////////////////////////////////////////////////////
	
	public PdsItem add(AddRequest request) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			PdsItem pdsItem = request.toPdsItem();
			int id = PdsItemDao.getInstance().insert(conn, pdsItem);
			if(id == -1) {
				jdbcUtil.rollback(conn);
				throw new RuntimeException("db���Ծȴ�");
			}
			pdsItem.setId(id);
			conn.commit();
			return pdsItem;
			
		}catch(SQLException e) {
			jdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			if(conn != null) {
				try {
					conn.setAutoCommit(true);
				}catch(SQLException e) {
					
				}
			}
			jdbcUtil.close(conn);
		}
	}
	
}
