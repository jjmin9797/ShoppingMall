package bit.com.shop.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import bit.com.shop.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	private SqlSession sql;
	
	//매퍼
	private static String namespace = "bit.com.mappers.memberMapper";
	
	//회원 가입
	@Override
	public void signup(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
			sql.insert(namespace + ".signup", vo);
	}

	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".signin", vo);
		
	}

}
