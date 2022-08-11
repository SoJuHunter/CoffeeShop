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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>

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

body {
    min-height: 110vh;
    background-color:#fff;
}

#wrap {
  
  position: bottom;
  width: 100%; 
  background-color: #fff;
}

section {
  padding-bottom: 100px;
}

footer {
  width: 100%;
  height: 90px;
  bottom: 0px;
  position: absolute;
  border-top: 1px solid #c4c4c4;
  padding-top: 10px;
  color: #808080;
  font-size: 11px;
}

footer a {
  display: inline-block;
  margin: 0 20px 10px 20px;
  color: #808080; font-size: 11px;
}

footer a:visited {
  color: #808080;
}

footer p {
  margin-top: 0; margin-bottom: 0;   
}

footer p span {
  display: inline-block;
  margin-left: 20px;
}



@import url(//fonts.googleapis.com/css?family=Abril+Fatface|Droid+Serif:400,700,400italic,700italic);
html,body{
  height:100%
}
<!-- /* body {
  background: white;
  font-family: 'Droid Serif', serif;
}
 */
 
 .col-sm{
 
 margin-top: 100px;
   padding-bottom: 530px; 
 }
.blog-card1 {
  max-width: 400px;
  width:100%;
  height: 450px;
  position: absolute; 
  font-family: bold;
  color:#fff;
  top: 20%;
  right: 0;  
  left: 0;
  margin: 0 auto;
  overflow: hidden;
  border-radius: 0px;
  box-shadow: 0px 10px 20px -9px rgba(0, 0, 0, 0.5);
  text-align: center;
  transition:all 0.4s;
  background: url(/resources/img/원두.jpg) center no-repeat;
  background-size: 100%;
  
 
}
.blog-card1 a{ 
color:#fff;
  text-decoration:none;
  transition:all 0.2s
}
.blog-card1 .color-overlay1 {
  background: rgba(64, 84, 94,0.5);
  width: 450px;
  height: 530px;
  position: absolute;
  z-index: 10;
  top: 0;
  left: 0;
  transition: background 0.3s cubic-bezier(0.33, 0.66, 0.66, 1);
}
.blog-card1 .gradient-overlay1 {  
  background-image: linear-gradient(transparent 0%, rgba(0, 0, 0, 0.6) 21%);
  width: 450px;
  height: 530px;
  position: absolute;
  top: 350px;
  left: 0;
  z-index: 15;
}
.blog-card1:hover{
    box-shadow: 0px 18px 20px -9px rgba(0, 10, 30, 0.75);
}
.blog-card1:hover .card-info1 {
  opacity: 1;
  bottom: 100px;
}
.blog-card1:hover .color-overlay1 {
  background: rgba(64, 64, 70,0.8);
}
.blog-card1:hover .title-content1{
  margin-top:70px
}
.title-content1 {
  text-align: center;
  margin: 170px 0 0 0;
  position: absolute;
  z-index: 20;
  width: 100%;
  top: 0;
  left: 0;
  transition:all 0.6s
}

.blog-card1:hover h3:after{
 
  animation: changeLetter 0.3s 1 linear;
  width:80%
}

.blog-card1 h3,h1 {
  font-size: 1.9em;
  font-weight: 400;
  letter-spacing: 1px;
  font-family: 'Abril Fatface', serif;
  margin-bottom: 0;
  display:inline-block;
}
.blog-card1 h3 a{  
  text-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);  
  transition:all 0.2s
}
.blog-card1 h3 a:hover{
  text-shadow: 0px 8px 20px rgba(0, 0, 0, 0.95);
}
h3:after {
  content: " ";
  display: block; 
  width: 10%;
  height: 2px;
  margin: 20px auto;
  border: 0;
  background: #BDA26B;
  transition:all 0.2s
}

@keyframes changeLetter {
  0% {
    width: 10%;
  }
  100% {
    width: 80%;
  }
}

.intro1 {
  width: 170px;
  margin: 0 auto;
  color: #ddd;
  font-style: italic;
  line-height: 18px;
}
.intro1 a{
  color: #ddd
}
.intro1 a:hover{
  text-decoration:underline
}
.card-info1 {
   box-sizing: border-box;
  padding: 0;
  width: 100%;
  position: absolute;
  bottom: -40px;
  left: 0;
  margin: 0 auto;
  padding: 0 50px;
  font-style: 16px;
  line-height: 24px;
  z-index: 20;
  opacity: 0;
  transition: bottom 0.64s, opacity 0.63s cubic-bezier(0.33, 0.66, 0.66, 1);
}

.card-info1 a{
  display:block;
  width:100px;
  margin:15px auto;
  background:#fff;
  color:#444;
  padding:3px 10px;
  border-radius:2px;
  font-size:0.8em
}
.card-info1 a:hover{
  background: #8e7c49;
  color:#fff;
}
.card-info1 a:hover span{
   filter: brightness(10);
   opacity:1
}

