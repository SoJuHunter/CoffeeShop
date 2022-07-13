package kr.co.dw.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dw.domain.CartDTO;
import kr.co.dw.domain.OrderCancelDTO;
import kr.co.dw.domain.OrderDTO;
import kr.co.dw.domain.OrderItemDTO;
import kr.co.dw.domain.OrderPageItemDTO;
import kr.co.dw.domain.ProductDTO;
import kr.co.dw.domain.UserDTO;
import kr.co.dw.repository.OrderDAO;
import kr.co.dw.repository.ProductDAO;
import kr.co.dw.repository.UserDAO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO oDao;

	@Autowired
	private ProductDAO pDao;

	@Autowired
	private UserDAO uDao;

	/*
	 * @Override public List<OrderPageItemDTO> getProductInfo(List<OrderPageItemDTO>
	 * orders) { // TODO Auto-generated method stub List<OrderPageItemDTO> result =
	 * new ArrayList<OrderPageItemDTO>();
	 * 
	 * for(OrderPageItemDTO oDto : orders) { OrderPageItemDTO productInfo =
	 * oDao.getProductInfo(oDto.getPno());
	 * productInfo.setcartCount(oDto.getcartCount());
	 * productInfo.settingTotalPrice();
	 * 
	 * result.add(productInfo); } return result; }
	 * 
	 * @Override
	 * 
	 * @Transactional public void order(OrderDTO oDto) { // TODO Auto-generated
	 * method stub UserDTO user = uDao.getUserInfo(oDto.getUserId());
	 * List<OrderItemDTO> loiDto = new ArrayList<OrderItemDTO>(); for(OrderItemDTO
	 * oiDto : oDto.getOrders()) { OrderItemDTO orderItem =
	 * oDao.getOrderInfo(oiDto.getPno());
	 * orderItem.setCartCount(oiDto.getCartCount()); orderItem.settingTotalPrice();
	 * loiDto.add(orderItem); } oDto.setOrders(loiDto); oDto.getOrderPriceInfo();
	 * System.err.println("###"+oDto);
	 * 
	 * DB 주문,주문상품(,배송정보) 넣기 Date date = new Date(); SimpleDateFormat format = new
	 * SimpleDateFormat("_yyyyMMddmm"); String orderId = user.getUserId() +
	 * format.format(date); oDto.setOrderId(orderId);
	 * 
	 * db넣기 oDao.enrollOrder(oDto); for(OrderItemDTO oiDto : oDto.getOrders()) {
	 * oiDto.setOrderId(orderId); oDao.enrollOrderItem(oiDto);
	 * 
	 * } //재고 변동 for(OrderItemDTO oiDto : oDto.getOrders()) { ProductDTO pDto =
	 * pDao.getProductStock(oiDto.getPno());
	 * pDto.setpStock(pDto.getpStock()-oiDto.getCartCount());
	 * 
	 * oDao.deductStock(pDto); } for(OrderItemDTO oit : oDto.getOrders()) { CartDTO
	 * cDto = new CartDTO(); cDto.setUserId(oDto.getUserId());
	 * cDto.setPno(oit.getPno());
	 * 
	 * cDao.deleteOrderCart(cDto); }
	 * 
	 * }
	 */
	/*
	 * @Override
	 * 
	 * @Transactional public void orderCancel(OrderCancelDTO cDto) { // TODO
	 * Auto-generated method stub 주문, 주문상품 객체 회원 UserDTO user =
	 * uDao.getUserInfo(cDto.getuserId()); 주문상품 List<OrderItemDTO> ords =
	 * oDao.getOrderItemInfo(cDto.getOrderId()); for (OrderItemDTO ord : ords) {
	 * ord.settingTotalPrice(); } 주문 OrderDTO orw =
	 * oDao.getOrder(cDto.getOrderId()); orw.setOrders(ords);
	 * 
	 * orw.getOrderPriceInfo();
	 * 
	 * 주문상품 취소 DB oDao.orderCancel(cDto.getOrderId());
	 * 
	 * 재고 변환 for (OrderItemDTO ord : orw.getOrders()) { ProductDTO pDto =
	 * pDao.getProductStock(ord.getPno()); pDto.setpStock(pDto.getpStock() +
	 * ord.getCartCount()); oDao.deductStock(pDto); } }
	 */
	@Override
	public OrderDTO getOrder(String userId) {
		// TODO Auto-generated method stub
		return oDao.getOrder(userId);
	}

	@Override
	public List<OrderItemDTO> myOrder(String userId) {
		// TODO Auto-generated method stub
		return oDao.myOrder(userId);
	}

}
