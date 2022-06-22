package kr.co.coffeemall.repository;


import java.util.List;

import kr.co.coffeemall.domain.QnAReplyDTO;

public interface QnAReplyDAO {

	void insert(QnAReplyDTO qnareplyDto);

	List<QnAReplyDTO> getReply(int qno);

	void delete(QnAReplyDTO qDto);

	void update(QnAReplyDTO qDto);

}
