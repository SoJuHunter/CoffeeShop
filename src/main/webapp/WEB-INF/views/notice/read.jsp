<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 자세히 보기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
</head>
<body>

   <h1 class="text-center">공지사항 자세히</h1>

  <div class="form-group row">
    <label for="nno" class="col-sm-2 col-form-label col-form-label-lg">글번호</label>
    <div class="col-sm-10">
      <input readonly class="form-control form-control-lg"  id="nno" value="${nDto.nno}">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="userId" class="col-sm-2 col-form-label col-form-label-lg">작성자</label>
    <div class="col-sm-10">
      <input readonly class="form-control form-control-lg"  id="userId" value="${nDto.userId}">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="nWritedate" class="col-sm-2 col-form-label col-form-label-lg">작성일</label>
    <div class="col-sm-10">
      <input readonly class="form-control form-control-lg"  id="nWritedate" value="${nDto.nWritedate}">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="nUpdatedate" class="col-sm-2 col-form-label col-form-label-lg">수정일</label>
    <div class="col-sm-10">
      <input readonly class="form-control form-control-lg"  id="nUpdatedate" value="${nDto.nUpdatedate}">
    </div>
  </div>

  <div class="form-group row">
    <label for="nTitle" class="col-sm-2 col-form-label col-form-label-lg">글제목</label>
    <div class="col-sm-10">
      <input readonly class="form-control form-control-lg"  id="nTitle" value="${nDto.nTitle}">
    </div>
  </div>
  

  
   <div class="form-group row">
    <label for="nContent" class="col-sm-2 col-form-label col-form-label-lg">내용</label>
     <div class="col-sm-10">
       <textarea readonly class="form-control" id="nContent" rows="5">${nDto.nContent}</textarea>
     </div>   
  </div>
  
  
  
 
<div id="uploadedItems" class="row row-cols-lg-3">
</div>


<a class="btn btn-warning" href="/notice/update/${nDto.nno}">수정</a> 
<a class="btn btn-danger delete" href="#">삭제</a> 
<a class="btn btn-info" href="/notice/list">목록</a>

<form action=""></form>

<script type="text/javascript" src="/resources/js/notice.js?ver=1"></script>
<script type="text/javascript">
   let nno = ${nDto.nno};
   $(function() {
	   
	   getAllUpload(nno, $("#uploadedItems"));
	   
	   
	      $(".delete").on("click", function() {
	         $("form")
	         .attr("action", "/notice/delete/${nDto.nno}")
	         .attr("method", "post")
	         .submit();
	      });
	      
	   
   
      
   });
</script>







</body>
</html>