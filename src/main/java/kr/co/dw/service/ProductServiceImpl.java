package kr.co.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import kr.co.dw.domain.OrderAllDTO;
import kr.co.dw.domain.OrderItemDTO;
import kr.co.dw.domain.PageTO;
import kr.co.dw.domain.ProductDTO;
import kr.co.dw.repository.ProductDAO;
import kr.co.dw.repository.OrderDAO;
import kr.co.dw.repository.ProUploadDAO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO pDao;
	
	@Autowired
	private ProUploadDAO uDao;
	
	@Autowired
	private OrderDAO oDao;
    
	@Transactional
	@Override
	public void insert(ProductDTO pDto) {
		// TODO Auto-generated method stub
		pDao.insert(pDto);
		
		int pno = pDto.getPno();
		System.out.println(pno);
		List<String> list = pDto.getFilenameList();
		for(int i=0; i<list.size(); i++) {
			String filename = list.get(i);
			uDao.insert(filename, pno);
		}
		
	}
    @Transactional
	@Override
	public List<ProductDTO> list() {
		// TODO Auto-generated method stub
		return pDao.list();
	}
    

    
	@Override
	public ProductDTO read(int pno) {
		// TODO Auto-generated method stub
		return pDao.read(pno);
	}
	
    @Override
	public ProductDTO updateUI(int pno) {
		// TODO Auto-generated method stub
		return pDao.updateUI(pno);
	}
    
    @Override
	public void update(ProductDTO pDto) {
		// TODO Auto-generated method stub
		pDao.update(pDto);
	}
    
    
    
	@Override
	public void delete(int pno) {
		// TODO Auto-generated method stub
		pDao.delete(pno);
		
	}
	
	
	
	
	
	@Override
	@Transactional
	public void update(ProductDTO pDto, String[] arr) {
		// TODO Auto-generated method stub
		update(pDto);

		for (int i = 0; i < arr.length; i++) {
			String filename = arr[i];
			uDao.deleteUpload(filename);
		}
	}
	
	
	@Override
	public void update(ProductDTO pDto, String[] arr, List<String> fileList) {
		// TODO Auto-generated method stub
		
		update(pDto, arr);

		for (int i = 0; i < fileList.size(); i++) {
			String filename = fileList.get(i);
			uDao.insert(filename, pDto.getPno());
		}
		
	}

	
	/*
	 * @Override public PageTO<ProductDTO> list(Integer curpage) { // TODO
	 * Auto-generated method stub PageTO<ProductDTO> pt = new
	 * PageTO<ProductDTO>(curpage); Integer amount = pDao.getAmountProduct();
	 * pt.setAmount(amount);
	 * 
	 * List<ProductDTO> list = pDao.list(pt);
	 * 
	 * pt.setList(list);
	 * 
	 * 
	 * return pt; }
	 */

	@Override
	public PageTO<ProductDTO> list(Integer curpage, String category) {
		// TODO Auto-generated method stub
		PageTO<ProductDTO> pt = new PageTO<ProductDTO>(curpage);
		Integer amount = pDao.getAmountProduct(category);
		
		
		pt.setAmount(amount);
		
		List<ProductDTO> list = pDao.list(pt, category);
		
		pt.setList(list);
		
		
		return pt;
	}
	@Override
	public PageTO<ProductDTO> search(Integer curpage, String criteria, String keyword) {
		// TODO Auto-generated method stub
		
		PageTO<ProductDTO> pt = new PageTO<ProductDTO>(curpage);
		
		Integer amount = pDao.getAmountSearch(criteria, keyword);
		
		if(amount == null) {
			amount  = 0;
		}
		
		pt.setAmount(amount);
		
		List<ProductDTO> list = pDao.search(pt, criteria, keyword);
		pt.setList(list);
		
		return pt;
	}
	
	@Transactional
	@Override
	public PageTO<ProductDTO> stocklist(Integer curpage) {
		// TODO Auto-generated method stub
		PageTO<ProductDTO> pt = new PageTO<ProductDTO>(curpage);
		
		Integer amount = pDao.getAmountStock();
		pt.setAmount(amount);
		
		
		
		
		List<ProductDTO> stocklist = pDao.stocklist(pt);
		pt.setList(stocklist);
		
		return pt;
	}


   



}
