package kr.co.dw.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import kr.co.dw.domain.PageTO;
import kr.co.dw.domain.UserDTO;

public interface UserService {

	void insert(UserDTO uDto);

	List<UserDTO> list();

	UserDTO read(String userId);

	UserDTO updateUI(String userId);

	void update(UserDTO uDto);

	void delete(String userId);

	int checkId(String userId);

	int checkNk(String uNickname);

	int checkEmail(String uEmail);
	
	int checkPhone(String uPhone);

	UserDTO login(UserDTO uDTO);

	UserDTO findid(UserDTO uDTO);

	void findPw(HttpServletResponse response, UserDTO uDTO) throws Exception;
	
	public void sendEmail(UserDTO uDTO, String div) throws Exception;

	PageTO<UserDTO> list(Integer curpage);

	PageTO<UserDTO> search(Integer curpage, String criteria, String keyword);

	void modifyPw(UserDTO uDto);

	


}
