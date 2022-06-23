package kr.co.dw.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class QnaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int qno;
	private String userid;
	private String qTitle;
	private String qContent;
	private String qWriteDay;
	private String qUpdateDay;
	private List<String> filenameList;
	private int readCnt;
	
	public QnaDTO() {
		// TODO Auto-generated constructor stub
	}

	public QnaDTO(int qno, String userid, String qTitle, String qContent, String qWriteDay, String qUpdateDay, int readCnt) {
		super();
		this.qno = qno;
		this.userid = userid;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.qWriteDay = qWriteDay;
		this.qUpdateDay = qUpdateDay;
		this.readCnt = readCnt;
	}
	
	

	public QnaDTO(int qno, String userid, String qTitle, String qContent, String qWriteDay, String qUpdateDay,
			List<String> filenameList, int readcnt) {
		super();
		this.qno = qno;
		this.userid = userid;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.qWriteDay = qWriteDay;
		this.qUpdateDay = qUpdateDay;
		this.filenameList = filenameList;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getqContent() {
		return qContent;
	}

	public void setqContent(String qContent) {
		this.qContent = qContent;
	}

	public String getqWriteDay() {
		return qWriteDay;
	}

	public void setqWriteDay(String qWriteDay) {
		this.qWriteDay = qWriteDay;
	}

	public String getqUpdateDay() {
		return qUpdateDay;
	}

	public void setqUpdateDay(String qUpdateDay) {
		this.qUpdateDay = qUpdateDay;
	}

	
	
	public List<String> getFilenameList() {
		return filenameList;
	}

	public void setFilenameList(List<String> filenameList) {
		this.filenameList = filenameList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(qno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QnaDTO other = (QnaDTO) obj;
		return qno == other.qno;
	}

	@Override
	public String toString() {
		return "QnaDTO [qno=" + qno + ", userid=" + userid + ", qTitle=" + qTitle + ", qContent=" + qContent
				+ ", qWriteDay=" + qWriteDay + ", qUpdateDay=" + qUpdateDay + ", filenameList=" + filenameList
				+ ", readCnt=" + readCnt + "]";
	}

	
	
	
	
}
