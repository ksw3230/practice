package kr.ksw3230.multiBoard.controller.home;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ksw3230.multiBoard.model.board.dto.BoardDTO;
import kr.ksw3230.multiBoard.model.fboard.dto.FboardDTO;
import kr.ksw3230.multiBoard.model.imageBoard.dto.ImageBoardDTO;
import kr.ksw3230.multiBoard.service.board.BoardService;
import kr.ksw3230.multiBoard.service.fboard.FboardService;
import kr.ksw3230.multiBoard.service.imageBoard.ImageBoardService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	ImageBoardService imageBoardService;
	@Inject
	BoardService boardService;
	@Inject
	FboardService fboardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		String message = request.getParameter("message");
		BoardDTO notice = boardService.selectLastNotice();
		List<ImageBoardDTO> list = imageBoardService.select4List();
		List<FboardDTO> flist = fboardService.select4List();
		model.addAttribute("notice", notice);
		model.addAttribute("list", list);
		model.addAttribute("flist", flist);
		model.addAttribute("rn", "\r\n");
		model.addAttribute("message", message);
		return "home";
	}
	
	@RequestMapping("logRedirect")
	public String loginRedirect(HttpServletRequest request, Model model) {
				
		model.addAttribute("message", "로그인해 주세요");
		model.addAttribute("url", "member/login");
		return "redirect";
	}
	@RequestMapping("levelRedirect")
	public String levelRedirect(HttpServletRequest request, Model model) {
		model.addAttribute("message", "가입인사를 해주세요");
		model.addAttribute("url", " ");
		return "redirect";
	}
}
