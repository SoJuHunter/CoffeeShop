<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>경영자 가입</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
</head>
<body>
<h1>CEO 가입 화면입니다</h1>
<form action="/boss/insert" method="post">
	ID :  <input name="bossId"><br>
	비밀번호 : <input name="bPassword" type="password"><br>
	이름 : <input name="bName"><br>
	닉네임 : <input name="bNickname"><br>
	생년월일 : <input name="bBirth" type="date"><br>
	우편번호 :<input id="bPostnumber" name="bPostnumber">&nbsp;<button type="button" onclick="findAddr()">주소검색</button><br>
	주소: <input  id="bAddress" name="bAddress"><br>
	상세주소: <input name="bdetailAddress"><br>
	핸드폰번호: <input name="bPhone"><br>
	이메일 : <input name="bEmail"><br>
	
	<input type="submit" value="회원가입완료">


</form>


<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
function findAddr() {
	new daum.Postcode({
		
	    oncomplete: function(data) {
	        document.querySelector("#bPostnumber").value = data.zonecode;
	         document.querySelector("#bAddress").value =  data.address;
	  		  }
		}).open();	
	}




	$(document).ready(function() {
		
	});


</script>
</body>
</html>