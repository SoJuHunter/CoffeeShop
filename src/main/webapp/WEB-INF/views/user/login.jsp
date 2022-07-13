<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
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

<link rel="stylesheet" href="/resources/css/login.css" type="text/css">
</head>

<body cellpadding="0" cellspacing="0" marginleft="0" margintop="0"
	width="100%" height="100%" align="center">
	<jsp:include page="../header.jsp" />
	<div align="center">
		<div class="card align-middle" style="width: 25rem;">
			<div class="card-title" style="margin-top: 30px;">

				<h3 class="card-title" style="color: #555555;" align="left">
					&nbsp;&nbsp;&nbsp;회원 로그인</h3>
			</div>
			<form action="/user/login" method="post" name="login_frm">
				<div class="checkbox">
					<label> <input type="radio" name="mode" value="admin"
						onclick="window.location.href='/boss/loginget'"> 운영자
						&nbsp;&nbsp; <input type="radio" name="mode" value="admin"
						onclick="window.location.href='/admin/loginget'"> 관리자
						&nbsp;&nbsp; <input type="radio" name="mode" value="member"
						checked> 일반회원
					</label>
				</div>

				<div class="card-body">

					<input type="text" name="userId" id="userId" class="form-control"
						value="${LOGIN_COOKIE.getId.value}" placeholder="아이디" autofocus
						required><BR> <input type="password" name="uPassword"
						id="uPassword" class="form-control" placeholder="비밀번호" required><br>
					<input id="btn-Yes" class="btn btn-lg btn-primary btn-block"
						type="submit" value="로 그 인"> <br> <label
						for="useCookie"> <input type="checkbox" id="useCookie"
						name="useCookie" value="true"> 로그인유지
					</label>
				</div>
			</form>
		</div>
		<div class="links">
			<a href="/user/findidget">아이디 찾기</a> | <a href="/user/findpw">비밀번호
				찾기</a> | <a href="/user/insert">회원가입</a>

		</div>



		<br>
		<!-- <div style="line-height: 25%;"> -->


		<!-- 아래와같이 아이디를 꼭 써준다. -->
		<a id="naverIdLogin_loginButton" href="${url}"
			style="text-decoration: none;">
			<button id="btn-naver" class="btn btn-lg btn-primary btn-block"
				style="color: #FFFFFF;">
				<span>네이버로 로그인</span>
			</button>
		</a>
		<br>
		<a href="${urlKakao}" style="text-decoration: none;">
				<button id="btn-kakao" class="btn btn-lg btn-primary btn-block"
					style="color: #191919;">
					<span>카카오로 로그인</span>
				</button>
			</a>



	</div>

	<jsp:include page="../footer.jsp" />

	<script type="text/javascript"
		src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js"
		charset="utf-8"></script>
	<script type="text/javascript">
			let LOGIN_ERR_MSG = "${LOGIN_ERR_MSG}";
			if (LOGIN_ERR_MSG != "") {
				alert(LOGIN_ERR_MSG);
			}

			

		
		</script>
</body>
</html>