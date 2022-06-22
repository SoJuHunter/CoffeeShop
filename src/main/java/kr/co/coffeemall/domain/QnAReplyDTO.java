package kr.co.coffeemall.domain;

import java.io.Serializable;
import java.util.Objects;

public class QnAReplyDTO implements Serializable{

	private int qno;
	private String replyText;
	private int rno;
	
	public QnAReplyDTO() {
		// TODO Auto-generated constructor stub
	}

	public QnAReplyDTO(int qno, String replyText, int rno) {
		super();
		this.qno = qno;
		this.replyText = replyText;
		this.rno = rno;
	}
	
	

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public String getReplyText() {
		return replyText;
	}

	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(rno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QnAReplyDTO other = (QnAReplyDTO) obj;
		return rno == other.rno;
	}

	@Override
	public String toString() {
		return "QnAReplyDTO [qno=" + qno + ", replyText=" + replyText + ", rno=" + rno + "]";
	}

	
	
	
	
	
}
