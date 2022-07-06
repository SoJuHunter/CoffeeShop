package kr.co.dw.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dw.domain.BossDTO;

@Repository
public class BossDAOImpl implements BossDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "kr.co.dw.boss";
	
	
	@Override
	public void insert(BossDTO bDto) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE+".insert", bDto);
	}


	@Override
	public List<BossDTO> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".list");
	}


	@Override
	public BossDTO read(String bossId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".read", bossId);
	}


	@Override
	public BossDTO updateUI(String bossId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".updateUI", bossId);
	}


	@Override
	public void update(BossDTO bDto) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+".update", bDto);
	}


	@Override
	public void delete(String bossId) {
		// TODO Auto-generated method stub
		sqlSession.delete(NAMESPACE+".delete", bossId);
		
	}


	@Override
	public BossDTO login(BossDTO bDTO) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".login", bDTO);
	}
	

}
