package kr.co.dw.service;

import java.util.List;

import kr.co.dw.domain.QnaDTO;


public interface QnAService {

	void insert(QnaDTO qDto);

	List<String> list();

	QnaDTO read(int qno, String ip);

	void delete(int qno);
}
