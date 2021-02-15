package first.common.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO {
	protected Log log = LogFactory.getLog(AbstractDAO.class);

	
	@Autowired //°´Ã¼ Ã£±â
	private SqlSessionTemplate sqlSesison;
	
	protected void printQueryId(String queryId) {//mybatis
		if(log.isDebugEnabled()) {
			log.debug("\t QueryId \t:	" + queryId);
		}
	}
	
	public Object insert(String queryId, Object params) {
		printQueryId(queryId);
		return sqlSesison.insert(queryId, params);
	}
	public Object update(String queryId, Object params) {
		printQueryId(queryId);
		return sqlSesison.insert(queryId, params);
	}
	public Object delete(String queryId, Object params) {
		printQueryId(queryId);
		return sqlSesison.insert(queryId, params);
	}
	public Object selectOne(String queryId, Object params) {
		printQueryId(queryId);
		return sqlSesison.insert(queryId, params);
	}
	
	@SuppressWarnings("rawtypes")
	public List selectList(String queryId) {
		printQueryId(queryId);
		return sqlSesison.selectList(queryId);
	}
	
	@SuppressWarnings("rawtypes")
	public List selectList(String queryId, Object params) {
		printQueryId(queryId);
		return sqlSesison.selectList(queryId, params);
	}
}
