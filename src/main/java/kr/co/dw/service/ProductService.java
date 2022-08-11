package kr.co.dw.service;

import java.util.List;

import org.springframework.ui.Model;

import kr.co.dw.domain.PageTO;
import kr.co.dw.domain.ProductDTO;

public interface ProductService {

	void insert(ProductDTO pDto);

	List<ProductDTO> list();

	ProductDTO read(int pno);
	
	ProductDTO updateUI(int pno);
	
	void update(ProductDTO pDto);

	void delete(int pno);

	void update(ProductDTO pDto, String[] arr, List<String> fileList);

	void update(ProductDTO pDto, String[] arr);

//	PageTO<ProductDTO> list(Integer curpage);

	PageTO<ProductDTO> list(Integer curpage, String category);

	PageTO<ProductDTO> search(Integer curpage, String criteria, String keyword);
	
	PageTO<ProductDTO> stocklist(Integer curpage);



	



	



}
