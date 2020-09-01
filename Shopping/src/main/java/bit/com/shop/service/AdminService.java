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
	public List<GoodsViewVO> goodsList() throws Exception; 
	
	//상품조회 + 카테고리 조인 
	public GoodsViewVO goodsView(int gdsNum) throws Exception; 
	//상품수정 
	public void goodsModify(GoodsVO vo) throws Exception;
	//상품삭제
	public void goodsDelete(int gdsNum) throws Exception;
}
