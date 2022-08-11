package kr.co.dw.service;

import java.util.List;

import kr.co.dw.domain.ProductDTO;

public interface ProUploadService {

	List<String> getAllUpload(int pno);

	void insert(ProductDTO pDto);

	List<String> list(int pno);

	
	


}
