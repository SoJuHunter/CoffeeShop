<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 보기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
</head>
<body>
<h1>회원 정보 자세히 보기</h1>
	아이디 : ${aDto.adminId}<br>
	이름 : ${aDto.aName}<br>
	닉네임 : ${aDto.aNickname}<br>
	생년월일 : ${aDto.aBirth}<br>
	우편번호 : ${aDto.aPostnumber}<br>
	주소 : ${aDto.aAddress}<br>
	상세주소 : ${aDto.adetailAddress}<br>
	핸드폰번호 : ${aDto.aPhone}<br>
	이메일: ${aDto.aEmail}<br>


<form action=""></form>
<a href="/admin/update/${aDto.adminId}">내 정보 수정</a> 
<a href="#">탈퇴</a>

<script type="text/javascript">
$(document).ready(function() {
    $("a:eq(1)").on("click", function() {
        $("form").attr("action", "/admin/delete/${aDto.adminId}");
        $("form").attr("method", "post");
            $("form").submit();
    });

 });


</script>
</body>
</html>