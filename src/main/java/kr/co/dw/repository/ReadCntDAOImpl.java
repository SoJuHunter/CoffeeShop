package kr.co.dw.repository;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ReadCntDAOImpl implements ReadCntDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "kr.co.dw.readcnt";
	

	@Override
	public void insert(String ip, int nno) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ip", ip);
		map.put("nno", nno);
		
		sqlSession.insert(NAMESPACE+".insert", map);
		
	}


	@Override
	public String read(String ip, int nno) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ip", ip);
		map.put("nno", nno);
		
		
		return sqlSession.selectOne(NAMESPACE+".read", map);
	}
}
