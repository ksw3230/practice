package kr.ksw3230.multiBoard.controller.ImageBoard;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ksw3230.multiBoard.model.greet.dto.GreetDTO;
import kr.ksw3230.multiBoard.model.imageBoard.dto.ImageBoardDTO;
import kr.ksw3230.multiBoard.model.imageBoard.dto.ImageCommentDTO;
import kr.ksw3230.multiBoard.model.init.ImageBoardInit;
import kr.ksw3230.multiBoard.service.imageBoard.ImageBoardService;
import kr.ksw3230.multiBoard.service.imageBoard.ImageCommentService;

@Controller
@RequestMapping("imageBoard/*")
public class ImageBoardController {

	@Inject
	ImageBoardService imageboardService;
	@Inject
	ImageCommentService imageCommentService;
	
	AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
	
	
	@RequestMapping("list")
	public String list(HttpServletRequest request, Model model) {
		String userid = (String) request.getSession().getAttribute("userid");
		String admin_userid = (String) request.getSession().getAttribute("admin_userid");
		if(userid != null || admin_userid != null) {
			int level = 1;
			if(userid != null) {
				level = imageboardService.getLevel(userid);
			}
			if(level >= 1) {
				int currentPage = 1;
				try {
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				} catch(Exception e) { }
				
				int pageSize = 12;
				int totalCount = imageboardService.selectList();
				ImageBoardInit init = ctx.getBean("init",ImageBoardInit.class);
				init.init(totalCount, currentPage, pageSize);
				HashMap<String, Integer> hmap = new HashMap<>();
				hmap.put("startNo", init.getStartNo());
				hmap.put("endNo", init.getEndNo());
				List<ImageBoardDTO> list = imageboardService.getList(hmap);
				for(int i=0 ; i<list.size() ; i++) {
					list.get(i).setReplyCount(imageCommentService.reqlyCount(list.get(i).getIdx()));
				}
				model.addAttribute("init", init);
				model.addAttribute("list", list);
				return "imageBoard/list";
				
			} else {
				model.addAttribute("message", "가입인사를 해주세요!");
				model.addAttribute("url", " ");
				return "redirect";
			}
			
		} else {
			model.addAttribute("message", "로그인을 해주세요!");
			model.addAttribute("url", "member/login");
			return "redirect";
		}
	}
	
	@RequestMapping("insert")
	public String insert() {
		return "imageBoard/insert";
	}
	
	@RequestMapping("insertOK")
	public String insertOK(ImageBoardDTO dto) {
		String filename="Noimage.png";
		UUID uid = UUID.randomUUID();
		if(!dto.getFile().isEmpty()) {
			// 첨부파일 이름
			filename = uid.toString()+"_"+dto.getFile().getOriginalFilename();
			try {
				String path="C:\\Users\\Sean\\Desktop\\spring\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\multiBoard\\WEB-INF\\views\\images\\";
				new File(path).mkdir();
				dto.getFile().transferTo(new File(path+filename));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		dto.setPictureUrl(filename);
		imageboardService.insert(dto);
		return "redirect:/imageBoard/list";
	}
	
	@RequestMapping("view")
	public String view(HttpServletRequest request, Model model) {
		int idx = Integer.parseInt(request.getParameter("idx"));
		ImageBoardDTO dto = imageboardService.selectOne(idx);
		List<ImageCommentDTO> list = imageCommentService.selectList(idx);
		model.addAttribute("list", list);
		model.addAttribute("dto", dto);
		model.addAttribute("rn", "\r\n");
		model.addAttribute("currentPage", Integer.parseInt(request.getParameter("currentPage")));
		return "imageBoard/view";
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request, Model model) {
		int idx = Integer.parseInt(request.getParameter("idx"));
		ImageBoardDTO dto = imageboardService.selectOne(idx);
		model.addAttribute("dto", dto);
		model.addAttribute("currentPage", Integer.parseInt(request.getParameter("currentPage")));
		return "imageBoard/update";
	}
	
	@RequestMapping("updateOK")
	public String updateOK(HttpServletRequest request, Model model, ImageBoardDTO dto) {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String filename = "Noimage.png";
		UUID uid = UUID.randomUUID();
		// 첨부 파일이 있으면
		if(!dto.getFile().isEmpty()) {
			filename = uid.toString()+"_"+dto.getFile().getOriginalFilename();
			try {
				String path="C:\\Users\\Sean\\Desktop\\spring\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\multiBoard\\WEB-INF\\views\\images\\";
				new File(path).mkdir();
				dto.getFile().transferTo(new File(path+filename));
			} catch(Exception e) {
				e.printStackTrace();
			}
			dto.setPictureUrl(filename);
		} else { //첨부파일 없으면
			// 기본에 첨부한 파일 정보를 가져옴
			ImageBoardDTO dto2 = imageboardService.selectOne(idx);
			dto.setPictureUrl(dto2.getPictureUrl());
			
		}
		imageboardService.update(dto);
		model.addAttribute("currentPage", Integer.parseInt(request.getParameter("currentPage")));
		return "redirect:/imageBoard/list";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		int idx = Integer.parseInt(request.getParameter("idx"));
		ImageBoardDTO dto = imageboardService.selectOne(idx);
		model.addAttribute("dto", dto);
		model.addAttribute("currentPage", Integer.parseInt(request.getParameter("currentPage")));
		return "imageBoard/delete";
	}
	
	@RequestMapping("deleteOK")
	public String deleteOK(int idx, int currentPage, Model model) {
//		System.out.println("idx~~~~~~~~~ : " + idx + "." + currentPage);
		String filename = imageboardService.selectOne(idx).getPictureUrl();
		if(filename != null && !filename.equals("Noimage.png")) {
			String path="C:\\Users\\Sean\\Desktop\\spring\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\multiBoard\\WEB-INF\\views\\images\\";
			File file = new File(path+filename);
			if(file.exists()) { // 파일 존재하면
				file.delete(); // 파일 삭제
			}
		}
		//레코드 삭제
		imageboardService.delete(idx);
		model.addAttribute("currentPage", currentPage);
		return "redirect:/imageBoard/list";
	}
	
}
