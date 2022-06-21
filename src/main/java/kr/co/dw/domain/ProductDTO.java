package kr.co.dw.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ProductDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	 private int pno;
	   private String pName;
	   private String pContent;
	   private int pPrice;
	   private int pStock;
	   private String pCategory;
	   private String pSize;
	   private String pOrigin;
	   private List<String> filenameList;

	   public ProductDTO() {
	      // TODO Auto-generated constructor stub
	   }
	   

	   
	   

	   public ProductDTO(int pno, String pName, String pContent, int pPrice, int pStock, String pCategory, String pSize,
	         String pOrigin) {
	      super();
	      this.pno = pno;
	      this.pName = pName;
	      this.pContent = pContent;
	      this.pPrice = pPrice;
	      this.pStock = pStock;
	      this.pCategory = pCategory;
	      this.pSize = pSize;
	      this.pOrigin = pOrigin;
	   }
	   
	   
	   





	   public ProductDTO(int pno, String pName, String pContent, int pPrice, int pStock, String pCategory, String pSize,
	         String pOrigin, List<String> filenameList) {
	      super();
	      this.pno = pno;
	      this.pName = pName;
	      this.pContent = pContent;
	      this.pPrice = pPrice;
	      this.pStock = pStock;
	      this.pCategory = pCategory;
	      this.pSize = pSize;
	      this.pOrigin = pOrigin;
	      this.filenameList = filenameList;
	   }


	   



	   public List<String> getFilenameList() {
	      return filenameList;
	   }





	   public void setFilenameList(List<String> filenameList) {
	      this.filenameList = filenameList;
	   }





	   public int getPno() {
	      return pno;
	   }

	   public void setPno(int pno) {
	      this.pno = pno;
	   }

	   public String getpName() {
	      return pName;
	   }

	   public void setpName(String pName) {
	      this.pName = pName;
	   }

	   public String getpContent() {
	      return pContent;
	   }

	   public void setpContent(String pContent) {
	      this.pContent = pContent;
	   }



	   public int getpPrice() {
	      return pPrice;
	   }

	   public void setpPrice(int pPrice) {
	      this.pPrice = pPrice;
	   }

	   public int getpStock() {
	      return pStock;
	   }

	   public void setpStock(int pStock) {
	      this.pStock = pStock;
	   }

	   public String getpCategory() {
	      return pCategory;
	   }

	   public void setpCategory(String pCategory) {
	      this.pCategory = pCategory;
	   }

	   public String getpSize() {
	      return pSize;
	   }

	   public void setpSize(String pSize) {
	      this.pSize = pSize;
	   }

	   public String getpOrigin() {
	      return pOrigin;
	   }

	   public void setpOrigin(String pOrigin) {
	      this.pOrigin = pOrigin;
	   }

	   public static long getSerialversionuid() {
	      return serialVersionUID;
	   }

	   @Override
	   public int hashCode() {
	      return Objects.hash(pno);
	   }

	   @Override
	   public boolean equals(Object obj) {
	      if (this == obj)
	         return true;
	      if (obj == null)
	         return false;
	      if (getClass() != obj.getClass())
	         return false;
	      ProductDTO other = (ProductDTO) obj;
	      return pno == other.pno;
	   }

	   @Override
	   public String toString() {
	      return "ProductDTO [pno=" + pno + ", pName=" + pName + ", pContent=" + pContent + ", pPrice=" + pPrice
	            + ", pStock=" + pStock + ", pCategory=" + pCategory + ", pSize=" + pSize + ", pOrigin=" + pOrigin + "]";
	   }


	

}
