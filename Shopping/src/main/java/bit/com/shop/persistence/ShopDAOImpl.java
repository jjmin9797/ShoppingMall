package bit.com.shop.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import bit.com.shop.domain.GoodsViewVO;

@Repository
public class ShopDAOImpl implements ShopDAO {
	
	@Inject
	private SqlSession sql; 
	//매퍼 
	private static String namespace = "bit.com.mappers.shopMapper";
	
	@Override
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception {
		 
		 HashMap<String, Object> map = new HashMap<String, Object>();
		 
		 map.put("cateCode", cateCode);
		 map.put("cateCodeRef", cateCodeRef);
		 return sql.selectList(namespace + ".list_1", map);
	}

	@Override
	public List<GoodsViewVO> list(int cateCode) throws Exception {
		System.out.println(cateCode);
		return sql.selectList(namespace+".list_2",cateCode); 
	}

	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return sql.selectOne("bit.com.mappers.adminMapper.goodsView",gdsNum); 
	}
}
