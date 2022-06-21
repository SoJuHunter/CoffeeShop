<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의글 상세내용</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>Q&A 게시판</h1>
	<hr>
	
	<input type="hidden" name="qno" value="${qDto.qno}">
	
	<table>
		<tr>
			<td>작성자</td>
			<td>${qDto.userid}</td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td>${qDto.qTitle}</td>
		</tr>
		
		<tr>
			<td>내용</td>
			<td>${qDto.qContent}</td>
		</tr>
		
		<tr>
			<td>작성일</td>
			<td>${qDto.qWriteDay}</td>
		</tr>
		
		<tr>
			<td>수정일</td>
			<td>${qDto.qUpdateDay}</td>
		</tr>
	</table> 
	
	<hr>
	
	<h4>첨부파일 목록</h4>
	<div id="uploaditems"></div>
	
	<hr>
	
	<form action="" id="deleteForm"></form>
	
	<a>수정</a>
	<a href="#" id="btn_del">삭제</a>
	<a href="/qna/list">목록</a>
	
	<hr>
	
	<!-- 댓글 권한 없음  -->
	<div>
		<p>관리자에게만 작성 권한이 있습니다.</p>
	</div>
	
	<!-- 댓글 권한 있음(관리자 이상)  -->
	<div>			
			<textarea id="replyText" name="replyText"  style="width:100%; height:100px; resize:none" ></textarea>				
			
			<br>
				
			<button id="btn_submit_reply" style="margin:auto; display: block;">입력 완료</button>

			<hr>
			
			<h4>Comment</h4>
			
			
			<div id="replies"></div>
	</div>
	
	
	
<script type="text/javascript" src="/resources/js/template.js"></script>	
<script type="text/javascript">
	$(document).ready(function() {
		let qno = ${qDto.qno};
		
		getAllUpload(qno, $("#uploaditems"));
		
		$("#btn_del").on("click", function() {
			$("#deleteForm")
			.attr("action", "/qna/delete/${qDto.qno}")
			.attr("method", "post")
			.submit();
		});
		
		$("#btn_submit_reply").on("click", function() {
			let replyText = $("#replyText").val();
			
			alert(replyText);
			
			$.ajax({
				type : "post",
				url : "/qna/replies",
				data : {
					qno : qno,
					replyText : replyText
				},
				dataType : "text",
				success : function(result) {
					if(result == "SUCCESS") {
						getAllReply(qno, $("#replies"));
					} else {
						alert("입력 실패");
					}
					
				}
			});
		});
		
		getAllReply(qno, $("#replies"));
	});
</script>
</body>
</html>