package kr.co.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dw.domain.ProductDTO;
import kr.co.dw.repository.ProductDAO;
import kr.co.dw.repository.UploadDAO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO pDao;
	
	@Autowired
	private UploadDAO uDao;
    
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

	@Transactional
	@Override
	public void update(ProductDTO pDto, String[] arr, List<String> fileList) {
		// TODO Auto-generated method stub
		update(pDto, arr);

		for (int i = 0; i < fileList.size(); i++) {
			String filename = fileList.get(i);
			uDao.insert(filename, pDto.getPno());
		}
	}

	

}
