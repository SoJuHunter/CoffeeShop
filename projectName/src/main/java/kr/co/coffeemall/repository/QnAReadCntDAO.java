package kr.co.coffeemall.repository;

public interface QnAReadCntDAO {

	String read(String ip, int qno);

	void insert(String ip, int qno);

}
