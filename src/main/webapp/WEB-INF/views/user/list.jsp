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

.navbar .nav-link:hover, .navbar .nav-link:focus {
	color: #555;
	text-decoration: none;
}

.navbar .navbar-brand {
	color: #555;
}

/* Change navbar styling on scroll */
.navbar.active {
	background: black;
	box-shadow: 1px 2px 10px rgba(0, 0, 0, 0.1);
}

.navbar.active .nav-link {
	color: #555;
}

.navbar.active .nav-link:hover, .navbar.active .nav-link:focus {
	color: #fff;
	text-decoration: none;
}

.navbar.active .navbar-brand {
	color: #555;
}

@media ( max-width : 991.98px) {
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
	background-color: #fff;
}

.user-wrap {
	width: 100%;
	margin: 70px auto;
	position: relative;
}

.user-text {
	padding: 10px 20px;
	text-align: center;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	color: white;
}

th {
	margin-left: 30%;
	margin-right: 30%;
	background-color: #F7F7F7;
}

ul.pagination {
	float: left;
}
</style>
</head>
<body>

	<jsp:include page="../header.jsp" />
	<div class="user-wrap">
		<div class="user-text">
			<h1>회원목록</h1>
		</div>

	</div>
	<br>
	<br>
	<div class="body-wrap" align="center">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">회원 아이디</th>
					<th scope="col">회원 이름</th>
					<th scope="col">회원 닉네임</th>
					<th scope="col">회원 생년월일</th>
					<th scope="col">회원 가입일</th>
					<th scope="col">회원 등급</th>

				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="list">
					<tr>
						<td><a href="/user/read/${list.userId}">${list.userId}</a></td>
						<td>${list.uName}</td>
						<td><a href="/user/read/${list.userId}">${list.uNickname}</a></td>
						<td>${list.uBirth}</td>
						<td>${list.uSigndate}</td>
						<td>${list.uGrade}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item"><a class="page-link"
				href="/user/list?curpage=${pt.curPage <= 1? 1 :  pt.curPage-1}">Previous</a>
			</li>


			<c:forEach begin="${pt.beginPageNum}" end="${pt.finishPageNum}"
				var="page">
				<c:if test="${page == pt.curPage}">
					<li class="page-item active" aria-current="page"><a
						class="page-link" href="/user/list?curpage=${pt.curPage}">${page}</a>
					</li>
				</c:if>

				<c:if test="${page != pt.curPage}">
					<li class="page-item"><a class="page-link"
						href="/user/list?curpage=${page}">${page}</a></li>
				</c:if>
			</c:forEach>


			<li class="page-item"><a class="page-link"
				href="/user/list?curpage=${pt.curPage >= pt.totalPage? pt.totalPage : pt.curPage+1}">Next</a>
			</li>
		</ul>
	</nav>

	<form action="/user/search" method="get" target="_blank">
		<div class="input-group mb-3">
			<select name="criteria" class="form-control col-sm-2">
				<option selected>선택</option>
				<option value="userId">아이디</option>
				<option value="uNickname">닉네임</option>
				<option value="uGrade">등급</option>
			</select> <input class="form-control" name="keyword">
			<div class="input-group-append">
				<button type="submit" class="btn btn-secondary">검색</button>
			</div>
		</div>
	</form>


	<jsp:include page="../footer.jsp" />

	<script type="text/javascript">
		$(document).ready(function() {

		});
	</script>
</body>
</html>