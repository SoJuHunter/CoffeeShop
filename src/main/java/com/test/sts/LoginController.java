package com.test.sts;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.scribejava.core.model.OAuth2AccessToken;

import kr.co.dw.domain.UserDTO;
import kr.co.dw.service.UserService;

@Controller
public class LoginController {
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	
	private KakaoLoginBO kakaoLoginBO;
	
	@Autowired
	UserService uService;
	
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}


	@Autowired
	private void setKakaoLoginBO(KakaoLoginBO kakaoLoginBO) {
		this.kakaoLoginBO = kakaoLoginBO;
	}


	//네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session, HttpServletRequest request)
			throws Exception {
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
        //로그인 사용자 정보를 읽어온다.
	    apiResult = naverLoginBO.getUserProfile(oauthToken);
	    model.addAttribute("result", apiResult); 

		JSONParser parser = new JSONParser();
        Object obj = parser.parse(apiResult);
        JSONObject jsonObj = (JSONObject)obj;
        JSONObject response_obj = (JSONObject)jsonObj.get("response");
		
        

		// 네이버에서 주는 고유 ID
         String naverId = (String) response_obj.get("id");
         // 네이버에서 설정된 사용자 이름
         String naverNickname = (String) response_obj.get("nickname");
         // 네이버에서 설정된 이메일
         String naverEmail = (String) response_obj.get("email");
		 
         String target ="@";
         int target_num = naverEmail.indexOf(target);
         //네이버 진짜 ID
         String newId=(String) naverEmail.substring(0,target_num);
         System.out.println(newId);
         
         UserDTO uDTO = new UserDTO();
         
  
         uDTO.setUserId(newId); //아이디
         uDTO.setuNickname(naverNickname); //닉네임
         uDTO.setuEmail(naverEmail); //이메일
        // uService.insertNV(uDTO);
         
         int result = uService.checkId(uDTO.getUserId());
       
         if (result == 0) {
        	 uService.insertNV(uDTO);
         }
			  UserDTO login = uService.nvlogin(uDTO);
			  model.addAttribute("login", login);
			  System.out.println("@@@@@@@@@"+login);
        /* 네이버 로그인 성공 페이지 View 호출 */	
			  return "home";
	}
	
	
	
	// 카카오 로그인 성공시 callback
		@RequestMapping(value = "/callbackKakao", method = { RequestMethod.GET, RequestMethod.POST })
		public String callbackKakao(UserDTO uDTO, Model model, @RequestParam String code, @RequestParam String state, HttpSession session) 
				throws Exception {
			System.out.println("로그인 성공 callbackKako");
			OAuth2AccessToken oauthToken;
			oauthToken = kakaoLoginBO.getAccessToken(session, code, state);	
			// 로그인 사용자 정보를 읽어온다
			apiResult = kakaoLoginBO.getUserProfile(oauthToken);
			model.addAttribute("result", apiResult);
			
			JSONParser parser = new JSONParser();
	        Object obj = parser.parse(apiResult);
	        JSONObject jsonObj = (JSONObject)obj;
	        
	      
			JSONObject response_obj = (JSONObject) jsonObj.get("kakao_account");	
			JSONObject response_obj2 = (JSONObject) response_obj.get("profile");
			
			/*
			 * // 프로필 조회 String email = (String) response_obj.get("email"); String name =
			 * (String) response_obj2.get("nickname");
			 */
			
			
	        
//	         // 카카오에서 설정된 사용자 이름
	         String kakaoNickname = (String) response_obj2.get("nickname");
	         // 카카오에서 설정된 이메일
	         String kakaoEmail = (String) response_obj.get("email");
	        
	         
	         System.out.println("!!!!!!!!!!!!"+kakaoEmail);
	         
	         System.out.println("@@@@@@@@@@"+kakaoNickname);
			
	         String target ="@";
	         int target_num = kakaoEmail.indexOf(target);
	         //네이버 진짜 ID
	         String newId=(String) kakaoEmail.substring(0,target_num);
	         
	         uDTO.setUserId(newId); //아이디
	         uDTO.setuNickname(kakaoNickname); //닉네임
	         uDTO.setuEmail(kakaoEmail); //이메일
	         
	         int result = uService.checkId(uDTO.getUserId());
	         
	         if (result == 0) {
	        	 uService.insertNV(uDTO);
	         }
				  UserDTO login = uService.nvlogin(uDTO);
				  model.addAttribute("login", login);
				
	         
	         
			return "home";
		}

}
