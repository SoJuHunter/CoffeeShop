package kr.co.dw.repository;

import java.util.List;

import kr.co.dw.domain.UserDTO;

public interface UserDAO {

	void insert(UserDTO uDto);

	List<UserDTO> list();

	UserDTO read(String userId);

	UserDTO updateUI(String userId);

	void update(UserDTO uDto);

	void delete(String userId);

	int checkId(String userId);

	int checkNk(String uNickname);

	int checkEmail(String uEmail);

	UserDTO login(UserDTO uDTO);

	UserDTO findid(UserDTO uDTO);
	
	UserDTO readUser(String userId);

	void updatePw(UserDTO uDTO);

}
