package kr.co.dw.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dw.domain.QnaDTO;

@Repository
public class QnADAOImpl implements QnADAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMECSPACE = "kr.co.dw.qna";

	@Override
	public void insert(QnaDTO qDto) {
		sqlSession.insert(NAMECSPACE+".insert", qDto);
		
	}

	@Override
	public List<String> list() {
		return sqlSession.selectList(NAMECSPACE+".list");
	}

	@Override
	public void increase(int qno) {
		sqlSession.update(NAMECSPACE+".increase", qno);
		
	}

	@Override
	public QnaDTO read(int qno) {
		return sqlSession.selectOne(NAMECSPACE+".read", qno);
	}

	@Override
	public void delete(int qno) {
		sqlSession.delete(NAMECSPACE+".delete", qno);		
	}
}
