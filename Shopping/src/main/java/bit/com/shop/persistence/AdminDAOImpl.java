package bit.com.shop.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import bit.com.shop.domain.CategoryVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace = "bit.com.mappers.adminMapper";
	
	@Override
	public List<CategoryVO> category() throws Exception {
		return sql.selectList(namespace + ".category");
	}

}
