package kr.co.dw.repository;

import java.util.List;

public interface QnaUploadDAO {

	void insert(String filename, int qno);

	List<String> getAllUpload(int qno);

	void delete(int qno);

	void deleteUpload(String delFilename);

}
