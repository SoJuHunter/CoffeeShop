package kr.co.dw.domain;

import java.io.Serializable;
import java.util.Objects;

public class BossDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String bossId;
	private String bName;
	private String bNickname;
	private String bPassword;
	private String bBirth;
	private String bPostnumber;
	private String bAddress;
	private String bdetailAddress;
	private String bPhone;
	private String bEmail;
	private String bSigndate;

	public BossDTO() {
		// TODO Auto-generated constructor stub
	}

	public BossDTO(String bossId, String bName, String bNickname, String bPassword, String bBirth, String bPostnumber,
			String bAddress, String bdetailAddress, String bPhone, String bEmail, String bSigndate) {
		super();
		this.bossId = bossId;
		this.bName = bName;
		this.bNickname = bNickname;
		this.bPassword = bPassword;
		this.bBirth = bBirth;
		this.bPostnumber = bPostnumber;
		this.bAddress = bAddress;
		this.bdetailAddress = bdetailAddress;
		this.bPhone = bPhone;
		this.bEmail = bEmail;
		this.bSigndate = bSigndate;
	}

	public String getBossId() {
		return bossId;
	}

	public void setBossId(String bossId) {
		this.bossId = bossId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbNickname() {
		return bNickname;
	}

	public void setbNickname(String bNickname) {
		this.bNickname = bNickname;
	}

	public String getbPassword() {
		return bPassword;
	}

	public void setbPassword(String bPassword) {
		this.bPassword = bPassword;
	}

	public String getbBirth() {
		return bBirth;
	}

	public void setbBirth(String bBirth) {
		this.bBirth = bBirth;
	}

	public String getbPostnumber() {
		return bPostnumber;
	}

	public void setbPostnumber(String bPostnumber) {
		this.bPostnumber = bPostnumber;
	}

	public String getbAddress() {
		return bAddress;
	}

	public void setbAddress(String bAddress) {
		this.bAddress = bAddress;
	}

	public String getBdetailAddress() {
		return bdetailAddress;
	}

	public void setBdetailAddress(String bdetailAddress) {
		this.bdetailAddress = bdetailAddress;
	}

	public String getbPhone() {
		return bPhone;
	}

	public void setbPhone(String bPhone) {
		this.bPhone = bPhone;
	}

	public String getbEmail() {
		return bEmail;
	}

	public void setbEmail(String bEmail) {
		this.bEmail = bEmail;
	}

	public String getbSigndate() {
		return bSigndate;
	}

	public void setbSigndate(String bSigndate) {
		this.bSigndate = bSigndate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bNickname, bPassword, bossId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BossDTO other = (BossDTO) obj;
		return Objects.equals(bNickname, other.bNickname) && Objects.equals(bPassword, other.bPassword)
				&& Objects.equals(bossId, other.bossId);
	}

	@Override
	public String toString() {
		return "BossDTO [bossId=" + bossId + ", bName=" + bName + ", bNickname=" + bNickname + ", bPassword="
				+ bPassword + ", bBirth=" + bBirth + ", bPostnumber=" + bPostnumber + ", bAddress=" + bAddress
				+ ", bdetailAddress=" + bdetailAddress + ", bPhone=" + bPhone + ", bEmail=" + bEmail + ", bSigndate="
				+ bSigndate + "]";
	}
	
	
}
