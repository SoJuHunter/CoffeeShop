package kr.co.dw.service;

import org.springframework.stereotype.Service;

import kr.co.dw.domain.CartDTO;


public interface CartService {

	public int addCart(CartDTO cDto);

	

}
