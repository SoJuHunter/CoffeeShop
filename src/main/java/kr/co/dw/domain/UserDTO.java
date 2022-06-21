package kr.co.dw.domain;

import java.io.Serializable;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userId;
	private String uName;
	private String uNickname;
	private String uPassword;
	private String uBirth;
	private String uPostnumber;
	private String uAddress;
	private String udetailAddress;
	private String uPhone;
	private String uEmail;
	private String uGrade;
	private String uSigndate;
	private int uPoint;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String userId, String uName, String uNickname, String uPassword, String uBirth, String uPostnumber,
			String uAddress, String udetailAddress, String uPhone, String uEmail, String uGrade, String uSigndate,
			int uPoint) {
		super();
		this.userId = userId;
		this.uName = uName;
		this.uNickname = uNickname;
		this.uPassword = uPassword;
		this.uBirth = uBirth;
		this.uPostnumber = uPostnumber;
		this.uAddress = uAddress;
		this.udetailAddress = udetailAddress;
		this.uPhone = uPhone;
		this.uEmail = uEmail;
		this.uGrade = uGrade;
		this.uSigndate = uSigndate;
		this.uPoint = uPoint;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuNickname() {
		return uNickname;
	}

	public void setuNickname(String uNickname) {
		this.uNickname = uNickname;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuBirth() {
		return uBirth;
	}

	public void setuBirth(String uBirth) {
		this.uBirth = uBirth;
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

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuGrade() {
		return uGrade;
	}

	public void setuGrade(String uGrade) {
		this.uGrade = uGrade;
	}

	public String getuSigndate() {
		return uSigndate;
	}

	public void setuSigndate(String uSigndate) {
		this.uSigndate = uSigndate;
	}

	public int getuPoint() {
		return uPoint;
	}

	public void setuPoint(int uPoint) {
		this.uPoint = uPoint;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uNickname == null) ? 0 : uNickname.hashCode());
		result = prime * result + ((uPassword == null) ? 0 : uPassword.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (uNickname == null) {
			if (other.uNickname != null)
				return false;
		} else if (!uNickname.equals(other.uNickname))
			return false;
		if (uPassword == null) {
			if (other.uPassword != null)
				return false;
		} else if (!uPassword.equals(other.uPassword))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", uName=" + uName + ", uNickname=" + uNickname + ", uPassword="
				+ uPassword + ", uBirth=" + uBirth + ", uPostnumber=" + uPostnumber + ", uAddress=" + uAddress
				+ ", udetailAddress=" + udetailAddress + ", uPhone=" + uPhone + ", uEmail=" + uEmail + ", uGrade="
				+ uGrade + ", uSigndate=" + uSigndate + ", uPoint=" + uPoint + "]";
	}



	
	
}
