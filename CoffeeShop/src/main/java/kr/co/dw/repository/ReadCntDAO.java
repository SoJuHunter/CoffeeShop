package kr.co.dw.repository;

public interface ReadCntDAO {
	
	void insert(String ip, int nno);
	String read(String ip, int nno);


}
