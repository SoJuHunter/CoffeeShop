package kr.co.dw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.dw.domain.OrderPageDTO;

@Controller
public class OrderController {

	@RequestMapping(value = "/order/{userId}", method = RequestMethod.GET)
	public void orderPageGet(@PathVariable("userId") String userId, OrderPageDTO opd, Model model) {
		System.out.println("userId : "+userId);
		System.out.println("orders :"+opd.getOrders());
	}
	
}
