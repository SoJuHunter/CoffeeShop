<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoffeeMall</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>Q&A게시판</h1>
	
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.qno}</td>
				<td><a href="/qna/read/${dto.qno}">${dto.qTitle}</a></td>
				<td>${dto.userid}</td>
				<td>${dto.qWriteDay}</td>
				<td>${dto.readCnt}</td>
			</tr>
		</c:forEach>
	</table>
	
	<button onclick="location.assign('/qna/insert')">글쓰기</button>
</body>
</html>