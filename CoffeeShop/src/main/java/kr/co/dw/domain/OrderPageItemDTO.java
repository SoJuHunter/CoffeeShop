package kr.co.dw.domain;

import java.io.Serializable;

public class OrderPageItemDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int pno;
	private int pCount;
	private String pName;
	private int pPrice;
	private int totalPrice;
	
	public OrderPageItemDTO() {
		// TODO Auto-generated constructor stub
	}

	public OrderPageItemDTO(int pno, int pCount, String pName, int pPrice, int totalPrice) {
		super();
		this.pno = pno;
		this.pCount = pCount;
		this.pName = pName;
		this.pPrice = pPrice;
		this.totalPrice = totalPrice;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getpCount() {
		return pCount;
	}

	public void setpCount(int pCount) {
		this.pCount = pCount;
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

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderPageItemDTO other = (OrderPageItemDTO) obj;
		return pno == other.pno;
	}



	public void settingTotalPrice() {
		this.totalPrice = this.pPrice*this.pCount;
	}

	@Override
	public String toString() {
		return "OrderPageItemDTO [pno=" + pno + ", pCount=" + pCount + ", pName=" + pName + ", pPrice=" + pPrice
				+ ", totalPrice=" + totalPrice + "]";
	}
	
	
	
}
