package kr.co.dw.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dw.domain.UserDTO;
import kr.co.dw.repository.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Inject
	private UserDAO uDAO;

	@Override
	public void insert(UserDTO uDto) {
		// TODO Auto-generated method stub
		uDAO.insert(uDto);		
	}

	@Override
	public List<UserDTO> list() {
		// TODO Auto-generated method stub
		return uDAO.list();
	}

	@Override
	public UserDTO read(String userId) {
		// TODO Auto-generated method stub
		return uDAO.read(userId);
	}

	@Override
	public UserDTO updateUI(String userId) {
		// TODO Auto-generated method stub
		return uDAO.updateUI(userId);
	}

	@Override
	public void update(UserDTO uDto) {
		// TODO Auto-generated method stub
		
		uDAO.update(uDto);
	}

	@Override
	public void delete(String userId) {
		// TODO Auto-generated method stub
		uDAO.delete(userId);
		
	}

	@Override
	public int checkId(String userId) {
		// TODO Auto-generated method stub
		return uDAO.checkId(userId);
	}

	@Override
	public int checkNk(String uNickname) {
		// TODO Auto-generated method stub
		return uDAO.checkNk(uNickname);
	}

	@Override
	public int checkEmail(String uEmail) {
		// TODO Auto-generated method stub
		return uDAO.checkEmail(uEmail);
	}

	@Override
	public UserDTO login(UserDTO uDTO) {
		// TODO Auto-generated method stub
		return uDAO.login(uDTO);
	}
}
