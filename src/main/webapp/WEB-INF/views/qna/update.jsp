<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>coffemall</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>문의글 수정</h1>
	<hr>

	<div style="display:none;">${qDto.qno}</div>
	<table>
		<tr>
			<td>작성자</td>
			<td><input id="userid" name="userid" required readonly value="${qDto.userid}"></td>
		</tr>

		<tr>
			<td>제목</td>
			<td><input id="qTitle" name="qTitle" value="${qDto.qTitle}" required></td>
		</tr>

		<tr>
			<td>문의 내용</td>
			<td><textarea row="10" id="qContent" name="qContent" required>${qDto.qContent}</textarea></td>
		</tr>

		<tr>
			<td>파일첨부</td>
			<td><input id="file" type="file" multiple></td>
		</tr>

		<tr>
			<td><input id="btn_update_submit" type="submit" value="문의글 수정"></td>
			<td><input type="button" onclick="location.assign('/qna/list')"
				value="목록 보기"></td>
		</tr>

	</table>
	
	<div id="uploadItems"></div>

<script type="text/javascript" src="/resources/js/template.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		let qno = ${qDto.qno};
		let formData = new FormData();
		let delFilenameArr = [];
		let idx = 0;

		getAllUploadForUpdateUI(qno, $("#uploadItems"));
		
		$("#uploadItems").on("click", ".del_update_btn", function() {
			let delFileName = $(this).attr("data-delfilename");
			
			delFilenameArr.push(delFileName);
		});
		

		$("#btn_update_submit").on("click", function() {
			let userid = $("#userid").val();
			let qTitle = $("#qTitle").val();
			let qContent = $("#qContent").val();
			let fileNames = $("#file")[0].files;
			
			for(let i in fileNames) {
				formData.append("file"+idx++, fileNames[i]);
			}
			
			formData.append("qno", qno);
			formData.append("userid", userid);
			formData.append("qTitle", qTitle);
			formData.append("qContent", qContent);
			formData.append("delFilenameArr", delFilenameArr);
	
			$.ajax({
				
				type : "post",
				url : "/qna/update",
				processData : false,
				contentType : false,
				data: formData,
				success: function(result) {
					
					if(result == "SUCCESS") {
						location.assign("/qna/read/"+qno);	
					}else {
						alert("수정 실패");	
					}
					
				}
			
			});
		});
	})

</script>
</body>
</html>