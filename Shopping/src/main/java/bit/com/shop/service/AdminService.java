package bit.com.shop.service;

import java.util.List;

import bit.com.shop.domain.CategoryVO;

public interface AdminService {
	
	public List<CategoryVO> category() throws Exception;
}
