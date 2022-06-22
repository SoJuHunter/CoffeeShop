package kr.co.dw.service;

import java.util.List;

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

	UserDTO login(UserDTO uDTO);

}
