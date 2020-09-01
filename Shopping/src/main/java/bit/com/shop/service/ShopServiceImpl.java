package bit.com.shop.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import bit.com.shop.domain.GoodsViewVO;
import bit.com.shop.persistence.ShopDAO;

@Service
public class ShopServiceImpl implements ShopService {
	@Inject
	private ShopDAO dao; 
	
	
	@Override
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception {
		 if(level == 1) {  // lavel 1 = 1차 분류.
		  return dao.list(cateCode, cateCode);
		  // 두가지 모두 cateCode로 해도 무관
		 } else {  // lavel 2 = 2차 분류
		  return dao.list(cateCode);
		 }
	}


	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return dao.goodsView(gdsNum); 
	}

	
}
