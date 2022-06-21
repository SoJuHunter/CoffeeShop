package kr.co.dw.service;

import java.util.List;

import kr.co.dw.domain.NoticeDTO;

public interface NoticeService {
	List<NoticeDTO> list();

	void insert(NoticeDTO nDto);

	NoticeDTO read(int nno);

	void delete(int nno);

	NoticeDTO updateUI(int nno);

	void update(NoticeDTO nDto);

	NoticeDTO read(int nno, String ip);

}
