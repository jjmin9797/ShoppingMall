package bit.com.shop.service;

import java.util.List;

import bit.com.shop.domain.GoodsViewVO;

public interface ShopService {
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception;
	
	//상품조회 
	public GoodsViewVO goodsView(int gdsNum) throws Exception; 

}
