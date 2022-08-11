package kr.co.dw.domain;

import java.io.Serializable;
import java.util.Objects;

public class CartDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private int cartNum;
	private String userId;
	private int pno;
	private int cartStock;
	private String addDate;
	
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDTO(int cartNum, String userId, int pno, int cartStock, String addDate) {
		super();
		this.cartNum = cartNum;
		this.userId = userId;
		this.pno = pno;
		this.cartStock = cartStock;
		this.addDate = addDate;
	}

	public int getCartNum() {
		return cartNum;
	}

	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
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

	public int getCartStock() {
		return cartStock;
	}

	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartNum);
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
		return cartNum == other.cartNum;
	}

	@Override
	public String toString() {
		return "CartDTO [cartNum=" + cartNum + ", userId=" + userId + ", pno=" + pno + ", cartStock=" + cartStock
				+ ", addDate=" + addDate + "]";
	}
	
}
