<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
</head>
<body>
<h1>회원 가입 화면입니다</h1>
<form id="addForm" action="/user/insert" method="post">
<input type="hidden" id="userIdCheck" name="userIdCheck" value="N">
	ID :  <input id="userId" name="userId">&nbsp;<button type="button" id="userIdCheck" onclick="idCheckFn()">중복확인</button><br>
	비밀번호 : <input id="uPassword" name="uPassword" type="password" ><br>
	비밀번호 확인 : <input id="uPassword2" type="password"><br>
	<font id="checkPW"></font><br>
	이름 : <input name="uName"><br>
	닉네임 : <input id="uNickname" name="uNickname">&nbsp;<button type="button" onclick="nicknameCheckFn()">중복확인</button><br>
	생년월일 : <input name="uBirth" type="date"><br>
	우편번호 :<input id="uPostnumber" name="uPostnumber">&nbsp;<button type="button" onclick="findAddr()">주소검색</button><br>
	주소: <input id="uAddress" name="uAddress"><br>
	상세주소: <input id="udetailAddress" name="udetailAddress"><br>
	핸드폰번호: <input name="uPhone" placeholder="000-0000-0000"><br>
	이메일 : <input id="uEmail" name="uEmail">&nbsp;<button type="button" onclick="emailCheckFn()">중복확인</button><br>
	
	<input id="submit" type="submit" value="회원가입완료"> &nbsp; <input type="reset" value="가입취소" onclick="history.back()">


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
	
	
	function emailCheckFn() {
		let uEmail = {uEmail : $("#uEmail").val()};
		
		$.ajax({
			url : '/user/emailCheck',
			type : 'post',
			data : uEmail,
			success : function(result) {
				if (result == 1) {
					alert("이미 사용중인 이메일입니다.");
					 $("#submit").attr('disabled','disabled'); 
				
				} else {
					alert("사용 가능한 이메일입니다.");
					$("#submit").removeAttr('disabled');
					
				}
			}
			
			
		});
		
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

	

	
	function idCheckFn() {

		let userId  = {userId: $("#userId").val()};
		
		
		/*  if ($("addForm #userIdCheck").val()=='N') {
			alert("중복된 아이디입니다");
			$("#addForm #userId").focus();
			return;
		} */
		 
		
		$.ajax({
			url : '/user/userIdcheck',
			type : 'post',
			data : userId,
			success : function(result) {
				if (result == 1) {
					alert("이미 사용중인 아이디입니다.");
				
				} else {
					alert("사용 가능한 아이디입니다.");
					
				}
			}
			
			
		});
		
	}



	$(document).ready(function() {
		
			$('#uPassword').keyup(function() {
				$('#checkPW').html('');
			});
			
			$('#uPassword2').keyup(function() {
				if ($('#uPassword').val() != $('#uPassword2').val()) {
					$('#checkPW').html("비밀번호가 일치하지 않습니다");
					$('#checkPW').attr('color', 'red');
					
					return false;
					
				} else {
					$('#checkPW').html("비밀번호가 일치합니다");
					$('#checkPW').attr('color', 'blue');
					
				}
			});
		
	});


</script>
</body>
</html>