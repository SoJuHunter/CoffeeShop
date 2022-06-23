package kr.co.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dw.domain.Criteria;
import kr.co.dw.domain.QnaDTO;
import kr.co.dw.repository.QnADAO;
import kr.co.dw.repository.QnAReadCntDAO;
import kr.co.dw.repository.QnaUploadDAO;

@Service
public class QnAServiceImpl implements QnAService {

	@Autowired
	private QnADAO qnaDao;
	
	@Autowired
	private QnaUploadDAO quploadDao;
	
	@Autowired
	private QnAReadCntDAO qReadCntDao;
	
	@Transactional
	@Override
	public void insert(QnaDTO qDto) {
		qnaDao.insert(qDto);
		
		int qno = qDto.getQno();
		List<String> list = qDto.getFilenameList();
		
		for(int i=0; i<list.size(); i++) {
			String filename = list.get(i);
			quploadDao.insert(filename, qno);
		}
	}

	
	@Override
	public List<String> list() {
		return qnaDao.list();
	}

	
	@Transactional
	@Override
	public QnaDTO read(int qno, String ip) {
		String readip = qReadCntDao.read(ip, qno);
		
		if(readip == null) {
			qReadCntDao.insert(ip, qno);
			qnaDao.increase(qno);
		}
		
		QnaDTO qDto = qnaDao.read(qno);
		
		return qDto;
	}


	@Override
	public void delete(int qno) {
		qnaDao.delete(qno);
		
	}


	@Override
	public QnaDTO updateUI(int qno) {
		return qnaDao.updateUI(qno);
	}


	@Transactional
	@Override
	public void update(QnaDTO qDto, String[] arr, List<String> fileList) {
		qnaDao.update(qDto);
		
		for(int i=0; i<arr.length; i++) {
			String delFilename = arr[i];
			quploadDao.deleteUpload(delFilename);
		}
		
		for(int i=0; i<fileList.size(); i++) {
			String filename = fileList.get(i);
			quploadDao.insert(filename, qDto.getQno());
		}
		
	}


	@Override
	public int getListCount() {
		return 0;
	}


	@Override
	public List<QnaDTO> getListPaging(Criteria cri) {
		
		return qnaDao.getListPaging(cri);
	}


	@Override
	public int getTotal() {
		return qnaDao.getTotal();
	}
	
	
	
}
