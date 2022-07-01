<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
  <h5 class="my-0 mr-md-auto font-weight-normal">Company name</h5>
  <nav class="my-2 my-md-0 mr-md-3">
    <a class="p-2 text-dark" href="#">Features</a>
    <a class="p-2 text-dark" href="#">Enterprise</a>
    <a class="p-2 text-dark" href="/user/update/${login.userId}">내 정보 수정</a>
    
    
    <c:choose>
         <c:when test="${empty login}">
            <a class="p-2 text-dark" href="/user/loginget">login</a>
   </nav>
   <a class="btn btn-outline-primary" href="/user/insert">회원가입</a>
   </c:when>
   <c:otherwise>
  ${login.uNickname}님 환영합니다. <a class="p-2 text-dark" href="/user/logout">로그아웃</a>
   </nav>
   </c:otherwise>

   </c:choose>
</div>
