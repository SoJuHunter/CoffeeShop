package kr.co.dw.domain;

import java.io.Serializable;
import java.util.Objects;

public class CartDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private int cartId;
	private String userId;
	private int pno;
	private int cartCount;
	private String pName;
	private int pPrice;
	private int totalPrice;
	
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDTO(int cartId, String userId, int pno, int cartCount, String pName, int pPrice, int totalPrice) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.pno = pno;
		this.cartCount = cartCount;
		this.pName = pName;
		this.pPrice = pPrice;
		this.totalPrice = totalPrice;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
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



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartDTO other = (CartDTO) obj;
		return cartId == other.cartId;
	}

	@Override
	public String toString() {
		return "CartDTO [cartId=" + cartId + ", userId=" + userId + ", pno=" + pno + ", cartCount=" + cartCount
				+ ", pName=" + pName + ", pPrice=" + pPrice + ", totalPrice=" + totalPrice + "]";
	}
	
	public void settingTotalPrice() {
		this.totalPrice = this.pPrice*this.cartCount;
	}
}
