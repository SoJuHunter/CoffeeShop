<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoffeeMall</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style type="text/css">
	#uploadFile {
		background-color: yellow;
	}
</style>
</head>
<body>
	<h1>문의내용 작성</h1>
	
	<hr>


	<table>
			<tr>
				<td>작성자</td>
				<td><input id="userid" name="userid" required></td>
			</tr>
	
			<tr>
				<td>제목</td>
				<td><input id="qTitle" name="qTitle" required></td>
			</tr>
	
			<tr>
				<td>문의 내용</td>
				<td><textarea row="10" id="qContent" name="qContent" required></textarea></td>
			</tr>
		
		<tr>
			<td>파일첨부</td>
			<td><input id="file" type="file" multiple></td>
		</tr>

		<tr >
			<td><input id="btn_submit" type="submit" value="문의글 작성"></td>
			<td><input type="button" onclick="location.assign('/qna/list')" value="목록 보기"></td>
		</tr>

	</table>
	
	
<script type="text/javascript">
$(document).ready(function() {
	let formData = new FormData();
	let idx = 0;
	
	$("#btn_submit").click(function() {
		let userid = $("#userid").val();
		let qTitle = $("#qTitle").val();
		let qContent = $("#qContent").val();
		let fileNames = $("#file")[0].files;
		
		formData.append("userid", userid);
		formData.append("qTitle", qTitle);
		formData.append("qContent", qContent);
	
		for(let i in fileNames) {
			formData.append("file"+idx++, fileNames[i]);
		}

		
		$.ajax({
			type : "post",
			url : "/qna/insert",
			processData : false,
			contentType : false,
			data : formData,
			dataType : "text",
			success : function(bno) {
				location.assign("/qna/read/"+bno);
			}
			
			
		});
	});
	
	
	
	
});
</script>
</body>
</html>