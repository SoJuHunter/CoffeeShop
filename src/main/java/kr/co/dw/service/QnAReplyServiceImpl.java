package kr.co.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dw.domain.QnAReplyDTO;
import kr.co.dw.repository.QnAReplyDAO;

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

}
