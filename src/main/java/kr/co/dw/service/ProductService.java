package kr.co.dw.service;

import java.util.List;

import kr.co.dw.domain.ProductDTO;

public interface ProductService {
	void insert(ProductDTO pDto);

	List<ProductDTO> list();

	ProductDTO read(int pno);

	void delete(int pno);
	
	ProductDTO updateUI(int pno);

	void update(ProductDTO pDto);

	void update(ProductDTO pDto, String[] arr, List<String> fileList);

	void update(ProductDTO pDto, String[] arr);



}
