package kr.co.dw.domain;

import java.io.Serializable;
import java.util.Objects;

public class AdminDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String adminId;
	private String aName;
	private String aNickname;
	private String aPassword;
	private String aBirth;
	private String aPostnumber;
	private String aAddress;
	private String adetailAddress;
	private String aPhone;
	private String aEmail;
	private String aSigndate;

	public AdminDTO() {
		// TODO Auto-generated constructor stub
	}

	public AdminDTO(String adminId, String aName, String aNickname, String aPassword, String aBirth, String aPostnumber,
			String aAddress, String adetailAddress, String aPhone, String aEmail, String aSigndate) {
		super();
		this.adminId = adminId;
		this.aName = aName;
		this.aNickname = aNickname;
		this.aPassword = aPassword;
		this.aBirth = aBirth;
		this.aPostnumber = aPostnumber;
		this.aAddress = aAddress;
		this.adetailAddress = adetailAddress;
		this.aPhone = aPhone;
		this.aEmail = aEmail;
		this.aSigndate = aSigndate;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaNickname() {
		return aNickname;
	}

	public void setaNickname(String aNickname) {
		this.aNickname = aNickname;
	}

	public String getaPassword() {
		return aPassword;
	}

	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}

	public String getaBirth() {
		return aBirth;
	}

	public void setaBirth(String aBirth) {
		this.aBirth = aBirth;
	}

	public String getaPostnumber() {
		return aPostnumber;
	}

	public void setaPostnumber(String aPostnumber) {
		this.aPostnumber = aPostnumber;
	}

	public String getaAddress() {
		return aAddress;
	}

	public void setaAddress(String aAddress) {
		this.aAddress = aAddress;
	}

	public String getAdetailAddress() {
		return adetailAddress;
	}

	public void setAdetailAddress(String adetailAddress) {
		this.adetailAddress = adetailAddress;
	}

	public String getaPhone() {
		return aPhone;
	}

	public void setaPhone(String aPhone) {
		this.aPhone = aPhone;
	}

	public String getaEmail() {
		return aEmail;
	}

	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}

	public String getaSigndate() {
		return aSigndate;
	}

	public void setaSigndate(String aSigndate) {
		this.aSigndate = aSigndate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aName, aPassword, adminId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminDTO other = (AdminDTO) obj;
		return Objects.equals(aName, other.aName) && Objects.equals(aPassword, other.aPassword)
				&& Objects.equals(adminId, other.adminId);
	}

	@Override
	public String toString() {
		return "AdminDTO [adminId=" + adminId + ", aName=" + aName + ", aNickname=" + aNickname + ", aPassword="
				+ aPassword + ", aBirth=" + aBirth + ", aPostnumber=" + aPostnumber + ", aAddress=" + aAddress
				+ ", adetailAddress=" + adetailAddress + ", aPhone=" + aPhone + ", aEmail=" + aEmail + ", aSigndate="
				+ aSigndate + "]";
	}
	
	

}
