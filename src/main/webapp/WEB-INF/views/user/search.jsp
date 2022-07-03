<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 검색 목록</title>
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
</head>
<body>
	<jsp:include page="../header.jsp" />
	<br>
	<br>
	<br>
	<br>


	<h1 class="text-center">회원 검색 목록</h1>
	<br>
	<br>


	<table class="table table-striped">
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

	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item"><a class="page-link" aria-label="Previous"
				href="/user/search?curpage=${pt.curPage <= 1? 1 :  pt.curPage-1}&criteria=${criteria}&keyword=${keyword}">Previous</a>
			</li>


			<c:forEach begin="${pt.beginPageNum}" end="${pt.finishPageNum}"
				var="page">
				<c:if test="${page == pt.curPage}">
					<li class="page-item" aria-current="page"><a class="page-link"
						href="/user/search?curpage=${pt.curPage}&criteria=${criteria}&keyword=${keyword}">${page}</a></li>
				</c:if>

				<c:if test="${page != pt.curPage}">
					<li class="page-item"><a class="page-link"
						href="/user/search?curpage=${page}&criteria=${criteria}&keyword=${keyword}">${page}</a></li>
				</c:if>
			</c:forEach>


			<li class="page-item"><a class="page-link"
				href="/user/search?curpage=${pt.curPage >= pt.totalPage? pt.totalPage : pt.curPage+1}&criteria=${criteria}&keyword=${keyword}">Next</a>
			</li>
		</ul>

		<div align="right">
			<a class="btn btn-secondary" href="/user/list">전체 회원 목록</a>
		</div>
	</nav>


	<jsp:include page="../footer.jsp" />


</body>
</html>