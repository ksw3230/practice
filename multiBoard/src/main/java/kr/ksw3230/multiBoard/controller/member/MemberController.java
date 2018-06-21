package kr.ksw3230.multiBoard.controller.member;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.ksw3230.multiBoard.model.member.dto.MemberDTO;
import kr.ksw3230.multiBoard.service.member.MemberService;

@Controller
@RequestMapping("member/*")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService memberService;
	
	@RequestMapping("login")
	public String login(HttpSession session, Model model) {
		String userid = (String) session.getAttribute("userid");
		String admin_userid = (String) session.getAttribute("admin_userid");

		if(userid != null || admin_userid != null) {
			// 이미 로그인 한 경우
			model.addAttribute("message", "이미 로그인 하였습니다.");
			model.addAttribute("url", "");
			return "redirect";
		} else {
			// 로그인을 하지 않은 경우
			return "member/login";
		}
	}
	
	@RequestMapping("join")
	public String join(HttpSession session, Model model) {
		String userid = (String) session.getAttribute("userid");
		String admin_userid = (String) session.getAttribute("admin_userid");
		if(userid != null || admin_userid != null) {
			// 이미 로그인 한 경우
			model.addAttribute("message", "이미 로그인 하였습니다.");
			model.addAttribute("url", "");
			return "redirect";
		} else {
			// 로그인을 하지 않은 경우
			return "member/join";
		}
	}
	
	@RequestMapping("joinAction")
	public String joinAction(MemberDTO dto, Model model, HttpSession session) {
		String name = memberService.idCheck(dto.getUserid());
		if(name != null && name.trim().length() > 0) {
			model.addAttribute("message", "existence_id");
			return "/member/join";
		} else {
			memberService.join(dto);
			model.addAttribute("url", "");
			model.addAttribute("message", dto.getName() + "님의 가입을 환영합니다!");
			session.setAttribute("userid", dto.getUserid());
			return "redirect";
		}
	}
	
	@RequestMapping("loginAction")
	public ModelAndView loginAction(HttpSession session, ModelAndView mav, String userid, String passwd, String admin) {
		Map<String, Object> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		if(admin != null) {
			String name = memberService.admin_login(map);
			if(name != null && name.trim().length() > 0) {
				session.setAttribute("admin_userid", userid);
				mav.setViewName("redirect:/");
				mav.addObject("message", name + "님 안녕하세요!");
				return mav;
			} else {
				mav.setViewName("member/login");
				mav.addObject("message", "fail");
				return mav;
			}
		} else {
			String name = memberService.login(map);
			if(name != null && name.trim().length() > 0) {
				session.setAttribute("userid", userid);
				mav.setViewName("redirect:/");
				mav.addObject("message", name + "님 안녕하세요!");
				return mav;
			} else {
				mav.setViewName("member/login");
				mav.addObject("message", "fail");
				return mav;
			}
		}
	}
	
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session, ModelAndView mav) {
		session.invalidate();
		mav.setViewName("member/login");
		mav.addObject("message", "logout");
		return mav;
	}
	
	@RequestMapping("edit")
	public String edit(HttpSession session, Model model) {
		String userid = (String) session.getAttribute("userid");
		if(userid != null) {
			MemberDTO dto = memberService.getInfo(userid);
			model.addAttribute("dto", dto);
			return "member/edit";
		} else {
			model.addAttribute("message", "로그인을 해주세요!");
			model.addAttribute("url", "member/login");
			return "redirect";
		}
	}
	
	@RequestMapping("editAction")
	public String editAction(MemberDTO dto, Model model) {
		memberService.update(dto);
		return "redirect:/";
	}
	
	@RequestMapping("deleteMember")
	public String deleteMember(HttpSession session, Model model) {
		String userid = (String) session.getAttribute("userid");
		if(userid != null) {
			memberService.deleteMember(userid);
			session.invalidate();		
			return "redirect:/";
		} else {
			model.addAttribute("message", "로그인을 해주세요!");
			model.addAttribute("url", "member/login");
			return "redirect";
		}
	}
	
}









