package kr.co.dw.repository;

import java.util.List;

public interface ProUploadDAO {

	List<String> getAllUpload(int pno);

	void insert(String filename, int pno);

	void deleteUpload(String filename);

	List<String> list(int pno);

	List<String> list2(int pno);

}
