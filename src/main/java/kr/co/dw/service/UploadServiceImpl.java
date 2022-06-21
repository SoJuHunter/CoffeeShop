package kr.co.dw.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dw.domain.ProductDTO;
import kr.co.dw.repository.UploadDAO;

@Service
public class UploadServiceImpl implements UploadService {
	@Inject 
	private UploadDAO uDao;

	@Override
	public List<String> getAllUpload(int pno) {
		// TODO Auto-generated method stub
		return uDao.getAllUpload(pno);
	}

	@Override
	public void insert(ProductDTO pDto) {
		// TODO Auto-generated method stub
		
		List<String> list = pDto.getFilenameList(); //사실상 list
		
	    for(int i=0; i<list.size(); i++) {
	    	String filename = list.get(i);
	    	uDao.insert(filename, pDto.getPno());
	    }
		
	}

}
