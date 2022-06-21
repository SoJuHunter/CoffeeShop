package kr.co.dw.service;

import java.util.List;

import kr.co.dw.domain.NoticeDTO;

public interface NoticeUploadService {
	void insert(NoticeDTO nDto);

	List<String> getAllUpload(int nno);

}
