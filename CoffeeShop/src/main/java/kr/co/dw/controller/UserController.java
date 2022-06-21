package kr.co.dw.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.dw.domain.AdminDTO;
import kr.co.dw.domain.BossDTO;
import kr.co.dw.domain.UserDTO;
import kr.co.dw.service.AdminService;
import kr.co.dw.service.BossService;
import kr.co.dw.service.UserService;

@Controller
public class UserController {
	@Inject
	private UserService uService;
	
	@Inject
	private BossService bService;
	
	@Inject
	private AdminService aService;
	
	
	
	
	@RequestMapping(value = "/admin/delete/{adminId}", method = RequestMethod.POST)
		public String adminDelete(@PathVariable("adminId") String adminId) {
			aService.delete(adminId);
		
		return "redirect:/admin/list";
	}
	
	
	@RequestMapping(value = "/admin/update", method = RequestMethod.POST)
		public String adminUpdate(AdminDTO aDto) {
		
			aService.update(aDto);
		
		return "redirect:/admin/read/"+aDto.getAdminId();
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
		
		return "redirect:/boss/read/"+bDto.getBossId();
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
		public int checkEmail(HttpServletRequest req) throws Exception{
			String uEmail = req.getParameter("uEmail");
			int result = uService.checkEmail(uEmail);
			
		
		
		return result;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/user/nicknameCheck", method = RequestMethod.POST)
		public int checkNk(HttpServletRequest req) throws Exception{
			String uNickname = req.getParameter("uNickname");
			int result  = uService.checkNk(uNickname);
		
			return result;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/user/userIdcheck", method = RequestMethod.POST)
		public int checkId(HttpServletRequest req) throws Exception{
			String userId = req.getParameter("userId");
			int result = uService.checkId(userId);
		
		
		
		return result;
	}
	
	
	
	@RequestMapping(value = "/user/delete/{userId}", method = RequestMethod.POST)
		public String delete(@PathVariable("userId") String userId) {
			uService.delete(userId);
		
		return "redirect:/user/list";
	}
	
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
		public String update(UserDTO uDto) {
		
			uService.update(uDto);
		
		return "redirect:/user/read/"+uDto.getUserId();
	}
	
	
	@RequestMapping(value = "/user/update/{userId}", method = RequestMethod.GET)
	public String update(@PathVariable("userId") String userId, Model model) {
	
	UserDTO uDto = uService.updateUI(userId);
	
	model.addAttribute("uDto", uDto);
	
	return "/user/update";
}

	
	
	@RequestMapping(value = "/user/read/{userId}", method = RequestMethod.GET)
		public String read(@PathVariable("userId") String userId, Model model) {
		
		UserDTO uDto = uService.read(userId);
		
		model.addAttribute("uDto", uDto);
		
		return "/user/read";
	}
	
	
	
	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
		public String list(Model model) {
			List<UserDTO> list = uService.list();
			
			model.addAttribute("list", list);
			
		
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
