package kr.co.dw.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.dw.domain.UserDTO;

public class LoginHandlerInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = modelAndView.getModel();
		UserDTO login = (UserDTO)map.get("login");
		
		HttpSession  session =	request.getSession();
		
		if(login != null) {

			session.setAttribute("login", login);
			response.sendRedirect("/user/list");
			
			if (!StringUtils.isEmpty(request.getParameter("useCookie"))) {
				Cookie Cookie = new Cookie("LOGIN_COOKIE", session.getId());
				Cookie.setPath("/");
				Cookie.setMaxAge(7 * 24 * 60 * 60);
			
				response.addCookie(Cookie);
			}
			
			
			//리스트쪽에서 장바구니에 들어있던것들을 세션에, 자동로그인 첫화면에서 자동로그인이 
			
		}

	}
	
}
