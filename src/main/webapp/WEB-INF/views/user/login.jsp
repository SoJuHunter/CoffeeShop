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
<style type="text/css">



	
	html {
		height: 100%;
	}
	
	body {
	    width:100%;
	    height:100%;
	    margin: 0;
  		padding-top: 200px;
  		padding-bottom: 40px;
  		font-family: "Nanum Gothic", arial, helvetica, sans-serif;
  		background-repeat: no-repeat; 
  		}
  		
	.card {
        margin: 0 auto; /* Added */
        float: none; /* Added */
        margin-bottom: 10px; /* Added */
	}
		
    #btn-Yes{
        background-color: #555555;
        border: none;
    }
    
     #btn-kakao{
     	
        background-color: #FEE500; 
        border: none;
        width: 25rem;
    }
    
        #btn-naver{
     	
        background-color: #03C75A; 
        border: none;
        width: 25rem;
    }
	
	.login .form-control {
  		position: relative;
  		height: auto;
  		-webkit-box-sizing: border-box;
     	-moz-box-sizing: border-box;
        	 box-sizing: border-box;
  		padding: 10px;
  		font-size: 16px;
	}
    .checkbox{
        margin-right: 20px;
        text-align: right;
    }
    .card-title{
        margin-left: 30px;
    }

    .links{
        text-align: center;
        margin-bottom: 10px;
    }
    a{ 
    	color: #555555; 
    	text-decoration: none; 
    }
    .check{
    	color : red;
    }
	
	ul{
   list-style:none;
   }
	

</style>
</head>
<body>
<jsp:include page="../header.jsp"/>

  <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">

	<div class="card align-middle" style="width:25rem;">
		<div class="card-title" style="margin-top:30px;">
            
			<h2 class="card-title" style="color:#555555;"><img src=""/></h2>
		</div>
      <form action="/user/login" method="post">
        <div class="checkbox">
            <label>
            <input type="radio" name="mode" value="admin"> 관리자
			&nbsp;&nbsp;
			<input type="radio" name="mode" value="member" checked> 일반회원
            </label>
          </div>
		<div class="card-body">
  
        <input type="text" name="userId" id="userId" class="form-control" value="${LOGIN_COOKIE.getId.value}" placeholder="아이디" autofocus required><BR>
        <input type="password" name="uPassword" id="uPassword" class="form-control" placeholder="비밀번호"  required><br>
        <input id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit" value="로 그 인">
        <br>
        <label for="useCookie">
        <input type="checkbox" id="useCookie" name="useCookie"> 아이디 저장
        </label>
      </form>
    
		</div>
        <div class="links">
            <a href="/user/findidget">아이디 찾기</a> | <a href="/user/findpw">비밀번호 찾기</a> | <a href="/user/insert">회원가입</a>
           
			
			</ul>
      	  </div>
		</div>


		<br>
		<div style="line-height:25%;" align="center">
		<ul>
						<li onclick="kakaoLogin();">
					      <a href="javascript:void(0)" style="text-decoration: none;">
					     	<button id="btn-kakao" class="btn btn-lg btn-primary btn-block" style="color: #191919; ">
					          <span>카카오로 로그인</span>
					     	</button>
					      </a>
						</li>
						<!-- <li onclick="kakaoLogout();">
					      <a href="javascript:void(0)">
					          <span>카카오 로그아웃</span>
					      </a>
						</li> -->
		</ul>
		<br>
		<ul>
			<li>
		      <!-- 아래와같이 아이디를 꼭 써준다. -->
		      <a id="naverIdLogin_loginButton" href="javascript:void(0)" style="text-decoration: none;">
		      <button id="btn-naver" class="btn btn-lg btn-primary btn-block" style="color: #FFFFFF; ">
		          <span>네이버로 로그인</span>
		          </button>
		      </a>
			</li>
			<!-- <li onclick="naverLogout(); return false;">
		      <a href="javascript:void(0)">
		          <span>네이버 로그아웃</span>
		      </a>
			</li> -->
		</ul>
		</div>

${LOGIN_ERR_MSG}
<jsp:include page="../footer.jsp"/>


<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">

 	let LOGIN_ERR_MSG = "${LOGIN_ERR_MSG}";
 	if(LOGIN_ERR_MSG != ""){
		alert(LOGIN_ERR_MSG);
	}
 		 
	
	
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
	
	

	
	
	/* $('#btn-Yes').click(function() {

        var userId = $('#userId').val();

        var uPassword = $('#uPassword').val();

        $.ajax({

            type : "POST",

            url : "/user/login",

            data : {
            	"userId=" + userId, 
            	"uPassword=" + uPassword
            	},

            dataType : "text",

            success : function(data) {

               if (data == "FAIL") {

                    alert('로그인에 실패하였습니다.')
                 

                } else {

                    window.location.href = '/user/list';

                }

            },

            error : function(request, status, error) {

                alert("code:" + request.status + "\n" + "error:" + error);

            }

        })

});
 */

</script>
</body>
</html>