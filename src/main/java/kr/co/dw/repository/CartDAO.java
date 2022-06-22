package kr.co.dw.repository;

import java.util.List;

import kr.co.dw.domain.CartDTO;

public interface CartDAO {

	public int addcart(CartDTO cDto);
	
	public int deleteCart(int cartid);
	
	public int modifyCount(CartDTO cDto);
	
	public List<CartDTO> getCart(String userId);
	
	public CartDTO checkCart(CartDTO cDto);
}
