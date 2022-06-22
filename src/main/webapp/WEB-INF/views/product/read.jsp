<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 정보</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
</head>
<body>
<div class="jumbotron">

      <h1 class="text-center">제품 정보</h1>
   </div>
   
    <div id="uploadedItems" class="row row-cols-3"></div>
   제품번호 ${pDto.pno}
   <br> 제품명 ${pDto.pName}
   <br> 제품정보 ${pDto.pContent}
   <br> 가격 ${pDto.pPrice}
   <br> 재고량 ${pDto.pStock}
   <br> 종류 ${pDto.pCategory}
   <br> 용량 ${pDto.pSize}
   <br> 원산지 ${pDto.pOrigin}
   <br>
   <br>
   
   구매수량

<form name="form1" action="card/insert" method="post">
<input type="hidden" name = "pno" value="${pDto.pno}">
<select name = "amount">
<c:forEach begin= "1" end="10" var="i">
<option value = "${i}"> ${i}</option>
</c:forEach>
</select>&nbsp; 개
<br>
<br>
<input type = "submit" value = "장바구니에 담기">&nbsp;&nbsp;&nbsp; <input type = "submit" value = "바로 구매" >
</form>
 <br>
   


  

   <a href="/product/list">목록</a>
   <a href="/product/update/${pDto.pno}">수정</a>
   <a href = "#">삭제</a>
 
 
  
  
  

   <form action=""></form>

   <script type="text/javascript" src="/resources/js/tl.js"></script>
   <script type="text/javascript">
   let pno = ${pDto.pno};
   
    $(document).ready(function(){
   
   getAllUpload(pno, $("#uploadedItems"));   


   $("a:eq(2)").on("click", function() {
       $("form").attr("action", "/product/delete/${pDto.pno}");
       $("form").attr("method", "post");
           $("form").submit();
   }); 
});


</script>






</body>
</html>