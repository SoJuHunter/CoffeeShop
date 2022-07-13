package kr.co.dw.repository;

import java.util.List;

import kr.co.dw.domain.AdminDTO;
import kr.co.dw.domain.Criteria;
import kr.co.dw.domain.OrderDTO;

public interface AdminDAO {

	void insert(AdminDTO aDto);

	List<AdminDTO> list();

	AdminDTO read(String adminId);

	AdminDTO updateUI(String adminId);

	void delete(String adminId);

	void update(AdminDTO aDto);

	AdminDTO login(AdminDTO aDTO);
	
	//주문 상품 리스트
	List<OrderDTO> getOrderList(Criteria cri);
	
	//주문 총 개수
	int getOrderTotal(Criteria cri);
	
	
}
