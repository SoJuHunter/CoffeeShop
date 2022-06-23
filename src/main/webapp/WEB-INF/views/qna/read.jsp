<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의글 상세내용</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
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
	
	<a href="/qna/update/${qDto.qno}">수정</a>
	<a href="#" id="btn_del">삭제</a>
	<a href="/qna/list">목록</a>
	
	<hr>
	
	<div>			
			<textarea id="replyText" name="replyText"  style="width:100%; height:100px; resize:none" ></textarea>				
			
			<br>
				
			<button id="btn_submit_reply" style="margin:auto; display: block;">입력 완료</button>

			<hr>
			
			<h4>Comment</h4>
			
			
			<div id="replies"></div>
	</div>
	
	<div class="modal fade" id="staticBackdrop" data-backdrop="static"
		data-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">답글 수정</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				
				<div class="modal-body">
					<div>
						<div id="update_rno" style="display:none;"></div>
					</div>
					
					<div>
						<label>수정내용</label> <br>
						<textarea id="update_replyText" rows="10" style="width:100%"></textarea>
					</div>
				</div>
				
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button id="reply_update_submit" type="button" class="btn btn-primary" data-dismiss="modal">수정완료</button>
				</div>
			</div>
		</div>
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
		
		$("#replies").on("click", ".btn_del", function() {
			let rno = $(this).attr("data-rno");
			
			$.ajax({
				type : "post",
				url : "/qna/replies/delete",
				data : {
					rno : rno
				},
				dataType : "text",
				success : function(result) {
					if(result == "SUCCESS") {
						getAllReply(qno, $("#replies"));
					}else {
						alert("삭제 실패");
					}
				}
			});
		});
		
		$("#replies").on("click", ".btn_update", function() {
			let rno = $(".rno").text();
			let replyText = $(".replyText").text();
			
			$("#update_rno").text(rno);
			$("#update_replyText").text(replyText);
			
			
			
		});
		
		$("#reply_update_submit").on("click", function() {
			let rno = $("#update_rno").text();
			let replyText = $("#update_replyText").val();
			
			$.ajax({
				type : "post",
				url : "/qna/replies/update",
				data : {
					rno : rno,
					replyText : replyText
				},
				dataType : "text",
				success : function(result) {
					if(result == "SUCCESS") {
						getAllReply(qno, $("#replies"));
					}else {
						alert("수정 실패");
					}
				}
				
				
			});
			
		});
		
		getAllReply(qno, $("#replies"));
	});
</script>
</body>
</html>