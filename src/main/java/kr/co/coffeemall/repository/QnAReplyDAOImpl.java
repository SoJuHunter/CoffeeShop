package kr.co.coffeemall.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.coffeemall.domain.QnAReplyDTO;

@Repository
public class QnAReplyDAOImpl implements QnAReplyDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "kr.co.coffeemall.reply";

	@Override
	public void insert(QnAReplyDTO qnareplyDto) {
		sqlSession.insert(NAMESPACE+".insert", qnareplyDto);
		
	}

	@Override
	public List<QnAReplyDTO> getReply(int qno) {
		return sqlSession.selectList(NAMESPACE+".reply", qno);
	}


	@Override
	public void delete(QnAReplyDTO qDto) {
		sqlSession.delete(NAMESPACE+".delete", qDto);
		
	}

	@Override
	public void update(QnAReplyDTO qDto) {
		sqlSession.update(NAMESPACE+".update", qDto);
		
	}
}
