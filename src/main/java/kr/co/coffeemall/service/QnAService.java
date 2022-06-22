package kr.co.coffeemall.service;

import java.util.List;

import kr.co.coffeemall.domain.Criteria;
import kr.co.coffeemall.domain.QnaDTO;

public interface QnAService {

	void insert(QnaDTO qDto);

	List<String> list();

	QnaDTO read(int qno, String ip);

	void delete(int qno);

	QnaDTO updateUI(int qno);

	void update(QnaDTO qDto, String[] arr, List<String> fileList);

	int getListCount();

	public List<QnaDTO> getListPaging(Criteria cri);
	

    public int getTotal();
}