/* //카드 2번  -----------------------------------------------------------------------*/

.blog-card2 {
  max-width: 400px;
  width:100%;
  height: 450px;
  position: absolute;
  font-family: bold;
  color:#fff;
  top: 20%;
  right: 0;  
  left: 0;
  margin: 0 auto;
  overflow: hidden;
  border-radius: 0px;
  box-shadow: 0px 10px 20px -9px rgba(0, 0, 0, 0.5);
  text-align: center;
  transition:all 0.4s;
  background: url(/resources/img/콜드브루.jpg) center no-repeat;
  background-size: 100%;
 
}
.blog-card2 a{ 
color:#fff;
  text-decoration:none;
  transition:all 0.2s
}
.blog-card2 .color-overlay2 {
  background: rgba(64, 84, 94,0.5);
  width: 450px;
  height: 500px;
  position: absolute;
  z-index: 10;
  top: 0;
  left: 0;
  transition: background 0.3s cubic-bezier(0.33, 0.66, 0.66, 1);
}
.blog-card2 .gradient-overlay2 {  
  background-image: linear-gradient(transparent 0%, rgba(0, 0, 0, 0.6) 21%);
  width: 450px;
  height: 500px;
  position: absolute;
  top: 350px;
  left: 0;
  z-index: 15;
}
.blog-card2:hover{
    box-shadow: 0px 18px 20px -9px rgba(0, 10, 30, 0.75);
}
.blog-card2:hover .card-info2 {
  opacity: 1;
  bottom: 100px;
}
.blog-card2:hover .color-overlay2 {
  background: rgba(64, 64, 70,0.8);
}
.blog-card2:hover .title-content2{
  margin-top:70px
}
.title-content2 {
  text-align: center;
  margin: 170px 0 0 0;
  position: absolute;
  z-index: 20;
  width: 100%;
  top: 0;
  left: 0;
  transition:all 0.6s
}

.blog-card2:hover h3:after{
 
  animation: changeLetter 0.3s 1 linear;
  width:80%
}

.blog-card2 h3,h1 {
  font-size: 1.9em;
  font-weight: 400;
  letter-spacing: 1px;
  font-family: 'Abril Fatface', serif;
  margin-bottom: 0;
  display:inline-block;
}
.blog-card2 h3 a{  
  text-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);  
  transition:all 0.2s
}
.blog-card2 h3 a:hover{
  text-shadow: 0px 8px 20px rgba(0, 0, 0, 0.95);
}
h3:after {
  content: " ";
  display: block; 
  width: 10%;
  height: 2px;
  margin: 20px auto;
  border: 0;
  background: #78EAFF;
  transition:all 0.2s
}

@keyframes changeLetter {
  0% {
    width: 10%;
  }
  100% {
    width: 80%;
  }
}

.intro2 {
  width: 170px;
  margin: 0 auto;
  color: #ddd;
  font-style: italic;
  line-height: 18px;
}
.intro2 a{
  color: #ddd
}
.intro2 a:hover{
  text-decoration:underline
}
.card-info2 {
   box-sizing: border-box;
  padding: 0;
  width: 100%;
  position: absolute;
  bottom: -40px;
  left: 0;
  margin: 0 auto;
  padding: 0 50px;
  font-style: 16px;
  line-height: 24px;
  z-index: 20;
  opacity: 0;
  transition: bottom 0.64s, opacity 0.63s cubic-bezier(0.33, 0.66, 0.66, 1);
}

.card-info2 a{
  display:block;
  width:100px;
  margin:15px auto;
  background:#fff;
  color:#444;
  padding:3px 10px;
  border-radius:2px;
  font-size:0.8em
}
.card-info2 a:hover{
  background: #8e7c49;
  color:#fff;
}
.card-info2 a:hover span{
   filter: brightness(10);
   opacity:1
}

/* //카드 3번  -----------------------------------------------------------------------*/

.blog-card3 {
  max-width: 400px;
  width:100%;
  height: 450px;
  position: absolute;
  font-family: bold;
  color:#fff;
  top: 20%;
  right: 0;  
  left: 0;
  margin: 0 auto;
  overflow: hidden;
  border-radius: 0px;
  box-shadow: 0px 10px 20px -9px rgba(0, 0, 0, 0.5);
  text-align: center;
  transition:all 0.4s;
  background: url(/resources/img/스틱.jpg) center no-repeat;
  background-size: 100%;
  float: right;
 
}
.blog-card3 a{ 
color:#fff;
  text-decoration:none;
  transition:all 0.2s
}
.blog-card3 .color-overlay3 {
  background: rgba(64, 84, 94,0.5);
  width: 450px;
  height: 500px;
  position: absolute;
  z-index: 10;
  top: 0;
  left: 0;
  transition: background 0.3s cubic-bezier(0.33, 0.66, 0.66, 1);
}
.blog-card3 .gradient-overlay3 {  
  background-image: linear-gradient(transparent 0%, rgba(0, 0, 0, 0.6) 21%);
  width: 450px;
  height: 500px;
  position: absolute;
  top: 350px;
  left: 0;
  z-index: 15;
}
.blog-card3:hover{
    box-shadow: 0px 18px 20px -9px rgba(0, 10, 30, 0.75);
}
.blog-card3:hover .card-info3 {
  opacity: 1;
  bottom: 100px;
}
.blog-card3:hover .color-overlay3 {
  background: rgba(64, 64, 70,0.8);
}
.blog-card3:hover .title-content3{
  margin-top:70px
}
.title-content3 {
  text-align: center;
  margin: 170px 0 0 0;
  position: absolute;
  z-index: 20;
  width: 100%;
  top: 0;
  left: 0;
  transition:all 0.6s
}

