package kr.co.dw.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dw.domain.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;		
	
	private final String NAMESPACE = "kr.co.dw.user";

	@Override
	public void insert(UserDTO uDto) {
		// TODO Auto-generated method stub
		
		sqlSession.insert(NAMESPACE+".insert", uDto);
		
	}

	@Override
	public List<UserDTO> list() {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList(NAMESPACE+".list");
	}

	@Override
	public UserDTO read(String userId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".read", userId);
	}

	@Override
	public UserDTO updateUI(String userId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".updateUI", userId);
	}

	@Override
	public void update(UserDTO uDto) {
		// TODO Auto-generated method stub
		
		sqlSession.update(NAMESPACE+".update", uDto);
	}

	@Override
	public void delete(String userId) {
		// TODO Auto-generated method stub
		sqlSession.delete(NAMESPACE + ".delete", userId);
		
	}

	@Override
	public int checkId(String userId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".checkId", userId);
	}

	@Override
	public int checkNk(String uNickname) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".checkNk", uNickname);
	}

	@Override
	public int checkEmail(String uEmail) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".checkEmail", uEmail);
	}

}
