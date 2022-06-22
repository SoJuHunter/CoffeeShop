package kr.co.coffeemall.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.coffeemall.domain.QnAReplyDTO;
import kr.co.coffeemall.repository.QnAReplyDAO;

@Service
public class QnAReplyServiceImpl implements QnAReplyService {

	@Autowired
	private QnAReplyDAO qnareplyDao;

	@Override
	public void insert(QnAReplyDTO qnareplyDto) {
		qnareplyDao.insert(qnareplyDto);
	}

	@Override
	public List<QnAReplyDTO> getReply(int qno) {
		return qnareplyDao.getReply(qno);
	}

	@Override
	public void delete(QnAReplyDTO qDto) {
		qnareplyDao.delete(qDto);
		
	}

	@Override
	public void update(QnAReplyDTO qDto) {
		qnareplyDao.update(qDto);
	}


}
