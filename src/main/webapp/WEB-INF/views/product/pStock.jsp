<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고 관리 페이지</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
	integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
	crossorigin="anonymous"></script>

<style type="text/css">
#uploadFile {
	width: 100%;
	height: 250px;
	border: 1px solid brown;
}
}
</style>

</head>
<body>

	<h1>상품 재고 관리</h1>
	<form action="/product/update" method="post">
		 <input type="hidden" name="pno" value="${pDto.pno}"> <br>
		 
		 <label for="pName">상품명</label>
	     <input name="pName" id="pName" value="${pDto.pName}"> <br>
		 
		 <label for=" pContent">상품정보</label>
		 <textarea name="pContent" id="pContent" rows="5">${pDto.pContent}</textarea>
		 <br>
	    
	     <label for="pStock">상품수량</label>
	     <input name="pStock" id="pStock" value="${pDto.pStock}"> <br>
	</form>

</body>
</html>