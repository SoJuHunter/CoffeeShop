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
#uploadFile {
	width: 100%;
	height: 250px;
	border: 1px solid red;
}
</style>
</head>
<body>
	<div class="jumbotron">
		<h1 class="text-center">게시글등록</h1>
	</div>


	<form action="/notice/insert" method="post">
		<div class="form-group row">
			<label for="nTitle" class="col-sm-2 col-form-label col-form-label-lg">제목</label>
			<div class="col-sm-10">
				<input name="nTitle" class="form-control form-control-lg"
					id="nTitle" placeholder="제목">
			</div>
		</div>

		<div class="form-group row">
			<label for="userId" class="col-sm-2 col-form-label col-form-label-lg">작성자</label>
			<div class="col-sm-10">
				<input name="userId" class="form-control form-control-lg"
					id="userId" placeholder="작성자 입력">
			</div>
		</div>

		<div class="form-group row">
			<label for="nContent"
				class="col-sm-2 col-form-label col-form-label-lg">내용</label>
			<div class="col-sm-10">
				<textarea name="nContent" class="form-control" id="nContent"
					rows="5"></textarea>
			</div>
		</div>
	</form>


	<div class="form-group">
		<div id="uploadFile" class="form-control text-center"></div>
	</div>


	<div id="uploadedItems" class="row row-cols-1 row-cols-lg-3"></div>


	<div class="form-group row">
		<input type="submit"
			class="form-control btn btn-danger col-sm-4 offset-sm-4"
			value="게시글 등록 완료" id="btn_submit">
	</div>


	<script type="text/javascript" src="/resources/js/notice.js?ver=1"></script>
	<script type="text/javascript">
	
$(document).ready(function() {
	let formData = new FormData();
	let idx = 0;
	
	
	 $("#uploadedItems").on("click", ".btn_del_item", function() { 
		
		   let filekey =	$(this).attr("data-filekey");
	   
			formData.delete(filekey); 
			
			$(this).parent().parent().parent().remove(); 
			
		});
	   
	   
	   
	   $("#uploadFile").on("dragenter dragover", function(event) {
		      event.preventDefault(); 
		   });

		   $("#uploadFile").on("drop", function(event) {
		      event.preventDefault(); 
		      
		      let files = event.originalEvent.dataTransfer.files; 
		      
		      let file = files[0]; 
		      
		      
		      formData.append("file" + idx, file);
		      
		      let reader = new FileReader();
		      
		      reader.readAsDataURL(file);  
		      
		      reader.onload = function(event){
		         
		          let str  = test2(event.target.result, file["name"], "file" + idx++);
		      	 
		          
		          $("#uploadedItems").append(str);	
			}
				
	   });
	
	$("#btn_submit").click(function() {
		let userId = $("#userId").val();
		let nTitle = $("#nTitle").val();
		let nContent = $("#nContent").val();
		
		
		formData.append("userId", userId);
		formData.append("nTitle", nTitle);
		formData.append("nContent", nContent);
	

		
		$.ajax({
			type : "post",
			url : "/notice/insert",
			processData : false,
			contentType : false,
			data : formData,
			dataType : "text",
			success : function(nno) {
				location.assign("/notice/read/"+nno);
			}
			
			
		});
	});
	
	
	
	
});
</script>
</body>
</html>