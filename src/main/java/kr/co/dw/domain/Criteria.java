package kr.co.dw.domain;

public class Criteria {

	private int pageNum;
	private int amount;
	private int qno;
	private String keyword;
	
	

	public Criteria() {
		this(1, 10);
	}

	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getQno() {
      return qno;
	}

    public void setQno(int qno) {
      this.qno = qno;
    }
    
    public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

    @Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", qno=" + qno + ", keyword=" + keyword + "]";
	}


    
	
	
	
}
