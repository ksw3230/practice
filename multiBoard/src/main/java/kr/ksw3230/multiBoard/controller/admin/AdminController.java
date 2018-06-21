package kr.ksw3230.multiBoard.controller.admin;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.ksw3230.multiBoard.model.member.dto.MemberDTO;
import kr.ksw3230.multiBoard.service.admin.AdminService;

@Controller
@RequestMapping("admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService;
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("manage_member")
	public ModelAndView memberList(ModelAndView mav) {
		List<MemberDTO> dto = adminService.getMemberList();
		mav.setViewName("admin/memberList");
		mav.addObject("dto", dto);
		return mav;
	}
	
	@RequestMapping("memberView")
	public String memberview(HttpServletRequest request, Model model) {
		String userid = request.getParameter("userid");
		MemberDTO dto = adminService.getOneMemberInfo(userid);
		model.addAttribute("dto", dto);
		return "admin/memberView";
	}
	
	@RequestMapping("editAction")
	public String editAction(MemberDTO dto, Model model) {
		adminService.update(dto);
		return "redirect:/admin/manage_member";
	}
	
	@RequestMapping("deleteMember/{dto.userid}")
	public String deleteMember(HttpServletRequest request, Model model, @PathVariable("dto.userid") String userid) {
		String admin_userid = (String) request.getSession().getAttribute("admin_userid");
//		String userid = request.getParameter("dto.userid");
		logger.info("userid", userid);
		if(admin_userid != null) {
			adminService.deleteMember(userid);
			return "redirect:/admin/manage_member";
		} else {
			model.addAttribute("message", "로그인을 해주세요!");
			model.addAttribute("url", "member/login");
			return "redirect";
		}
	}
	
	
}
