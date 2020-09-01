package bit.com.shop.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import bit.com.shop.domain.CategoryVO;
import bit.com.shop.domain.GoodsVO;
import bit.com.shop.domain.GoodsViewVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace = "bit.com.mappers.adminMapper";
	
	@Override
	public List<CategoryVO> category() throws Exception {
		return sql.selectList(namespace + ".category");
	}
	//상품등록 
	@Override
	public void register(GoodsVO vo) throws Exception {
		sql.insert(namespace+ ".register",vo);
		
	}
	@Override
	public List<GoodsViewVO> goodsList() throws Exception {
		return sql.selectList(namespace+ ".goodslist"); 
		
	}
	//상품조회+ 카테고리 조인 
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return sql.selectOne(namespace+".goodsView", gdsNum);
	}
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		sql.update(namespace+".goodsModify", vo);	
	}
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		sql.delete(namespace+".goodsDelete", gdsNum);
	}

}
