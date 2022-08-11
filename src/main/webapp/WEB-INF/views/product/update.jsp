<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
<style type="text/css">




	#uploadFile{
		width: 100%;
		height: 250px;
		border: 1px solid 	#CDA27D;
	}
	
	
	body{
	background-color: 	#CDA27D;
	}
	
	.product-form{

    width: 800px;
	height: 1600px;
	background-color: #f8f8ff;
	margin-left: auto;
	margin-right: auto;
	margin-top: 30px;
	margin-bottom: 30px;
	border-right: 5px;
	padding: 20px;
    margin-top: 150px;
}

.info{

font-weight: bold;
}
	
h1{
border-bottom: 5px solid 		#CDA27D;

}	


</style>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="product-form" style="border: 1px solid black;">
<form action="/product/update" method="post">
<div class="form-group">
		<h1 class="text-center">제품 정보 수정</h1>
	

    <!-- // 멀티파트, processData 관계성 --> 

	
		 <input type="hidden" name="pno" value="${pDto.pno}"> <br>
		 
		 <label  class="info" for="pName">상품명</label>
	     <input name="pName" id="pName" value="${pDto.pName}"> <br>
		 
		 <label for="pContent">상품정보</label>
		 <textarea name="pContent" id="pContent" rows="5">${pDto.pContent}</textarea>
		 <br>
	     
	     <label class="info" for="pPrice">상품가격</label> <input  name="pPrice" id="pPrice" value="${pDto.pPrice}">
	     <br>
	     <label class="info" for="pStock">상품수량</label>
	     <input  name="pStock" id="pStock" value="${pDto.pStock}"> <br>
	     
	     <label  class="info" for="pCategory">상품종류</label>
	     <select class="form-control" name="pCategory" id="pCategory">

               <option value="원두" selected="selected">원두</option>

               <option value="콜드브루">콜드브루</option>

               <option value = "핸드드립"> 핸드드립</option>

              </select><br>      
	     
	     <label class="info"  for="pSize">상품용량</label>
	      <select class="form-control" name="pSize" id="pSize">

					<option value="20g" selected="selected">20g</option>

					<option value="50g">50g</option>

					<option value = "70g"> 70g</option>

				  </select> <br>
	     
	     <label class="info" for="pOrigin">상품원산지</label>
	     <input  name="pOrigin" id="pOrigin" value="${pDto.pOrigin}"> <br>
	     
	     
	   </div> 
	</form>
	
	<div class="form-group">
	<div id="uploadFile" class="form-control text-center"></div>
</div>



<div id="uploadedItems" class="row row-cols-1 row-cols-3">
</div>


  <div class="form-group row">
    <input id="btn_submit" class="form-control btn btn-primary col-sm-2 offset-sm-5" type="submit" value="글 수정 완료">	
  </div>
  </div>
	 
<script type="text/javascript" src="/resources/js/tl.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			let pno = ${pDto.pno};
 
			let formData  = new FormData(); 
			

			let idx = 0;
			
			let deletFilenameArr = [];
			
			getAllUploadForUpdateUI(pno, $("#uploadedItems"));
			
			
			
			$("#uploadFile").on("dragenter dragover", function(event) {
				event.preventDefault();
			});
			
			$("#uploadFile").on("drop", function(event) {
				event.preventDefault();
				
				let files = event.originalEvent.dataTransfer.files;
				let file = files[0];
				
				formData.append("file"+ idx, file);
				
				let reader = new FileReader();
				reader.readAsDataURL(file);
				reader.onload = function(event) {
					let str = test2(event.target.result, file["name"], "file"+ idx++);
					$("#uploadedItems").append(str);
				};
				
			});
			
			
			$("#uploadedItems").on("click", ".btn_del_item", function() {
				let filename = $(this).attr("data-filename");
				
				if(filename == "new"){
					let filekey = $(this).attr("data-filekey");
					formData.delete(filekey);
				}else{
					deletFilenameArr.push(filename);
				}
				
				$(this).parent().parent().parent().remove();
			});
			
			
			$("#btn_submit").click(function() {
				formData.append("pno", pno);

				let pName = $("#pName").val();
				formData.append("pName", pName);

				let pContent = $("#pContent").val();
				formData.append("pContent", pContent);

				let pPrice = $("#pPrice").val();
				formData.append("pPrice", pPrice);
				
				let pStock = $("#pStock").val();
				formData.append("pStock", pStock);
				
				let pCategory = $("#pCategory").val();
				formData.append("pCategory", pCategory);
				
				let pSize = $("#pSize").val();
				formData.append("pSize", pSize);
				
				let pOrigin = $("#pOrigin").val();
				formData.append("pOrigin", pOrigin);

				formData.append("deletFilenameArr", deletFilenameArr);
				
				$.ajax({
					type : 'post',
					url : "/product/update",
					processData : false,
					contentType : false,
					data : formData,
					dataType : "text",
					success : function(result) {

						if (result == "SUCCESS") {
							location.assign("/product/read/" + pno);
						} else {
							alert("수정 실패");
						}
					}

				});
			});
		});
	</script>
</body>
</html>