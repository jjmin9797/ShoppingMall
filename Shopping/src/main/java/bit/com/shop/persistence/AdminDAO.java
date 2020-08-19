package bit.com.shop.persistence;

import java.util.List;

import bit.com.shop.domain.CategoryVO;

public interface AdminDAO {
	public List<CategoryVO> category() throws Exception;
	
}
