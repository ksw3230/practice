package kr.ksw3230.fboard.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ksw3230.fboard.model.dto.FboardDTO;
import kr.ksw3230.fboard.pager.Pager;
import kr.ksw3230.fboard.service.FboardService;

@Controller
@RequestMapping("fboard/*")
public class FboardController {
	
	private static final Logger logger = LoggerFactory.getLogger(FboardController.class);

	@Inject
	FboardService fboardService;
	
	AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
	
	@RequestMapping("list")
	public String list(HttpServletRequest request, Model model) {
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch(Exception e) {}
		int pageSize = 10;
		int totalCount = fboardService.selectCount();
		Pager pager = ctx.getBean("pager", Pager.class);
		pager.initPage(totalCount, currentPage, pageSize);
		HashMap<String, Integer> hmap = new HashMap<>();
		hmap.put("startNo", pager.getStartNo());
		hmap.put("endNo", pager.getEndNo());
		List<FboardDTO> list = fboardService.selectList(hmap);
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);	
		return "fboard/list";
	}
	
	@RequestMapping("insert")
	public String insert() {
		return "fboard/insert";
	}
	
	@RequestMapping("insertOK")
	public String insert(FboardDTO dto, HttpSession session) throws Exception{
//		String writer =(String) session.getAttribute("userid");
		dto.setUserid("ksw3230");
		fboardService.insert(dto);
		return "redirect:/fboard/list";
	}
	
	@RequestMapping("getAttach/{idx}")
	@ResponseBody // view가 아닌 데이터 자체를 리턴
	public List<String> getAttach(@PathVariable int idx){
		return fboardService.getAttach(idx);
	}
	
	@RequestMapping("increment")
	public String increment(HttpServletRequest request, Model model) {
		int idx = Integer.parseInt(request.getParameter("idx"));
		fboardService.increment(idx);
		model.addAttribute("idx", idx);
		model.addAttribute("currentPage", Integer.parseInt(request.getParameter("currentPage")));
		model.addAttribute("job", "fboard/view");
		return "redirect:/fboard/contentView";
	}
	
	@RequestMapping("contentView")
	public String contentView(HttpServletRequest request, Model model) {
		String job = request.getParameter("job");
		int idx = Integer.parseInt(request.getParameter("idx"));
		FboardDTO dto = fboardService.selectByIdx(idx);
		model.addAttribute("dto", dto);
		model.addAttribute("currentPage", Integer.parseInt(request.getParameter("currentPage")));
		return job;	
	}
	
	@RequestMapping("update")
	public String update(FboardDTO dto, int currentPage) throws Exception {
		
		if(dto != null) {
			fboardService.update(dto);
		}
		return "redirect:/fboard/contentView?idx="+dto.getIdx()+"&job=fboard/view&currentPage="+currentPage;
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		int idx = Integer.parseInt(request.getParameter("idx"));
		fboardService.delete(idx);
		model.addAttribute("currentPage", Integer.parseInt(request.getParameter("currentPage")));
		return "redirect:/fboard/list";
	}
	
	
}
