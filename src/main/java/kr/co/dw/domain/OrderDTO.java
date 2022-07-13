package kr.co.dw.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OrderDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String orderId;
	private String receiver;
	private String userId;
	private String uPostnumber;
	private String uAddress;
	private String udetailAddress;
	private String orderState;
	private List<OrderItemDTO> orders;
	private int deliveryCost;
	private Date orderDate;
	
	//판매가(모든 상품 비용)
	private int ordersalePrice;
	//최종 판매비용
	private int orderFinalSalePrice;
	
	
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}




	public OrderDTO(String orderId, String receiver, String userId, String uPostnumber, String uAddress,
			String udetailAddress, String orderState, List<OrderItemDTO> orders, int deliveryCost, Date orderDate,
			int ordersalePrice, int orderFinalSalePrice) {
		super();
		this.orderId = orderId;
		this.receiver = receiver;
		this.userId = userId;
		this.uPostnumber = uPostnumber;
		this.uAddress = uAddress;
		this.udetailAddress = udetailAddress;
		this.orderState = orderState;
		this.orders = orders;
		this.deliveryCost = deliveryCost;
		this.orderDate = orderDate;
		this.ordersalePrice = ordersalePrice;
		this.orderFinalSalePrice = orderFinalSalePrice;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getReceiver() {
		return receiver;
	}


	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getuPostnumber() {
		return uPostnumber;
	}


	public void setuPostnumber(String uPostnumber) {
		this.uPostnumber = uPostnumber;
	}


	public String getuAddress() {
		return uAddress;
	}


	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}


	public String getUdetailAddress() {
		return udetailAddress;
	}


	public void setUdetailAddress(String udetailAddress) {
		this.udetailAddress = udetailAddress;
	}

	

	public int getDeliveryCost() {
		return deliveryCost;
	}


	public void setDeliveryCost(int deliveryCost) {
		this.deliveryCost = deliveryCost;
	}


	public String getOrderState() {
		return orderState;
	}


	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}


	public List<OrderItemDTO> getOrders() {
		return orders;
	}


	public void setOrders(List<OrderItemDTO> orders) {
		this.orders = orders;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public int getOrdersalePrice() {
		return ordersalePrice;
	}


	public void setOrdersalePrice(int ordersalePrice) {
		this.ordersalePrice = ordersalePrice;
	}


	public int getOrderFinalSalePrice() {
		return orderFinalSalePrice;
	}


	public void setOrderFinalSalePrice(int orderFinalSalePrice) {
		this.orderFinalSalePrice = orderFinalSalePrice;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(orderId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDTO other = (OrderDTO) obj;
		return Objects.equals(orderId, other.orderId);
	}


	
	
	
	

	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", receiver=" + receiver + ", userId=" + userId + ", uPostnumber="
				+ uPostnumber + ", uAddress=" + uAddress + ", udetailAddress=" + udetailAddress + ", orderState="
				+ orderState + ", orders=" + orders + ", deliveryCost=" + deliveryCost + ", orderDate=" + orderDate
				+ ", ordersalePrice=" + ordersalePrice + ", orderFinalSalePrice=" + orderFinalSalePrice + "]";
	}




	public void getOrderPriceInfo() {
		for(OrderItemDTO oDto : orders) {
			ordersalePrice += oDto.getTotalPrice();
		}
			//if(ordersalePrice >= 20000) {
			//	deliveryCost = 0;
			//}else {
			//	deliveryCost = 3000;
			//}
			if(ordersalePrice <= 100000) {
				deliveryCost = 0;
			}else {
				deliveryCost = 3000;
			}
			//orderFinalSalePrice = ordersalePrice + deliveryCost;
			orderFinalSalePrice = ordersalePrice + deliveryCost;
	}
	
	
	/*
	 * public void getOrderPriceInfo() { for(OrderItemDTO oDto : orders) {
	 * ordersalePrice += oDto.getTotalPrice(); } if(ordersalePrice >= 30000) {
	 * deliveryCost = 0; }else { deliveryCost = 3000; }
	 * 
	 * //orderFinalSalePrice = ordersalePrice + deliveryCost; orderFinalSalePrice =
	 * ordersalePrice + deliveryCost; }
	 */
	
	
	
}
