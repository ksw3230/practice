package kr.ksw3230.multiBoard.controller.board;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ksw3230.multiBoard.model.board.dto.BoardDTO;
import kr.ksw3230.multiBoard.model.board.dto.BoardParam;
import kr.ksw3230.multiBoard.model.init.Pager;
import kr.ksw3230.multiBoard.service.board.BoardService;
import kr.ksw3230.multiBoard.service.imageBoard.ImageBoardService;

@Controller
@RequestMapping("board/*")
public class BoardController {

	@Inject
	BoardService boardService;
	@Inject
	ImageBoardService imageboardService;
	
	AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");

	@RequestMapping("list")
	public String list(HttpServletRequest request, Model model) {
		String category = request.getParameter("category");
		String item = request.getParameter("item");
		if(item != null) {
//	 		검색어에 전부 스페이스바를 입력했을 경우에 대비해서 아래의 코드를 추가한다.
			item = item.trim().length() != 0 ? item : "";
//			넘어온 카테고리와 검색어를 세션에 넣는다.		
			request.getSession().setAttribute("category", category);
			request.getSession().setAttribute("item", item);
		} else {
			category = (String) request.getSession().getAttribute("category");
			item = (String) request.getSession().getAttribute("item");
		}
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch(Exception e) { }
		int pageSize = 10;
		try{
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			request.getSession().setAttribute("pageSize", pageSize + "");
		} catch (Exception e) {
			String temp = (String) request.getSession().getAttribute("pageSize");
			if(temp != null) {
				pageSize = Integer.parseInt(temp);
			}
		}
		int totalCount;
		Pager init = ctx.getBean("pager",Pager.class);
		List<BoardDTO> list = null;
		if(item == null || item.trim().length() == 0) {
			totalCount = boardService.selectCount();
			init.init(totalCount, currentPage, pageSize);
			HashMap<String, Integer> hmap = new HashMap<>();
			hmap.put("startNo", init.getStartNo());
			hmap.put("endNo", init.getEndNo());
			list = boardService.selectList(hmap);
		} else {
			HashMap<String, String> hmap = new HashMap<String, String>();
			hmap.put("item", item);
			System.out.println(hmap.get("item"));
			hmap.put("category", category);
			totalCount = boardService.selectCountMulti(hmap);
			init.init(totalCount, currentPage, pageSize);
			BoardParam param = ctx.getBean("boardParam", BoardParam.class);
			param.setStartNo(init.getStartNo());
			param.setEndNo(init.getEndNo());
			param.setItem(item);
			param.setCategory(category);
			list = boardService.selectListMulti(param);
		}
		model.addAttribute("init", init);
		model.addAttribute("list", list);
		List<BoardDTO> notice = boardService.selectNotice();
		model.addAttribute("notice", notice);
		return "board/list";
		
	}
	
	@RequestMapping("insert")
	public String insert() {		
		return "board/insert";
	}
	
	@RequestMapping("insertOK")
	public String insertOK(BoardDTO dto) {
		boardService.insert(dto);
		return "redirect:/board/list";
	}
	
	@RequestMapping("increment")
	public String increment(HttpServletRequest request, Model model) {
		int idx = Integer.parseInt(request.getParameter("idx"));
		boardService.increment(idx);
		model.addAttribute("idx", idx);
		model.addAttribute("currentPage", Integer.parseInt(request.getParameter("currentPage")));
		model.addAttribute("job", "board/contentView");
		return "redirect:/board/contentView";
	}
	
	@RequestMapping("contentView")
	public String contentView(HttpServletRequest request, Model model) {
		String job = request.getParameter("job");
		int idx = Integer.parseInt(request.getParameter("idx"));
		BoardDTO dto = boardService.selectByIdx(idx);
		model.addAttribute("dto", dto);
		model.addAttribute("rn", "\r\n");
		model.addAttribute("currentPage", Integer.parseInt(request.getParameter("currentPage")));
		return job;
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		int idx = Integer.parseInt(request.getParameter("idx"));
		boardService.delete(idx);
		model.addAttribute("currentPage", Integer.parseInt(request.getParameter("currentPage")));
		return "redirect:/board/list";
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request, Model model, BoardDTO dto) {
		boardService.update(dto);
		model.addAttribute("currentPage", Integer.parseInt(request.getParameter("currentPage")));
		return "redirect:/board/list";
	}
	
	@RequestMapping("reply")
	public String reply(HttpServletRequest request, Model model, BoardDTO dto) {
		System.out.println(dto);
		dto.setLev(dto.getLev()+1);
		dto.setSeq(dto.getSeq()+1);
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("ref", dto.getRef());
		hmap.put("seq", dto.getSeq());
		boardService.incrementSeq(hmap);
		boardService.reply(dto);
		model.addAttribute("currentPage", Integer.parseInt(request.getParameter("currentPage")));
		return "redirect:/board/list";
	}
	
	
}
