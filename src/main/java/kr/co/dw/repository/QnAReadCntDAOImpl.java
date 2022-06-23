package kr.co.dw.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QnAReadCntDAOImpl implements QnAReadCntDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "kr.co.dw.qnareadcnt";

	@Override
	public String read(String ip, int qno) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ip", ip);
		map.put("qno", qno);
		
		return sqlSession.selectOne(NAMESPACE+".read", map);
	}

	@Override
	public void insert(String ip, int qno) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ip", ip);
		map.put("qno", qno);
		
		sqlSession.insert(NAMESPACE+".insert", map);
		
		
	}
}
