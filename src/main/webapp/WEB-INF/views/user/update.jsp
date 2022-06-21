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
<form action="/user/update" method="post">
	아이디 :  <input readonly name="userId" value="${uDto.userId}"><br>
	비밀번호 : <input type="password" name="uPassword"><br>
	이름 :  <input name="uName" value="${uDto.uName}"><br>
	닉네임 : <input id="uNickname" name="uNickname" value="${uDto.uNickname}">&nbsp;<button type="button" onclick="nicknameCheckFn()">중복확인</button><br>
	생년월일 :<input readonly name="uBirth" value="${uDto.uBirth}"><br>
	우편번호 : <input id="uPostnumber" name="uPostnumber" value="${uDto.uPostnumber}">
			&nbsp;<button type="button" onclick="findAddr()">주소검색</button><br>
	주소 : <input id="uAddress" name="uAddress" value="${uDto.uAddress}"><br>
	상세주소 : <input name="udetailAddress" value="${uDto.udetailAddress}"><br>
	핸드폰번호 : <input name="uPhone" value="${uDto.uPhone}">&nbsp;<button>인증받기</button><br>
	이메일: <input name="uEmail" value="${uDto.uEmail}">&nbsp;<button>중복확인</button><br>
	등급: <input readonly name="uGrade" value="${uDto.uGrade}"><br>
	포인트:  <input readonly name="uPoint" value="${uDto.uPoint}"><br>
 	<input id="submit" type="submit" value="수정완료" disabled="disabled"> 

</form>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">

	function findAddr() {
		new daum.Postcode({
			
	    	oncomplete: function(data) {
	        	document.querySelector("#uPostnumber").value = data.zonecode;
	       	 	document.querySelector("#uAddress").value =  data.address;
	  		  }
			}).open();	
		}

	
	function nicknameCheckFn() {
		let uNickname = {uNickname : $("#uNickname").val()};
		
		
		$.ajax({
			url : '/user/nicknameCheck',
			type : 'post',
			data : uNickname,
			success : function(result) {
				if (result == 1) {
					alert("이미 사용중인 닉네임입니다.");
					$("#submit").attr('disabled','disabled');
				
				} else {
					alert("사용 가능한 닉네임입니다.");
					$("#submit").removeAttr('disabled');
				}
			}
			
			
		});
		
	}


	$(document).ready(function() {
		
	});


</script>
</body>
</html>