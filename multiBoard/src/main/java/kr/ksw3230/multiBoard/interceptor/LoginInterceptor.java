package kr.ksw3230.multiBoard.interceptor;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ksw3230.multiBoard.model.imageBoard.dao.ImageBoardDAO;
import kr.ksw3230.multiBoard.service.imageBoard.ImageBoardService;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Inject
	ImageBoardDAO dao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		if( userid != null || session.getAttribute("admin_userid") != null ) {
			int level = 1;
			if(userid != null) {
				level = dao.getLevel(userid);
			}
			if(level >= 1) {
				return true;
			}else {
				response.sendRedirect(request.getContextPath() + "/levelRedirect");
				return false;
			}
		}else {
			response.sendRedirect(request.getContextPath() + "/logRedirect");
			return false;
		}
		
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
