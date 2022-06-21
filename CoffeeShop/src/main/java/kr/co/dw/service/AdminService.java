package kr.co.dw.service;

import java.util.List;

import kr.co.dw.domain.AdminDTO;

public interface AdminService {

	void insert(AdminDTO aDto);

	List<AdminDTO> list();

	AdminDTO read(String adminId);

	AdminDTO updateUI(String adminId);

	void delete(String adminId);

	void update(AdminDTO aDto);

}
