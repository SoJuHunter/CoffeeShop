package kr.co.dw.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dw.domain.QnAReplyDTO;

@Repository
public class QnAReplyDAOImpl implements QnAReplyDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "kr.co.dw.reply";

	@Override
	public void insert(QnAReplyDTO qnareplyDto) {
		sqlSession.insert(NAMESPACE+".insert", qnareplyDto);
		
	}

	@Override
	public List<QnAReplyDTO> getReply(int qno) {
		return sqlSession.selectList(NAMESPACE+".reply", qno);
	}

}
