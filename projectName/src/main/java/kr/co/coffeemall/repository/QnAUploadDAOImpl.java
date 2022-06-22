package kr.co.coffeemall.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QnAUploadDAOImpl implements QnaUploadDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "kr.co.coffeemall.qnaupload";

	@Override
	public void insert(String filename, int qno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("filename", filename);
		map.put("qno", qno);
		
		sqlSession.insert(NAMESPACE+".insert", map);
		
	}

	@Override
	public List<String> getAllUpload(int qno) {
		return sqlSession.selectList(NAMESPACE+".getAllUpload", qno);
	}

	@Override
	public void delete(int qno) {
		sqlSession.delete(NAMESPACE+".delete", qno);
	}
	
	@Override
	public void deleteUpload(String delFilename) {
		sqlSession.delete(NAMESPACE+".deleteUpload", delFilename);
		
	}
	
}
