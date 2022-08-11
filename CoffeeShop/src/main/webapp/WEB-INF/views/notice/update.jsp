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
</head>
<body>
<div class="jumbotron">
<h1 class="text-center">게시글 수정</h1>
</div>



<form action="/notice/update" method="post">
<input type="hidden" name="nno" value="${nDto.nno}">
    <div class="form-group row">
    <label for="nTitle" class="col-sm-2 col-form-label col-form-label-lg">제목</label>
    <div class="col-sm-10">
      <input name="nTitle" class="form-control form-control-lg" id="title" value="${nDto.nTitle}">
    </div>
  </div>
  
   <div class="form-group row">
    <label for="userId" class="col-sm-2 col-form-label col-form-label-lg">작성자</label>
    <div class="col-sm-10">
      <input name="userId" class="form-control form-control-lg" id="userID"  value="${nDto.userId}">
    </div>
  </div>
  
   <div class="form-group row">
    <label for="nContent" class="col-sm-2 col-form-label col-form-label-lg">내용</label>
    <div class="col-sm-10">
    <textarea name="nContent" class="form-control" id="content" rows="5">${nDto.nContent}</textarea>
    </div>
  </div>

   <div class="form-group row">
    <input type="submit" class="form-control btn btn-danger col-sm-4 offset-sm-4" value="수정 완료">
  </div>
  
  
  
 
</form>

</body>
</html>