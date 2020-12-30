//지정한 ID에 해다하는 PdsItem객체를 구한다
package pds_Service;

import java.sql.Connection;
import java.sql.SQLException;

import pds_DAO.PdsItemDao;
import pds_DTO.PdsItem;
import pds_Exception.PdsItemNotFoundException;
import JDBC_PROVIDER.jdbcUtil;
import JDBC_PROVIDER.ConnectionProvider;

public class GetPdsItemService {
	private static GetPdsItemService instance = new GetPdsItemService();
	public static GetPdsItemService getInstance() {
		return instance;
	}
	private GetPdsItemService() {
		
	}
	////////////////////////////////////////////////
	
	public PdsItem getPdsItem(int id)throws PdsItemNotFoundException{
		
		Connection conn = null;
		try {
			
			conn = ConnectionProvider.getConnection();
			PdsItem pdsItem = PdsItemDao.getInstance().selectById(conn, id); //자바빈 객체얻기
			if(pdsItem == null) {
				throw new PdsItemNotFoundException("존재하지않음"+id);
			}
			return pdsItem;
			
		}catch(SQLException e) {
			throw new RuntimeException("DB error"+e.getMessage(),e);
		}finally {
			jdbcUtil.close(conn);
		}
	}

}
