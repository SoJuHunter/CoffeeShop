package kr.co.dw.domain;

import java.util.ArrayList;
import java.util.List;

public class PageTO<T> {
         //page TO를 부를때 generic type을 사용할 수 있게끔 사용한거임.
   private int curPage;    // 현재페이지.      
   private int perPage = 10; // 한 페이지에 몇개씩 보여줄껀지에 대해 보여주는 변수
   private int perLine = 10; // 보여줄 페이지 개수.
   private int amount;      // 전체 양.
   
   private int totalPage;   // 전체페이지
   
   private int startNum;
   private int endNum;
   
   private int beginPageNum;
   private int finishPageNum;
   
   private List<T> list = new ArrayList<T>();
         
   public PageTO() {
      calculate();
   }

   public PageTO(int curPage) {
      this.curPage = curPage;
      calculate();
   }

   public int getCurPage() {
      return curPage;
   }

   public void setCurPage(int curPage) {
      this.curPage = curPage;
      calculate();
   }

   public int getPerPage() {
      return perPage;
   }

   public void setPerpage(int perPage) {
      this.perPage = perPage;
      calculate();
   }

   public int getPerLine() {
      return perLine;
   }

   public void setPerLine(int perLine) {
      this.perLine = perLine;
      calculate();
   }

   public int getAmount() {
      return amount;
   }

   public void setAmount(int amount) {
      this.amount = amount;
      calculate();
   }
   
   public int getTotalPage() {
      return totalPage;
   }

   public void setTotalPage(int totalPage) {
      this.totalPage = totalPage;
   }
   
   public int getStartNum() {
      return startNum;
   }

   public void setStartNum(int startNum) {
      this.startNum = startNum;
   }

   public int getEndNum() {
      return endNum;
   }

   public void setEndNum(int endNum) {
      this.endNum = endNum;
   }

   public int getBeginPageNum() {
      return beginPageNum;
   }

   public void setBeginPageNum(int beginPageNum) {
      this.beginPageNum = beginPageNum;
   }

   public int getFinishPageNum() {
      return finishPageNum;
   }

   public void setFinishPageNum(int finishPageNum) {
      this.finishPageNum = finishPageNum;
   }

   public List<T> getList() {
      return list;
   }

   public void setList(List<T> list) {
      this.list = list;
   }
   
   
   public void calculate() {
      totalPage = (amount-1) / perPage + 1;
      startNum = ((curPage -1)*perPage)+1;
      
      endNum = curPage * perPage;
      
      if(endNum > amount){
         endNum = amount;
      }
      
      beginPageNum = ((curPage-1)/perLine)*perLine + 1;
      
      finishPageNum = beginPageNum + perLine -1;
      if(finishPageNum > totalPage) {
         finishPageNum = totalPage;
      }
      
   }
   
}
