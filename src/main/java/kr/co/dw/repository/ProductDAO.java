package kr.co.dw.repository;

import java.util.List;

import org.springframework.ui.Model;

import kr.co.dw.domain.PageTO;
import kr.co.dw.domain.ProductDTO;

public interface ProductDAO {

	void insert(ProductDTO pDto);

	List<ProductDTO> list();

	ProductDTO read(int pno);

	ProductDTO updateUI(int pno);

	void update(ProductDTO pDto);
	
	void delete(int pno);

	List<ProductDTO> list(PageTO<ProductDTO> pt, String category);

	Integer getAmountProduct(String category);

	Integer getAmountSearch(String criteria, String keyword);

	List<ProductDTO> search(PageTO<ProductDTO> pt, String criteria, String keyword);

	ProductDTO getProductStock(int pno);
	
	List<ProductDTO> stocklist(PageTO<ProductDTO> pt);

	Integer getAmountStock();





	

	

}
