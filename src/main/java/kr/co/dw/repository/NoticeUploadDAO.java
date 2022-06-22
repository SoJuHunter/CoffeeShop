package kr.co.dw.repository;

import java.util.List;

public interface NoticeUploadDAO {
	
	void insert(String filename, int nno);

	List<String> getAllUpload(int nno);

	void deleteUpload(String filename);

}
