package kr.co.dw.repository;

import java.util.List;

import kr.co.dw.domain.QnAReplyDTO;



public interface QnAReplyDAO {
	void insert(QnAReplyDTO qnareplyDto);

	List<QnAReplyDTO> getReply(int qno);


}
