package kr.co.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dw.domain.OrderCancelDTO;
import kr.co.dw.domain.OrderDTO;
import kr.co.dw.domain.OrderItemDTO;
import kr.co.dw.domain.OrderPageItemDTO;


public interface OrderService {

	
	//List<OrderPageItemDTO> getProductInfo(List<OrderPageItemDTO> orders);
	
	//void order(OrderDTO oDto);
	
	//void orderCancel(OrderCancelDTO cDto);
	
	OrderDTO getOrder(String userId);

	List<OrderItemDTO> myOrder(String userId);
}
