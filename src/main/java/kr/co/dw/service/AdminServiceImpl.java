package kr.co.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dw.domain.AdminDTO;
import kr.co.dw.domain.Criteria;
import kr.co.dw.domain.OrderDTO;
import kr.co.dw.repository.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO aDao;

	@Override
	public void insert(AdminDTO aDto) {
		// TODO Auto-generated method stub
		
		aDao.insert(aDto);
	}

	@Override
	public List<AdminDTO> list() {
		// TODO Auto-generated method stub
		return aDao.list();
	}

	@Override
	public AdminDTO read(String adminId) {
		// TODO Auto-generated method stub
		return aDao.read(adminId);
	}

	@Override
	public AdminDTO updateUI(String adminId) {
		// TODO Auto-generated method stub
		return aDao.updateUI(adminId);
	}

	@Override
	public void delete(String adminId) {
		// TODO Auto-generated method stub
		aDao.delete(adminId);
		
	}

	@Override
	public void update(AdminDTO aDto) {
		// TODO Auto-generated method stub
		aDao.update(aDto);
		
	}

	@Override
	public AdminDTO login(AdminDTO aDTO) {
		// TODO Auto-generated method stub
		return aDao.login(aDTO);
	}
	
	
	//상품- 관리자
	@Override
	public List<OrderDTO> getOrderList(Criteria cri) {
		// TODO Auto-generated method stub
		return aDao.getOrderList(cri);
	}
	
	//상품- 관리자
	@Override
	public int getOrderTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return aDao.getOrderTotal(cri);
	}
	
}
