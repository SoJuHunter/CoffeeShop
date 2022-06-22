package kr.co.dw.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.dw.domain.CartDTO;
import kr.co.dw.domain.UserDTO;
import kr.co.dw.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Inject
	private CartService cService;
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCart(CartDTO cDto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO)session.getAttribute("user");
		if (dto == null) {
			return "4";
		}
		int result = cService.addCart(cDto);
		return result+"";
	}
}
