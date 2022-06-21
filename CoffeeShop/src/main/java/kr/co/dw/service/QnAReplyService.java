package kr.co.dw.service;

import java.util.List;

import kr.co.dw.domain.QnAReplyDTO;


public interface QnAReplyService {
	void insert(QnAReplyDTO qnareplyDto);

	List<QnAReplyDTO> getReply(int qno);

}
