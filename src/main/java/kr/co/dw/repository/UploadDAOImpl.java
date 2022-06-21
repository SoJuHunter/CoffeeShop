package kr.co.dw.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UploadDAOImpl implements UploadDAO {
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
		sqlSession.delete(NAMESPACE+".deleteUpload", filename);
		
	}

}
