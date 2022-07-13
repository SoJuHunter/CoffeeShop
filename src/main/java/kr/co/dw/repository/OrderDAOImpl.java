package kr.co.dw.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dw.domain.OrderDTO;
import kr.co.dw.domain.OrderItemDTO;
import kr.co.dw.domain.OrderPageItemDTO;
import kr.co.dw.domain.ProductDTO;

@Repository
public class OrderDAOImpl implements OrderDAO{
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "kr.co.dw.order";
	
	
	
	@Override
	public OrderPageItemDTO getProductInfo(int pno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".getProductInfo", pno);
	}



	@Override
	public OrderItemDTO getOrderInfo(int pno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".getOrderInfo", pno);
	}



	@Override
	public int enrollOrder(OrderDTO oDto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+".enrollOrder", oDto);
	}



	@Override
	public int deductStock(ProductDTO bDto) {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+".deductStock", bDto);
	}



	@Override
	public int enrollOrderItem(OrderItemDTO oiDto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+".enrollOrderItem", oiDto);
	}



	@Override
	public int orderCancel(String orderId) {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+".orderCancel", orderId);
	}



	@Override
	public List<OrderItemDTO> getOrderItemInfo(String orderId) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".getOrderItemInfo", orderId);
	}



	@Override
	public OrderDTO getOrder(String orderId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".getOrder", orderId);
	}



	@Override
	public List<OrderItemDTO> myOrder(String userId) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".myOrder", userId);
	}
	
}
