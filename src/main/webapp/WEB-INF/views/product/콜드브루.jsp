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

    
   

.navbar {
    transition: all 0.4s;
}
.navbar .nav-link {
    color: #555;
}

.navbar .nav-link:hover,
.navbar .nav-link:focus {
    color: #555;
    text-decoration: none;
}

.navbar .navbar-brand {
    color:#555;
}


/* Change navbar styling on scroll */
.navbar.active {
    background: #F5F5F5;
    box-shadow: 1px 2px 10px rgba(0, 0, 0, 0.1);
}

.navbar.active .nav-link {
    color: #555;
}

.navbar.active .nav-link:hover,
.navbar.active .nav-link:focus {
    color: #fff;
    text-decoration: none;
}

.navbar.active .navbar-brand {
    color: #555;
}

@media (max-width: 991.98px) {
    .navbar {
        background: #fff;
        
    }

    .navbar .navbar-brand, .navbar .nav-link {
        color: #555;
    }
}

.text-small {
    font-size: 0.9rem !important;
}
.row{



}

 .card-body {
	position: relative;
	height: 400px;
	cursor: pointer;
	overflow: hidden;
	box-shadow: 1px 1px 3px rgba(0,0,0,0.5);
	float: left;
	
}
.card {
height:350px;
margin:auto;
margin-top: 20px;


}
.card-body img {
	width: 100%;
	height: 100%;
	transition: all 0.3s ease-in-out;
}

.card-body:before {
	content: '';
	background: #BEEFFF;
	width: 0px; height: 3px;
	position: absolute; right: 20px; top: 20px;
	transition: all 0.35s ease;
}
.card-body:after {
	content: '';
	background: #BEEFFF;
	width: 3px; height: 0px;
	position: absolute; right: 20px; top: 20px;
	transition: all 0.35s ease;
}

.card-body .info {
	position: absolute; left: 0; bottom: 0;
	color: #000;
	width: 100%;
	padding: 15px;
	box-sizing: border-box;
	opacity: 0;
	transition: all 0.3s ease-in-out;
	pointer-events: none;
	
}
.card-body .info h3 {
	font-size: 24px;
	line-height: 40px;
	overflow: hidden; 
	white-space: nowrap;
	text-overflow: ellipsis;
	padding-bottom: 3px;
	text-align: center;
	
}
.card-body .info p {
	font-size: 16px;
	overflow: hidden; 
	white-space: nowrap;
	text-overflow: ellipsis;
	text-align: center;
}
.card-body:hover .info {
	opacity: 1;
	
}
.card-body:hover img {
	opacity: 0.2;
	
}
.card-body:hover:before {
	width: 60px;
	
	
}
.card-body:hover:after {
	height: 60px;
	
	
}

h1{
pointer-events: none;
}



/* CSS */
.beanbutton {
  font-size: 16px;
  font-weight: 200;
  letter-spacing: 1px;
  padding: 13px 20px 13px;
  outline: 0;
  border: 1px solid black;
  cursor: pointer;
  position: relative;
  background-color: rgba(0, 0, 0, 0);
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
}

.beanbutton:after {
  content: "";
  background-color: #CDA27D;
  width: 100%;
  z-index: -1;
  position: absolute;
  height: 100%;
  top: 7px;
  left: 7px;
  transition: 0.2s;
}

.beanbutton:hover:after {
  top: 0px;
  left: 0px;
}

@media (min-width: 768px) {
  .beanbutton {
    padding: 13px 50px 13px;
  }
}



.coldbutton {
  font-size: 16px;
  font-weight: 200;
  letter-spacing: 1px;
  padding: 13px 20px 13px;
  outline: 0;
  border: 1px solid black;
  cursor: pointer;
  position: relative;
  background-color: rgba(0, 0, 0, 0);
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
}

.coldbutton:after {
  content: "";
  background-color: #BEEFFF;
  width: 100%;
  z-index: -1;
  position: absolute;
  height: 100%;
  top: 7px;
  left: 7px;
  transition: 0.2s;
}

.coldbutton:hover:after {
  top: 0px;
  left: 0px;
}

@media (min-width: 768px) {
  .coldbutton {
    padding: 13px 50px 13px;
  }
}

.dripbutton {
  font-size: 16px;
  font-weight: 200;
  letter-spacing: 1px;
  padding: 13px 20px 13px;
  outline: 0;
  border: 1px solid black;
  cursor: pointer;
  position: relative;
  background-color: rgba(0, 0, 0, 0);
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
}

