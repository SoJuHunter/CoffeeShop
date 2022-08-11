package kr.co.dw.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProUploadDAOImpl implements ProUploadDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "kr.co.dw.upload";

	@Override
	public List<String> getAllUpload(int pno) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".getAllUpload", pno);
	}

	@Override
	public void insert(String filename, int pno) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("filename", filename);
		map.put("pno", pno);
		
		sqlSession.insert(NAMESPACE+".insert", map);
		
		
	}

	@Override
	public void deleteUpload(String filename) {
		// TODO Auto-generated method stub
		sqlSession.delete(NAMESPACE+".deleteUpload", filename);
		
	}

	@Override
	public List<String> list(int pno) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".list", pno);
	}

	@Override
	public List<String> list2(int pno) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".list2", pno);
	}

}
