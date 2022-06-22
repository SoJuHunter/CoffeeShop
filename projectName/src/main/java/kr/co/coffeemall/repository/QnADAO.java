package kr.co.coffeemall.repository;

import java.util.List;

import kr.co.coffeemall.domain.Criteria;
import kr.co.coffeemall.domain.QnaDTO;

public interface QnADAO {

	void insert(QnaDTO qDto);

	List<String> list();

	void increase(int qno);

	QnaDTO read(int qno);

	void delete(int qno);

	QnaDTO updateUI(int qno);

	void update(QnaDTO qDto);
	
	public List<QnaDTO> getListPaging(Criteria cri);
	
	public int getTotal();

}
