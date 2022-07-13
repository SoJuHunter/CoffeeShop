package kr.co.dw.repository;

import java.util.List;

import kr.co.dw.domain.CartDTO;
import kr.co.dw.domain.OrderDTO;
import kr.co.dw.domain.OrderItemDTO;
import kr.co.dw.domain.OrderPageItemDTO;
import kr.co.dw.domain.ProductDTO;

public interface OrderDAO {
	
	
	OrderPageItemDTO getProductInfo(int pno);
	
	OrderItemDTO getOrderInfo(int pno);
	
	int enrollOrder(OrderDTO oDto);
	
	int enrollOrderItem(OrderItemDTO oiDto);
	
	int deductStock(ProductDTO bDto);
	
	int orderCancel(String orderId);
	
	List<OrderItemDTO> getOrderItemInfo(String orderId);
	
	OrderDTO getOrder(String orderId);

	List<OrderItemDTO> myOrder(String userId);

	
}
