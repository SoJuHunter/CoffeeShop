package kr.co.dw.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.dw.domain.CartDTO;

@Repository
public class CartDAOImpl implements CartDAO{

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "kr.co.dw.cart";
	
	
	@Override
	public int addcart(CartDTO cDto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+".addcart", cDto);
	}

	@Override
	public int deleteCart(int cartid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCount(CartDTO cDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CartDTO> getCart(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDTO checkCart(CartDTO cDto) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
