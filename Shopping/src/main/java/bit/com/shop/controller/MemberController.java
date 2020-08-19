package bit.com.shop.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bit.com.shop.domain.MemberVO;
import bit.com.shop.service.MemberService;


@Controller
@RequestMapping("/member/*")
public class MemberController {
	

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {

	    return new BCryptPasswordEncoder();
	}
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	 
	// 회원 가입 get
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public void getSignup() throws Exception {
	 logger.info("get signup");
	}

	// 회원 가입 post
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String postSignup(MemberVO vo) throws Exception {
	 logger.info("post signup");
	 
	 String inputPass = vo.getUserPass();
	 String pass = passEncoder.encode(inputPass);
	 vo.setUserPass(pass);

	 service.signup(vo);

	 return "redirect:/";
	}
	
	
	
	// 로그인  get
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public void getSignin() throws Exception {
	 logger.info("get signin");
	}

	// 로그인 post
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String postSignin(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
	 //, HttpServletRequest req
		logger.info("post signin");
		MemberVO login = service.signin(vo);
		
		if(login != null ) {
			
			boolean passMatch = passEncoder.matches(vo.getUserPass(), login.getUserPass());
			if(passMatch) {
				HttpSession session = req.getSession();
				session.setAttribute("member", login);

				 return "redirect:/";
			}
		}
			//session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/signin";
	 
		
		
		
		
	
		
		//System.out.println(vo.getUserPass()+ " //////" + login.getUserPass());

		
		//System.out.println(passMatch);
		
	 
	
	}
	  
	// 로그아웃
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String signout(HttpSession session) throws Exception {
	 logger.info("get logout");
	 
	 service.signout(session);
	   
	 return "redirect:/";
	}
	
	
	
	
	
	
}