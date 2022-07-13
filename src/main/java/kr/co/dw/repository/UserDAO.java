package kr.co.dw.repository;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import kr.co.dw.domain.PageTO;
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
   
   int checkPhone(String uPhone);

   UserDTO login(UserDTO uDTO);

   UserDTO findid(UserDTO uDTO);

   UserDTO readUser(String userId);

	void updatePw(UserDTO uDTO); 

   Integer getAmountUser();

   List<UserDTO> list(PageTO<UserDTO> pt);
   
   List<UserDTO> search(PageTO<UserDTO> pt, String criteria, String keyword);

   Integer getAmountSearch(String criteria, String keyword);

   void modifyPw(UserDTO uDto);

void insertNV(UserDTO uDTO);

UserDTO naverChk(UserDTO uDTO);

UserDTO nvlogin(UserDTO uDTO);

UserDTO getUserInfo(String userId);



}