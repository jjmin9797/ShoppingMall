package bit.com.shop.persistence;

import bit.com.shop.domain.MemberVO;

public interface MemberDAO {
	
	//회원 가입
	public void signup(MemberVO vo) throws Exception;
	
	//로그인
	public MemberVO signin(MemberVO vo) throws Exception;
}