.blog-card3:hover h3:after{
 
  animation: changeLetter 0.3s 1 linear;
  width:80%
}

.blog-card3 h3,h1 {
  font-size: 1.9em;
  font-weight: 400;
  letter-spacing: 1px;
  font-family: 'Abril Fatface', serif;
  margin-bottom: 0;
  display:inline-block;
}
.blog-card3 h3 a{  
  text-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);  
  transition:all 0.2s
}
.blog-card3 h3 a:hover{
  text-shadow: 0px 8px 20px rgba(0, 0, 0, 0.95);
}
h3:after {
  content: " ";
  display: block; 
  width: 10%;
  height: 2px;
  margin: 20px auto;
  border: 0;
  background: #BDA26B;
  transition:all 0.2s
}

@keyframes changeLetter {
  0% {
    width: 10%;
  }
  100% {
    width: 80%;
  }
}

.intro3 {
  width: 170px;
  margin: 0 auto;
  color: #ddd;
  font-style: italic;
  line-height: 18px;
}
.intro3 a{
  color: #ddd
}
.intro3 a:hover{
  text-decoration:underline
}
.card-info3 {
   box-sizing: border-box;
  padding: 0;
  width: 100%;
  position: absolute;
  bottom: -40px;
  left: 0;
  margin: 0 auto;
  padding: 0 50px;
  font-style: 16px;
  line-height: 24px;
  z-index: 20;
  opacity: 0;
  transition: bottom 0.64s, opacity 0.63s cubic-bezier(0.33, 0.66, 0.66, 1);
}

.card-info3 a{
  display:block;
  width:100px;
  margin:15px auto;
  background:#fff;
  color:#444;
  padding:3px 10px;
  border-radius:2px;
  font-size:0.8em
}
.card-info3 a:hover{
  background: #8e7c49;
  color:#fff;
}
.card-info3 a:hover span{
   filter: brightness(10);
   opacity:1
}




</style>

</head>


<body>


<%@ include file="/WEB-INF/views/header.jsp" %>
 
<div class = "container">
<div class = "row">
<div class = "col-sm">
	<div class="blog-card1 spring-fever col-sm">
  <div class="title-content1">
    <h3><a href="/product/list/원두">Bean</a></h3>
    <div class="intro1">원두<a href="/product/list/원두"></a> </div>
  </div>
  <div class="card-info1">
    
    <a href="/product/list/원두">Shop<span class="licon icon-arr icon-black"></span></a>
  </div>

  <div class="gradient-overlay1"></div>
  <div class="color-overlay1"></div>
</div>
</div>


<div class = "col-sm">
<div class="blog-card2 spring-fever col-sm">
  <div class="title-content2">
    <h3><a href="/product/list/콜드브루">Cold Brew</a></h3>
    <div class="intro2">콜드브루<a href="/product/list/콜드브루"></a> </div>
  </div>
  <div class="card-info2">
   
    <a href="/product/list/콜드브루">Shop<span class="licon icon-arr icon-black"></span></a>
  </div>

  <div class="gradient-overlay2"></div>
  <div class="color-overlay2"></div>
</div>
</div>

<div class = "col-sm">
<div class="blog-card3 spring-fever col-sm">
  <div class="title-content3">
    <h3><a href="/product/list/핸드드립">Hand Drip</a></h3>
    <div class="intro3">핸드드립<a href="/product/list/핸드드립"></a> </div>
  </div>
  <div class="card-info3">
   
    <a href="/product/list/핸드드립">Shop<span class="licon icon-arr icon-black"></span></a>
  </div>

  <div class="gradient-overlay3"></div>
  <div class="color-overlay3"></div>
</div>

</div>

</div>
 
    </div>
     <div id='wrap'>
    	<section></section>
        <footer>
          <p>
              <span>저자 : 태주 컴퍼니</span><br/>
              <span>이메일 : COFFEEMALL@gmail.com</span><br/>
              <span>Copyright 2022. COFFEEMALL. All Rights Reserved.</span>
          </p>
      </footer>
    </div>
</body>

</html>
