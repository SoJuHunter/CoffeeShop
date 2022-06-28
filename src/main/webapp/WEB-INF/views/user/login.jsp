<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
</head>
<body>
<h1>로그인 화면</h1>

<form action="/user/login" method="post">
	ID : <input name="userId"><br>
	PW : <input name="uPassword" type="password"><br>
	<input type="submit" value="로그인 완료"> 
</form>


<a href="/user/findidget">아이디찾기</a> &nbsp; <a href="#">비밀번호찾기</a> &nbsp; <a href="/user/insert">회원가입</a>
<br>

<ul>
	<li onclick="kakaoLogin();">
      <a href="javascript:void(0)">
          <span>카카오 로그인</span>
      </a>
	</li>
	<li onclick="kakaoLogout();">
      <a href="javascript:void(0)">
          <span>카카오 로그아웃</span>
      </a>
	</li>
</ul>



<ul>
	<li>
      <!-- 아래와같이 아이디를 꼭 써준다. -->
      <a id="naverIdLogin_loginButton" href="javascript:void(0)">
          <span>네이버 로그인</span>
      </a>
	</li>
	<li onclick="naverLogout(); return false;">
      <a href="javascript:void(0)">
          <span>네이버 로그아웃</span>
      </a>
	</li>
</ul>




<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">


	Kakao.init('64404b4a1ac50344b8f24447db65f027');
	        
	console.log(Kakao.isInitialized()); // sdk초기화여부판단
	//카카오로그인
	function kakaoLogin() {
	  Kakao.Auth.login({
	    success: function (response) {
	      Kakao.API.request({
	        url: '/v2/user/me',
	        success: function (response) {
	      	  console.log(response)
	        },
	        fail: function (error) {
	          console.log(error)
	        },
	      })
	    },
	    fail: function (error) {
	      console.log(error)
	    },
	  })
	}
	
	

	
	
	//카카오로그아웃  
	function kakaoLogout() {
	  if (Kakao.Auth.getAccessToken()) {
	    Kakao.API.request({
	      url: '/v1/user/unlink',
	      success: function (response) {
	      	console.log(response)
	      },
	      fail: function (error) {
	        console.log(error)
	      },
	    })
	    Kakao.Auth.setAccessToken(undefined)
	  }
	}  


	
	
	
	let naverLogin = new naver.LoginWithNaverId(
			{
				clientId: "cgEyj_pEVPCOUSHCZW73", //내 애플리케이션 정보에 cliendId를 입력해줍니다.
				callbackUrl: "http://localhost:8900/user/list", // 내 애플리케이션 API설정의 Callback URL 을 입력해줍니다.
				isPopup: false,
				callbackHandle: true
			}
		);	

	naverLogin.init();

	window.addEventListener('load', function () {
		naverLogin.getLoginStatus(function (status) {
			if (status) {
				
				let email = naverLogin.user.getEmail(); // 필수로 설정할것을 받아와 아래처럼 조건문을 줍니다.
	    		
				console.log(naverLogin.user); 
	    		
	            if( email == undefined || email == null) {
					alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
					naverLogin.reprompt();
					return;
				}
			} else {
				console.log("callback 처리에 실패하였습니다.");
			}
		});
	});


	var testPopUp;
	function openPopUp() {
	    testPopUp= window.open("https://nid.naver.com/nidlogin.logout", "_blank", "toolbar=yes,scrollbars=yes,resizable=yes,width=1,height=1");
	}
	function closePopUp(){
	    testPopUp.close();
	}

	function naverLogout() {
		openPopUp();
		setTimeout(function() {
			closePopUp();
			}, 1000);
		
		
	}
	
	
	
	
	
	
	
	
	
	

	$(document).ready(function() {
		
	});


</script>
</body>
</html>