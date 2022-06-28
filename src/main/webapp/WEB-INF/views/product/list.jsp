<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
   integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
   crossorigin="anonymous">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
   src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
   integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
   crossorigin="anonymous"></script>
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
   integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
   crossorigin="anonymous"></script>
   <style type="text/css">

.outlayer{
width: 50%;
height: 50%;
display: table;

}

.inner{
display: table-cell;
text-align: center;
padding: 24px;

}

 .container{
max-width:2000px;
display: grid;
grid-template-columns: repeat(auto-fil, mainmax(212px, 1fr));
grid-row-gap: 100px;
grid-column-gap: 100px;
margin: 0 auto;



} 
.card img{
height: 500px;
widrh: 200px;
margin-left-right: -34%

} 
   </style>
</head>
<body>
<jsp:include page="../common/header.jsp"/>

   <a href="/product/insert/">제품정보입력</a>

   <div class="jumbotron">
      <h1>제품 목록</h1>
   </div>

   <div id="uploadedItems" class="row row-cols-3"></div>





<%-- 
   <c:forEach items="${list}" var="pDto">
      <a href="/product/read/${pDto.pno}"> 
      <img src="/displayfile?filename=${pDto.filenameList.get(0)}">
      </a>

      <a href="/product/read/${pDto.pno}">${pDto.pno}</a>
      <br>
              <a href="/product/read/${pDto.pno}">${pDto.pName}</a>
               <br>
               <b>${pDto.pPrice}</b>
               <br>


   </c:forEach> --%>
   
   


 
<div class ="outlayer">
<div class = "inner">
<div class = "container">

     <c:forEach items="${list}" var="pDto">
    <div class ="card">
      <a href="/product/read/${pDto.pno}">${pDto.pno}
      <img src="/displayfile?filename=${pDto.filenameList.get(0)}"><br></a>
      
      <div class = "text"><br><br><br>
      <br><br>${pDto.pName}<br><br>
      ${pDto.pPrice}
     </div>
   </div>
    </c:forEach>


</div>
</div>
</div>
   


   
   

   <form action=""></form>
   <script type="text/javascript" src="/resources/js/tl.js"></script>

</body>
</html>