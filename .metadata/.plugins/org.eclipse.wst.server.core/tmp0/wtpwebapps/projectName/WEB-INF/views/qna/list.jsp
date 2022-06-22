<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoffeeMall</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
<style type="text/css">
  .pageInfo{
      list-style : none;
      display: inline-block;
      margin: 50px 0 0 100px;      
  }
 
  .pageInfo li{
      float: left;
    font-size: 20px;
    margin-left: 18px;
    padding: 7px;
    font-weight: 500;
  }
 
 a:link {color:black; text-decoration: none;}
 a:visited {color:black; text-decoration: none;}
 a:hover {color:black; text-decoration: underline;}
</style>
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


	<div class="pageInfo_wrap">
		<div class="pageInfo_area">
			<ul id="pageInfo" class="pageInfo">
				<c:forEach var="num" begin="${pageMaker.startPage}"
					end="${pageMaker.endPage}">
					<li class=""pageInfo_btn ${pageMaker.cri.pageNum == num ? "active":"" }"><a href="${num}">${num}</a></li>
				</c:forEach>		
			</ul>
		</div>
	</div>


	<form id="moveForm" method="get">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
	</form>

	<button onclick="location.assign('/qna/insert')">글쓰기</button>

<script type="text/javascript">

	$(".pageInfo a").on("click", function(event) {
		event.preventDefault();
		$("#moveForm").find("input[name='pageNum']").val($(this).attr("href"));
		$("#moveForm").attr("action", "/qna/list");
		$("#moveForm").submit();
	});
</script>
</body>
</html>