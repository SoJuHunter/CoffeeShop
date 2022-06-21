package kr.co.dw.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dw.domain.NoticeDTO;
import kr.co.dw.repository.NoticeUploadDAO;


@Service
@Transactional
public class NoticeUploadServiceImpl implements NoticeUploadService {

	@Inject
	private NoticeUploadDAO uDao;

	@Override
	public List<String> getAllUpload(int nno) {
		// TODO Auto-generated method stub
		return uDao.getAllUpload(nno);
	}

	@Override
	public void insert(NoticeDTO nDto) {
		// TODO Auto-generated method stub
		List<String> list = nDto.getFilenameList();
		for(int i = 0; i < list.size(); i++) {
			String filename  = list.get(i);
			uDao.insert(filename, nDto.getNno());
		}
		
	}

}
