package kr.co.dw.domain;

import java.io.Serializable;
import java.util.Objects;

public class OrderItemDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	
	private String orderId;
	private int pno;
	private int cartCount;
	private int orderItemId;
	private int pPrice;
	private int totalPrice;
	
	public OrderItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItemDTO(String orderId, int pno, int cartCount, int orderItemId, int pPrice, int totalPrice) {
		super();
		this.orderId = orderId;
		this.pno = pno;
		this.cartCount = cartCount;
		this.orderItemId = orderItemId;
		this.pPrice = pPrice;
		this.totalPrice = totalPrice;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getCartCount() {
		return cartCount;
	}

	public void setCartCount(int cartCount) {
		this.cartCount = cartCount;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	//public void setTotalPrice(int totalPrice) {
	//	this.totalPrice = totalPrice;
	//}

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
		OrderItemDTO other = (OrderItemDTO) obj;
		return Objects.equals(orderId, other.orderId);
	}

	@Override
	public String toString() {
		return "OrderItemDTO [orderId=" + orderId + ", pno=" + pno + ", cartCount=" + cartCount + ", orderItemId="
				+ orderItemId + ", pPrice=" + pPrice + ", totalPrice=" + totalPrice + "]";
	}
	
	public void settingTotalPrice() {
		this.totalPrice = this.pPrice*this.cartCount;
	}
	
}
