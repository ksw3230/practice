package kr.ksw3230.multiBoard.controller.greet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ksw3230.multiBoard.model.greet.dao.GreetDAO;
import kr.ksw3230.multiBoard.model.greet.dto.GreetDTO;
import kr.ksw3230.multiBoard.model.greet.dto.GreetParam;
import kr.ksw3230.multiBoard.service.greet.GreetService;

@Controller
@RequestMapping("greet/*")
public class GreetController {

	private static final Logger logger = LoggerFactory.getLogger(GreetController.class);
	
	@Inject
	GreetService greetService;
	
	AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
	
	@RequestMapping("list")
	public String list(HttpServletRequest request, Model model) {
		String userid = (String) request.getSession().getAttribute("userid");
		String admin_userid = (String) request.getSession().getAttribute("admin_userid");
		if(userid != null || admin_userid != null) {
			List<GreetDTO> list = greetService.selectList();
			model.addAttribute("list", list);
			return "greet/greetList";
			
		} else {
			model.addAttribute("message", "로그인해주세요!");
			model.addAttribute("url", "member/login");
			return "redirect";
		}
	}
	
	@RequestMapping("insert")
	public String insert(HttpServletRequest request, Model model) {
		String userid = request.getParameter("userid");
		String content = request.getParameter("content");
		int level = greetService.selectLevel(userid);
		if( level < 1) {
			HashMap<String, String> map = new HashMap<>();
			map.put("userid", userid);
			map.put("content", content);
			greetService.insert(map);
			GreetParam param = ctx.getBean("greetParam",GreetParam.class);
			param.setUser_level(level);
			param.setUserid(userid);
			greetService.levelUp(param);
			return "redirect:/greet/list";
		} else {
			model.addAttribute("message", "이미 작성 하셨습니다.");
			model.addAttribute("url", "greet/list");
			return "redirect";
		}
		
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		String admin_userid = (String) request.getSession().getAttribute("admin_userid");
		int idx = Integer.parseInt(request.getParameter("idx"));
		if(admin_userid != null) {
			greetService.delete(idx);
			return "redirect:/greet/list";
		} else {
			model.addAttribute("message", "관리자 로그인을 하세요!");
			model.addAttribute("url", "member/login");
			return "redirect";
		}
		
	}
	
	
	
}
