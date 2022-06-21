package kr.co.dw.repository;

import java.util.List;

public interface UploadDAO {
	
	List<String> getAllUpload(int pno);

	void insert(String filename, int pno);
	
	void deleteUpload(String filename);
}
