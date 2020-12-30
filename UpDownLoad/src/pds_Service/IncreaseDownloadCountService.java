//다운로드횟수를 증가시켜준다
package pds_Service;

import java.sql.Connection;
import java.sql.SQLException;

import pds_DAO.PdsItemDao;
import JDBC_PROVIDER.jdbcUtil;
import JDBC_PROVIDER.ConnectionProvider;

public class IncreaseDownloadCountService {
	private static IncreaseDownloadCountService instance = new IncreaseDownloadCountService();
	public static IncreaseDownloadCountService getInstance() {
		return instance;
	}
	private IncreaseDownloadCountService() {
		
	}
/////////////////////////////////////
	
	public boolean increaseCount(int id) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			int updatedCount = PdsItemDao.getInstance().increaseCount(conn, id);//0이상 리턴한다면 true
			return updatedCount == 0 ? false : true;
			
		}catch(SQLException e) {
			throw new RuntimeException("db처리에러"+e.getMessage(),e);
		}finally {
			jdbcUtil.close(conn);
		}
	}
}
