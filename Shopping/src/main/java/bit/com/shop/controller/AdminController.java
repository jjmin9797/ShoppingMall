package bit.com.shop.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.shop.domain.CategoryVO;
import bit.com.shop.service.AdminService;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Inject
	private AdminService adminService;
	
	//관리자 화면
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void getIndex() throws Exception{
		logger.info("get index");
	}
	// 상품 등록
	@RequestMapping(value = "/goods/register", method = RequestMethod.GET)
	public void getGoodsRegister(Model model) throws Exception{
		logger.info("get goods register");
		
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	
}
