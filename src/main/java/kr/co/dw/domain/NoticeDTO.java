package kr.co.dw.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class NoticeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private int nno;
	private String userId;
	private String nTitle;
	private String nContent;
	private String nWritedate;
	private String nUpdatedate;
	private int readCnt;
	private List<String> filenameList;
	
	public NoticeDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public NoticeDTO(int nno, String userId, String nTitle, String nContent, String nWritedate, String nUpdatedate,
			int readCnt) {
		super();
		this.nno = nno;
		this.userId = userId;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nWritedate = nWritedate;
		this.nUpdatedate = nUpdatedate;
		this.readCnt = readCnt;
	}
	
	

	public NoticeDTO(int nno, String userId, String nTitle, String nContent, String nWritedate, String nUpdatedate,
			int readCnt, List<String> filenameList) {
		super();
		this.nno = nno;
		this.userId = userId;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nWritedate = nWritedate;
		this.nUpdatedate = nUpdatedate;
		this.readCnt = readCnt;
		this.filenameList = filenameList;
	}

	public int getNno() {
		return nno;
	}

	public void setNno(int nno) {
		this.nno = nno;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public String getnWritedate() {
		return nWritedate;
	}

	public void setnWritedate(String nWritedate) {
		this.nWritedate = nWritedate;
	}

	public String getnUpdatedate() {
		return nUpdatedate;
	}

	public void setnUpdatedate(String nUpdatedate) {
		this.nUpdatedate = nUpdatedate;
	}

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
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

	@Override
	public int hashCode() {
		return Objects.hash(nno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoticeDTO other = (NoticeDTO) obj;
		return nno == other.nno;
	}

	@Override
	public String toString() {
		return "NoticeDTO [nno=" + nno + ", userId=" + userId + ", nTitle=" + nTitle + ", nContent=" + nContent
				+ ", nWritedate=" + nWritedate + ", nUpdatedate=" + nUpdatedate + ", readCnt=" + readCnt + "]";
	}

	

}
