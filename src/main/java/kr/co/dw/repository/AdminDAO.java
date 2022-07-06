package kr.co.dw.repository;

import java.util.List;

import kr.co.dw.domain.AdminDTO;

public interface AdminDAO {

	void insert(AdminDTO aDto);

	List<AdminDTO> list();

	AdminDTO read(String adminId);

	AdminDTO updateUI(String adminId);

	void delete(String adminId);

	void update(AdminDTO aDto);

	AdminDTO login(AdminDTO aDTO);

}
