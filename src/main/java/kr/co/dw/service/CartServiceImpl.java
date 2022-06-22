package kr.co.dw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dw.domain.CartDTO;
import kr.co.dw.repository.CartDAO;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDAO cDao;
	
	
	@Override
	public int addCart(CartDTO cDto) {
		// TODO Auto-generated method stub
		return cDao.addcart(cDto);
	}

}
