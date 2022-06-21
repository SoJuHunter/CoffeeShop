package kr.co.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dw.domain.QnaDTO;
import kr.co.dw.repository.QnaUploadDAO;

@Service
public class QnAUploadServiceImpl implements QnAUploadService {
	
	@Autowired
	private QnaUploadDAO qnauploadDao;

	@Override
	public List<String> getAllUpload(int qno) {
		
		
		return qnauploadDao.getAllUpload(qno);
	}

	@Override
	public void insert(QnaDTO qDto) {
		List<String> list = qDto.getFilenameList();
		
		for(int i=0; i<list.size(); i++) {
			String filename = list.get(i);
			qnauploadDao.insert(filename, qDto.getQno());
		}
		
	}

	@Override
	public void delete(int qno) {
		qnauploadDao.delete(qno);
	}

}
