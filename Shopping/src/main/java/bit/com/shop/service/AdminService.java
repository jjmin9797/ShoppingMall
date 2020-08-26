package bit.com.shop.service;

import java.util.List;

import bit.com.shop.domain.CategoryVO;
import bit.com.shop.domain.GoodsVO;
import bit.com.shop.domain.GoodsViewVO;

public interface AdminService {
	
	public List<CategoryVO> category() throws Exception;
	
	//상품등록
	public void register(GoodsVO vo) throws Exception; 
	
	
	//상품목록 
	public List<GoodsVO> goodsList() throws Exception; 
	
	//상품조회 
	public GoodsViewVO goodsView(int gdsNum) throws Exception; 
	
	public void goodsModify(GoodsVO vo) throws Exception;
}
