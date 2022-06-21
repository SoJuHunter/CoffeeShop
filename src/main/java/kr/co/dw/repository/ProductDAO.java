package kr.co.dw.repository;

import java.util.List;

import kr.co.dw.domain.ProductDTO;

public interface ProductDAO {
	
	void insert(ProductDTO pDto);

	List<ProductDTO> list();

	ProductDTO read(int pno);

	ProductDTO updateUI(int pno);

	void update(ProductDTO pDto);

	void delete(int pno);

}
