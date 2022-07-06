package kr.co.dw.controller;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.dw.domain.AdminDTO;
import kr.co.dw.domain.BossDTO;
import kr.co.dw.domain.PageTO;
import kr.co.dw.domain.UserDTO;
import kr.co.dw.service.AdminService;
import kr.co.dw.service.BossService;
import kr.co.dw.service.UserService;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Controller
public class UserController {
	@Inject
	private UserService uService;

	@Inject
	private BossService bService;

	@Inject
	private AdminService aService;

	
	@RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
	public String adminlogout() {

		return "redirect:/admin/loginget";
	}

	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public void login(AdminDTO aDTO, Model model) {

		AdminDTO adminLogin = aService.login(aDTO);
		model.addAttribute("adminLogin", adminLogin);
		model.addAttribute("adminLOGIN_ERR_MSG", "로그인 실패");
		
		System.out.println("@@@@@@@@@@@@@@@@"+adminLogin);

	}

	@RequestMapping(value = "/admin/loginget", method = RequestMethod.GET)
	public String adminlogin() {

		return "/admin/login";
	}


	@RequestMapping(value = "/user/search", method = RequestMethod.GET)
	public void search(Integer curpage, String criteria, String keyword, Model model) {
		if (curpage == null) {
			curpage = 1;
		}

		PageTO<UserDTO> pt = uService.search(curpage, criteria, keyword);
		model.addAttribute("list", pt.getList());
		model.addAttribute("pt", pt);
		model.addAttribute("criteria", criteria);
		model.addAttribute("keyword", keyword);

	}

	// 비밀번호 인증용 외부 클래스
	public class UserAuthentication extends Authenticator {
		private PasswordAuthentication pwa;

		public UserAuthentication(String id, String pw) {
			pwa = new PasswordAuthentication(id, pw);
		}

		@Override
		public PasswordAuthentication getPasswordAuthentication() {
			// TODO Auto-generated method stub
			return pwa;
		}

	}

