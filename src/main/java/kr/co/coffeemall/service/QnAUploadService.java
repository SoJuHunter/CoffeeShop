package kr.co.coffeemall.service;

import java.util.List;

import kr.co.coffeemall.domain.QnaDTO;

public interface QnAUploadService {

	void insert(QnaDTO qDto);
	
	List<String> getAllUpload(int qno);

	void delete(int qno);

}
