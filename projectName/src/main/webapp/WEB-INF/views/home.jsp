<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>홈화면</title>
</head>
<body>
	<h1>홈화면 입니다</h1>
	<button onclick="location.assign('/qna/insert')">글쓰기</button>
	<button onclick="location.assign('/qna/list')">Q&A게시판 목록 이동</button>
</body>
</html>
