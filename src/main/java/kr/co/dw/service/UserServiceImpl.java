package kr.co.dw.service;

import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import kr.co.dw.domain.PageTO;
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
	public int checkPhone(String uPhone) {
		// TODO Auto-generated method stub
		return uDAO.checkPhone(uPhone);
	}
	

	@Override
	public UserDTO login(UserDTO uDTO) {
		// TODO Auto-generated method stub
		return uDAO.login(uDTO);
	}

	@Override
	public UserDTO findid(UserDTO uDTO) {
		// TODO Auto-generated method stub
		return uDAO.findid(uDTO);
	}

	@Override
	public void findPw(HttpServletResponse response, UserDTO uDTO) throws Exception{
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		UserDTO ck = uDAO.readUser(uDTO.getUserId());
		PrintWriter out = response.getWriter();
		// 가입된 아이디가 없으면
		if(checkId(uDTO.getUserId()) == 0) {
			out.print("등록되지 않은 아이디입니다.");
			out.close();
		}
		// 가입된 이메일이 아니면
		else if(checkEmail(uDTO.getuEmail()) == 0) {
			out.print("등록되지 않은 이메일입니다.");
			out.close();
		}else {
			// 임시 비밀번호 생성
			String pw = "";
			for (int i = 0; i < 12; i++) {
				pw += (char) ((Math.random() * 26) + 97);
			}
			
			uDTO.setuPassword(pw);
			// 비밀번호 변경
			uDAO.updatePw(uDTO);
			
			
			
			// 비밀번호 변경 메일 발송
			sendEmail(uDTO, "findpw");

			out.print("이메일로 임시 비밀번호를 발송하였습니다.");
			out.close();
		}
		
	}

	@Override
	public void sendEmail(UserDTO uDTO, String div) throws Exception {
		// TODO Auto-generated method stub
		String charSet = "utf-8";
		String hostSMTP = "smtp.gmail.com"; //네이버 이용시 smtp.naver.com
		String hostSMTPid = "cakung9785@gmail.com";
		String hostSMTPpwd = "qiehkspfveenvokt";

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "cakung9785@gmail.com";
		String fromName = "CoffeeMall";
		String subject = "";
		String msg = "";

		if(div.equals("findpw")) {
			subject = "커피몰 임시 비밀번호 입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += uDTO.getUserId() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
			msg += "<p>임시 비밀번호 : ";
			msg += uDTO.getuPassword() + "</p></div>";
		}

		// 받는 사람 E-Mail 주소
		String mail = uDTO.getuEmail();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setTLS(false);
			email.setHostName(hostSMTP);
			email.setSmtpPort(587); //네이버 이용시 587

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, uDTO.getUserId());
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("메일발송 실패 : " + e);
		}
	}

	@Override
	public PageTO<UserDTO> list(Integer curpage) {
		// TODO Auto-generated method stub
		PageTO<UserDTO> pt = new PageTO<UserDTO>(curpage);
		
		Integer amount = uDAO.getAmountUser();
		pt.setAmount(amount);
		
		List<UserDTO> list = uDAO.list(pt);
		pt.setList(list);
		
		return pt;
	}

	@Override
	public PageTO<UserDTO> search(Integer curpage, String criteria, String keyword) {
		// TODO Auto-generated method stub
		PageTO<UserDTO> pt = new PageTO<UserDTO>(curpage);
		
		Integer amount = uDAO.getAmountSearch(criteria, keyword);
		if(amount==null) {
			amount = 0;
		}
		
		pt.setAmount(amount);
		
		List<UserDTO> list = uDAO.search(pt, criteria, keyword);
		pt.setList(list);
	
		
		return pt;
	}

	@Override
	public void modifyPw(UserDTO uDto) {
		// TODO Auto-generated method stub
		uDAO.modifyPw(uDto);
	}

	@Override
	public void insertNV(UserDTO uDTO) {
		// TODO Auto-generated method stub
		uDAO.insertNV(uDTO);
	}


	@Override
	public UserDTO nvlogin(UserDTO uDTO) {
		// TODO Auto-generated method stub
		return uDAO.nvlogin(uDTO);
	}



}
