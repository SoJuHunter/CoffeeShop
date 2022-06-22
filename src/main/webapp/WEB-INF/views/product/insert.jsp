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
      border: 1px solid brown;
   }

}
   

</style>
</head>
<body>
<h1>상품 정보 등록</h1>

<form action="/product/insert" method = "post"><br>
제품명  <input name = "pName" id = "pName"><br>
제품 설명 <textarea rows="5" name = "pContent" id = "pContent"></textarea><br>
가격 <input name = "pPrice" id = "pPrice" type = "number"><br>
재고 <input name = "pStock" id = "pStock" type = "number"><br>
종류  <select class="form-control" name="pCategory" id="pCategory">

               <option value="원두" selected="selected">원두</option>

               <option value="콜두부루">콜드부루</option>

               <option value = "블렉"> 블랙</option>

              </select> 

<br>
용량 <input name = "pSize" id = "pSize"><br>
원산지 <input name = "pOrigin" id = "pOrigin">

</form>



<div class="form-group">
   <div id="uploadFile" class="form-control text-center"></div>
</div>


<div id="uploadedItems" class="row row-cols-3">
</div>


<div class="form-group row">
   <input id="btn_submit" class="form-control btn btn-success col-sm-2 offset-sm-5" type="submit" value="제품 등록 완료">   
</div>



<p class="card-text">${pText}</p>



<script type="text/javascript" src="/resources/js/tl.js"></script>
<script type="text/javascript">

$(document).ready(function() {
   
   let formData  = new FormData();
   let idx = 0;
   
   

   
   

      $("#uploadFile").on("dragenter dragover", function(event) {
         event.preventDefault();
      });
      
      $("#uploadFile").on("drop", function(event) {
         event.preventDefault();
         
         let files = event.originalEvent.dataTransfer.files;
         let file = files[0];
         
         
         formData.append("file"+idx, file);
         
          let reader = new FileReader(); 
          
          reader.readAsDataURL(file);
         
         reader.onload = function(event) {
            let str = test2(event.target.result, file["name"], "file"+ idx++);
            
            $("#uploadedItems"). append(str); 
         }
         
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
      
      
   
   

   $("#btn_submit").click(function(event){
       event.preventDefault(); 
      
      let pName = $("#pName").val();
      let pContent = $("#pContent").val();
      let pPrice = $("#pPrice").val();
      let pCategory = $("#pCategory").val();
      let pStock = $("#pStock").val();
      let pSize = $("#pSize").val();
      let pOrigin = $("#pOrigin").val();
      
      formData.append("pName", pName);
      formData.append("pContent", pContent);
      formData.append("pPrice", pPrice);
      formData.append("pCategory", pPrice);
      formData.append("pStock", pStock);
      formData.append("pSize", pSize);
      formData.append("pOrigin", pOrigin);
      
      
      $.ajax({
         type : "post",
         url : "/product/insert",
         processData: false,
         contentType: false,
         data : formData,
         dataType : "text",
         success : function(pno) {
            location.assign("/product/read/"+pno);
            
      
         }   
            
      });
      
      
   });
   
});


</script>


</body>
</html>