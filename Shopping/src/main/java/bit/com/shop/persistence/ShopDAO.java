package bit.com.shop.persistence;

import java.util.List;

import bit.com.shop.domain.GoodsViewVO;

public interface ShopDAO {
	//1차 분류
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception; 
	//2차분류
	public List<GoodsViewVO> list(int cateCode) throws Exception; 
	//상품조회 
	public GoodsViewVO goodsView(int gdsNum) throws Exception; 
}
