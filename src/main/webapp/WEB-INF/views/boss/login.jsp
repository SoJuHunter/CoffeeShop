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
					&nbsp;&nbsp;&nbsp;관리자 로그인</h3>
			</div>
			<form action="/boss/login" method="post">
				<div class="checkbox">
					<input type="radio" name="mode" value="boss"
						checked> 운영자
					&nbsp;&nbsp; <label> <input type="radio" name="mode"
						value="admin" onclick="window.location.href='/admin/loginget'" > 관리자 &nbsp;&nbsp; <input
						type="radio" name="mode" value="member"
						onclick="window.location.href='/user/loginget'"> 일반회원
					</label>
				</div>

				<div class="card-body">

					<input type="text" name="bossId" id="bossId" class="form-control"
						value="${LOGIN_COOKIE.getId.value}" placeholder="운영자 아이디"
						autofocus required><BR> <input type="password"
						name="bPassword" id="bPassword" class="form-control"
						placeholder="운영자 비밀번호" required><br> <input
						id="btn-Yes" class="btn btn-lg btn-primary btn-block"
						type="submit" value="운 영 자 로 그 인"> <br> <label
						for="useCookie"> <input type="checkbox" id="useCookie"
						name="useCookie" value="true"> 로그인유지
					</label>
				</div>
			</form>
		</div>
		<div class="links"></div>


	</div>
	</div>
	<jsp:include page="../footer.jsp" />


	<script
		src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js"
		charset="utf-8"></script>
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script type="text/javascript">
		let bossLOGIN_ERR_MSG = "${bossLOGIN_ERR_MSG}";
		if (bossLOGIN_ERR_MSG != "") {
			alert(bossLOGIN_ERR_MSG);
		}
	</script>
</body>
</html>