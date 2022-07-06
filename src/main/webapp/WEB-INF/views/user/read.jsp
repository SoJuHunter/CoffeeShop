<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 보기</title>
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
html {
	height: 100%;
}

body {
	width: 100%;
	height: 100%;
	margin: 0;
	padding-top: 50px;
	padding-bottom: 40px;
	background-repeat: no-repeat;
}

.card {
	margin: 0 auto;
	float: none;
	margin-bottom: 10px;
	border: none;
}

.form-control {
	display: inline;
	height: 40px;
	width: 400px;
	padding: 5px;
	font-size: 16px;
	margin-left: 100px;
}

.check {
	font-size: 16px;
	margin-left: 100px;
}

.card-title {
	text-align: center;
}

.text {
	margin-left: 100px;
}

.links {
	text-align: center;
	margin-bottom: 10px;
}

a {
	color: #555555;
	text-decoration: none;
}
</style>
</head>
<body>
<body cellpadding="0" cellspacing="0" marginleft="0" margintop="0"
	width="100%" height="100%">
	<jsp:include page="../header.jsp" />
	<div class="card" style="width: 40rem;">
		<div class="card-title" style="margin-top: 30px;">

			<h2 class="card-title" style="color: #e4932b;">
				<img src="" />
			</h2>
		</div>
		<div class="card-body">
			<h5 align="center" class="nav-link text-uppercase font-weight-bold">${uDto.userId}님의
				회원 정보</h5>
			<br>
			<p class="text">아이디</p>
			<input name="userId" value="${uDto.userId}" class="form-control"
				readonly> &nbsp; &nbsp; <br> <br>

			<p class="text">이름</p>
			<input type="text" name="uName" value="${uDto.uName}"
				class="form-control"><br> <br />

			<p class="text">닉네임</p>
			<input type="text" name="uNickname" id="uNickname"
				value="${uDto.uNickname}" class="form-control"> <br> <br />

			<p class="text">생년월일</p>
			<input type="text" name="uBirth" id="uBirth" class="form-control"
				value="${uDto.uBirth}" placeholder="19001010 형식입니다."><br>
			<p id="birth_check" class="check"></p>
			<br />

			<p class="text">주소</p>
			<input type="text" class="text" id="uPostnumber" name="uPostnumber"
				placeholder="우편번호" value="${uDto.uPostnumber}" readonly> <input
				type="button" onclick="findAddr()" value="우편번호 찾기"><br>
			<input type="text" class="form-control" id="uAddress" name="uAddress"
				placeholder="지번주소" value="${uDto.uAddress}" readonly="readonly">
			<input type="text" class="form-control" id="udetailAddress"
				name="udetailAddress" value="${uDto.udetailAddress}"
				placeholder="상세주소"> <span id="guide"
				style="color: #999; display: none"></span> <br /> <br> <br>

			<p class="text">이메일</p>
			<input type="email" name="uEmail" id="uEmail" value="${uDto.uEmail}"
				class="form-control"> <br> <br />

			<p class="text">전화번호</p>
			<input type="text" name="uPhone" id="uPhone" value="${uDto.uPhone}"
				class="form-control"><br> <br> <br />

			<p class="text">등급</p>
			<input type="text" value="${uDto.uGrade}" class="form-control"><br>
			<br />

			<p class="text">포인트</p>
			<input type="text" value="${uDto.uPoint}" class="form-control"><br>
			<br />

			<form action=""></form>
			<div class="links">
				<a href="/user/update/${uDto.userId}">회원 정보 수정</a> | <a href="#">회원 강퇴</a>
			</div>


		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$("a:eq(1)").on("click", function() {
				$("form").attr("action", "/user/delete/${uDto.userId}");
				$("form").attr("method", "post");
				$("form").submit();
			});

		});
	</script>
</body>
</html>