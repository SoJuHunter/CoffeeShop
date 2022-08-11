package kr.co.dw.service;

import java.util.List;

import kr.co.dw.domain.QnaDTO;


public interface QnAUploadService {
	void insert(QnaDTO qDto);
	
	List<String> getAllUpload(int qno);

	void delete(int qno);

}
