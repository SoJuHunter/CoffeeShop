<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
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
	background: #CDA27D;
	width: 0px; height: 3px;
	position: absolute; right: 20px; top: 20px;
	transition: all 0.35s ease;
}
.card-body:after {
	content: '';
	background: #CDA27D;
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
.discription{
text-align: center;
font-size: medium;
}

.main-text{

margin-top: 100px;

/* border-bottom: 5px #e8e8fc solid; */
}

</style>
</head>
<body>

<jsp:include page="../header.jsp"/>

<div class="main-text">
<h1>검색 결과</h1>
</div>
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
                    		<p>${pDto.pPrice}</p>
                    		 
                    	</div>
                    	
                    </div>

                    </div>
                 <hr>
       <br><br><br>
              
</div>
</c:forEach>

</div>
</div>



	<script type="text/javascript" src="/resources/js/tl.js"></script>

     <%@ include file="/WEB-INF/views/footer.jsp" %> 


</body>
</html>