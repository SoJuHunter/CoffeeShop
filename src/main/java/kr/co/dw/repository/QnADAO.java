package kr.co.dw.repository;

import java.util.List;

import kr.co.dw.domain.QnaDTO;

public interface QnADAO {
	void insert(QnaDTO qDto);

	List<String> list();

	void increase(int qno);

	QnaDTO read(int qno);

	void delete(int qno);


}
