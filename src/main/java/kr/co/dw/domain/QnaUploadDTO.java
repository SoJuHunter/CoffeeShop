package kr.co.dw.domain;

import java.io.Serializable;
import java.util.Objects;

public class QnaUploadDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private int qno;
	private String fileName;
	
	public QnaUploadDTO() {
		// TODO Auto-generated constructor stub
	}

	public QnaUploadDTO(int qno, String fileName) {
		super();
		this.qno = qno;
		this.fileName = fileName;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fileName, qno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QnaUploadDTO other = (QnaUploadDTO) obj;
		return Objects.equals(fileName, other.fileName) && qno == other.qno;
	}

	@Override
	public String toString() {
		return "QnaUploadDTO [qno=" + qno + ", fileName=" + fileName + "]";
	}
	
	
}