.dripbutton:after {
  content: "";
  background-color: #F4B4B4;
  width: 100%;
  z-index: -1;
  position: absolute;
  height: 100%;
  top: 7px;
  left: 7px;
  transition: 0.2s;
}

.dripbutton:hover:after {
  top: 0px;
  left: 0px;
}

@media (min-width: 768px) {
  .dripbutton {
    padding: 13px 50px 13px;
  }
}

h1{
text-align: center;

}

.pagination {

justify-content : center;

}
.coldlist-wrap {
	width: 100%;
	margin: 70px auto;
	position: relative;
}

.coldlist-wrap img {
	width: 100%;
	height: 400px;
	object-fit: cover;
}

.title {
	padding: 10px 20px;
	text-align: center;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	color: white;
	
}
	
	 
	</style>
</head>
<body>
<code> <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> </code>
<%@ include file="/WEB-INF/views/header.jsp" %>

	
	
			<div class="coldlist-wrap">
		<div class="title">
		<h1 style="font-size: 70px;">콜드브루</h1>
		</div>
		<div class="cold-image">
		<img src="/resources/img/콜드브루.webp">
		</div>
		
	</div>
	
		<form action="/product/search" method = "get" target="_blank">
	<div class="input-group mb-3">
	<select name = "criteria" class="form-control col-sm-2">
<option selected>검색 조건</option>
<option value= "pName">제품명</option>
<option value = "pContent">상세내용</option>
<option value = "pCategory">종류</option>
<option value = "pOrigin">원산지</option>

</select>
  <input class="form-control" name="keyword" placeholder="검색 키워드를 입력하세요" aria-label="검색 키워드를 입력하세요" aria-describedby="검색 키워드를 입력하세요">
  <div class="input-group-append">
    <button class="btn btn-info " type="submit">검색</button>
  </div>
</div>

</form>
	

   
                   <div style="text-align:center;">
                        <button class="beanbutton" onclick="location.href='/product/list/원두'">원두</button>&nbsp;&nbsp;
                        <button class="coldbutton" onclick = "location.href='/product/list/콜드브루'">콜드브루</button>&nbsp;&nbsp;
                        <button class="dripbutton" onclick ="location.href='/product/list/핸드드립'">핸드드립</button><br>    
                       
                    </div>
               
            
<c:if test="${not empty bossLogin.bossId}">    
<a href="/product/insert/">제품정보입력</a>
</c:if>
	<div id="uploadedItems" class="row row-cols-4"></div> 




	




<div class="container">
<div class="row">
<c:forEach items="${list}" var="pDto">
<div class="col-4">
     
                <div class="card">
                
                    <div class="card-body">
                    <a href="/product/read/${pDto.pno}">
                	     <img src="/displayfile?filename=${pDto.filenameList.get(0)}" class="card-img-top">
                	     </a>
                	    <div class="info">
                    		<h3>${pDto.pName}</h3>
                    		<p><fmt:formatNumber value="${pDto.pPrice}" pattern="#,###"/></p>
                    		 
                    	</div>
                    	
                    </div>

                    </div>
                <hr>
       <br><br><br>
         
</div>
</c:forEach>

</div>
</div>

<nav aria-label="...">
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="/product/list/콜드브루?curpage=${pt.curPage <= 1? 1: pt.curPage-1}">Previous</a>
    </li>
    
    <c:forEach begin="${pt.beginPageNum}" end="${pt.finishPageNum}" var="page">
       <c:if test="${page == pt.curPage}">
           <li class="page-item active" aria-current="page">
               <a class="page-link" href="/product/list/콜드브루?curpage=${pt.curPage}">${page}</a>
          </li>
       </c:if>
       
       <c:if test="${page != pt.curPage}">
            <li class="page-item">
            <a class="page-link" href="/product/list/콜드브루?curpage=${page}">${page}</a></li>
       </c:if>
       
    </c:forEach>
    
    
    
    <li class="page-item">
      <a class="page-link" href="/product/list/콜드브루?curpage=${pt.curPage >= pt.totalPage? pt.totalPage : pt.curPage+1}">Next</a>
    </li>
  </ul>
</nav>




	

	<form action=""></form>
	<script type="text/javascript" src="/resources/js/tl.js"></script>

    <%@ include file="/WEB-INF/views/footer.jsp" %>
     	 
     
</body>
</html>