	@RequestMapping(value = "/user/sendMail", method = RequestMethod.POST)
	public void send(String from, String to, String title, String content, String pw) {

		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.naver.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		Authenticator auth = new UserAuthentication(from, pw);

		Session session = Session.getDefaultInstance(props, auth);

		// 실제로 메일을 전달할 수 있는 객체 만들기
		MimeMessage mMsg = new MimeMessage(session);

		try {
			mMsg.setSentDate(new Date());

			InternetAddress fromId = new InternetAddress(from);
			mMsg.setFrom(fromId);

			InternetAddress toId = new InternetAddress(to);
			Address[] arr = { toId };

			mMsg.setRecipients(Message.RecipientType.TO, arr);// setTo가 없다
			mMsg.setSubject(title, "UTF-8");
			mMsg.setText(content, "UTF-8");
			mMsg.setHeader("content-Type", "text/html");

			Transport.send(mMsg, mMsg.getAllRecipients());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/user/sendMail", method = RequestMethod.GET)
	public void sendMail() {

	}

	@RequestMapping(value = "/user/findpw", method = RequestMethod.GET)
	public void findPwGET() throws Exception {
	}

	@RequestMapping(value = "/user/findpw", method = RequestMethod.POST)
	public void findPwPOST(@ModelAttribute UserDTO uDTO, HttpServletResponse response) throws Exception {
		uService.findPw(response, uDTO);
	}

	@RequestMapping(value = "/user/findid", method = RequestMethod.POST)
	public String findid(UserDTO uDTO, Model model) {
		UserDTO findId = uService.findid(uDTO);

		if (findId != null) {
			model.addAttribute("findId", findId.getUserId());
		}

		return "/user/resultid";

	}

	@RequestMapping(value = "/user/findidget", method = RequestMethod.GET)
	public String findid() {

		return "/user/findid";
	}

	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	public String logout() {

		return "redirect:/user/loginget";
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public void login(UserDTO uDTO, Model model) {

		UserDTO login = uService.login(uDTO);
		model.addAttribute("login", login);
		model.addAttribute("LOGIN_ERR_MSG", "로그인 실패");

	}

	@RequestMapping(value = "/user/loginget", method = RequestMethod.GET)
	public String login() {

		return "/user/login";
	}

	@RequestMapping(value = "/admin/delete/{adminId}", method = RequestMethod.POST)
	public String adminDelete(@PathVariable("adminId") String adminId) {
		aService.delete(adminId);

		return "redirect:/admin/list";
	}

	@RequestMapping(value = "/admin/update", method = RequestMethod.POST)
	public String adminUpdate(AdminDTO aDto) {

		aService.update(aDto);

		return "redirect:/admin/read/" + aDto.getAdminId();
	}

	@RequestMapping(value = "/admin/update/{adminId}", method = RequestMethod.GET)
	public String adminUpdate(@PathVariable("adminId") String adminId, Model model) {

		AdminDTO aDto = aService.updateUI(adminId);

		model.addAttribute("aDto", aDto);

		return "/admin/update";
	}

	@RequestMapping(value = "/admin/read/{adminId}", method = RequestMethod.GET)
	public String adminRead(@PathVariable("adminId") String adminId, Model model) {

		AdminDTO aDto = aService.read(adminId);

		model.addAttribute("aDto", aDto);

		return "/admin/read";
	}

	@RequestMapping(value = "/admin/list", method = RequestMethod.GET)
	public String adminList(Model model) {
		List<AdminDTO> aList = aService.list();

		model.addAttribute("aList", aList);

		return "/admin/list";
	}

	@RequestMapping(value = "/admin/insert", method = RequestMethod.POST)
	public String adminInsert(AdminDTO aDto) {
		aService.insert(aDto);

		return "redirect:/admin/list";
	}

	@RequestMapping(value = "/admin/insert", method = RequestMethod.GET)
	public String adminInsert() {

		return "/admin/insert";
	}

	@RequestMapping(value = "/boss/delete/{bossId}", method = RequestMethod.POST)
	public String bossDelete(@PathVariable("bossId") String bossId) {
		bService.delete(bossId);

		return "redirect:/boss/list";
	}

	@RequestMapping(value = "/boss/update", method = RequestMethod.POST)
	public String bossUpdate(BossDTO bDto) {

		bService.update(bDto);

		return "redirect:/boss/read/" + bDto.getBossId();
	}

	@RequestMapping(value = "/boss/update/{bossId}", method = RequestMethod.GET)
	public String bossUpdate(@PathVariable("bossId") String bossId, Model model) {

		BossDTO bDto = bService.updateUI(bossId);

		model.addAttribute("bDto", bDto);

		return "/boss/update";
	}

	@RequestMapping(value = "/boss/read/{bossId}", method = RequestMethod.GET)
	public String bossRead(@PathVariable("bossId") String bossId, Model model) {

		BossDTO bDto = bService.read(bossId);

		model.addAttribute("bDto", bDto);

		return "/boss/read";
	}

	@RequestMapping(value = "/boss/list", method = RequestMethod.GET)
	public String bossList(Model model) {
		List<BossDTO> bList = bService.list();

		model.addAttribute("bList", bList);

		return "/boss/list";
	}

	@RequestMapping(value = "/boss/insert", method = RequestMethod.POST)
	public String bossInsert(BossDTO bDto) {
		bService.insert(bDto);

		return "redirect:/boss/list";
	}

	@RequestMapping(value = "/boss/insert", method = RequestMethod.GET)
	public String bossInsert() {

		return "/boss/insert";
	}

	@ResponseBody
	@RequestMapping(value = "/user/emailCheck", method = RequestMethod.POST)
	public int checkEmail(HttpServletRequest req) throws Exception {
		String uEmail = req.getParameter("uEmail");
		int result = uService.checkEmail(uEmail);

		if (uEmail == "") {
			result = -1;
		}

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/user/nicknameCheck", method = RequestMethod.POST)
	public int checkNk(HttpServletRequest req) throws Exception {
		String uNickname = req.getParameter("uNickname");
		int result = uService.checkNk(uNickname);

		if (uNickname == "") {
			result = -1;
		}

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/user/userIdcheck", method = RequestMethod.POST)
	public int checkId(HttpServletRequest req) throws Exception {
		String userId = req.getParameter("userId");

		int result = uService.checkId(userId);

		if (userId == "") {
			result = -1;
		}

		return result;
	}

	@RequestMapping(value = "/user/delete/{userId}", method = RequestMethod.POST)
	public String delete(@PathVariable("userId") String userId, Model model, HttpSession session) {

		UserDTO login = (UserDTO) session.getAttribute("login");

		if (!login.getUserId().equals(userId)) {
			return "redirect:/";
		}

		model.addAttribute("userId", userId);

		uService.delete(userId);

		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/user/modifyPw", method = RequestMethod.POST)
	public String modifyPw(UserDTO uDto) {
		
		uService.modifyPw(uDto);

		return "redirect:/";
	}

	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public String update(UserDTO uDto) {
		
		uService.update(uDto);

		return "redirect:/";
	}

	@RequestMapping(value = "/user/update/{userId}", method = RequestMethod.GET)
	public String update(@PathVariable("userId") String userId, Model model, HttpSession session) {

		UserDTO login = (UserDTO) session.getAttribute("login");

		if (!login.getUserId().equals(userId)) {
			return "redirect:/";
		}

		UserDTO uDto = uService.updateUI(userId);

		model.addAttribute("uDto", uDto);

		return "/user/update";
	}

	@RequestMapping(value = "/user/read/{userId}", method = RequestMethod.GET)
	public String read(@PathVariable("userId") String userId, Model model, HttpSession session) {

		UserDTO login = (UserDTO) session.getAttribute("login");

		if (!login.getUserId().equals(userId)) {
			return "redirect:/proudct/list";
		}

		UserDTO uDto = uService.read(userId);

		model.addAttribute("uDto", uDto);

		return "/user/read";
	}

	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public String list(Integer curpage, Model model) {

		// List<UserDTO> list = uService.list();
		if (curpage == null) {
			curpage = 1;
		}

		PageTO<UserDTO> pt = uService.list(curpage);
		model.addAttribute("list", pt.getList());
		model.addAttribute("pt", pt);

		// model.addAttribute("list", list);

		return "/user/list";
	}

	@RequestMapping(value = "/user/insert", method = RequestMethod.POST)
	public String insert(UserDTO uDto) {
		uService.insert(uDto);

		return "redirect:/user/list";
	}

	@RequestMapping(value = "/user/insert", method = RequestMethod.GET)
	public String insert() {

		return "/user/insert";
	}

}
