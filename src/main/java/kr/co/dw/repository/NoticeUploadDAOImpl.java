package kr.co.dw.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeUploadDAOImpl implements NoticeUploadDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "kr.co.dw.noticeupload";

	@Override
	public void insert(String filename, int nno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("filename", filename);
		map.put("nno", nno);
		
		sqlSession.insert(NAMESPACE + ".insert", map);
		
	}

	@Override
	public List<String> getAllUpload(int nno) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".getAllUpload", nno);
	}

	@Override
	public void deleteUpload(String filename) {
		// TODO Auto-generated method stub
		sqlSession.delete(NAMESPACE+".deleteUpload", filename);
	}

}
