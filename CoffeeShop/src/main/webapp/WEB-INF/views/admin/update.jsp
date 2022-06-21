<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
</head>
<body>
<h1>내 정보 수정 </h1>
<form action="/admin/update" method="post">
	아이디 :  <input readonly name="adminId" value="${aDto.adminId}"><br>
	비밀번호 : <input type="password" name="aPassword"><br>
	이름 :  <input name="aName" value="${aDto.aName}"><br>
	닉네임 : <input name="aNickname" value=" ${aDto.aNickname}">&nbsp;<button>중복확인</button><br>
	생년월일 :<input readonly name="aBirth" value="${aDto.aBirth}"><br>
	우편번호 : <input id="aPostnumber" name="aPostnumber" value="${aDto.aPostnumber}">
			&nbsp;<button type="button" onclick="findAddr()">주소검색</button><br>
	주소 : <input id="aAddress" name="aAddress" value="${aDto.aAddress}"><br>
	상세주소 : <input name="adetailAddress" value="${aDto.adetailAddress}"><br>
	핸드폰번호 : <input name="aPhone" value="${aDto.aPhone}">&nbsp;<button>인증받기</button><br>
	이메일: <input name="aEmail" value="${aDto.aEmail}">&nbsp;<button>중복확인</button><br>
 	<input type="submit" value="수정완료"> 

</form>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">

	function findAddr() {
		new daum.Postcode({
			
	    	oncomplete: function(data) {
	        	document.querySelector("#aPostnumber").value = data.zonecode;
	       	 	document.querySelector("#aAddress").value =  data.address;
	  		  }
			}).open();	
		}


	$(document).ready(function() {
		
	});


</script>
</body>
</html>