package kr.ksw3230.multiBoard.controller.ImageBoard;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ksw3230.multiBoard.model.imageBoard.dto.ImageCommentDTO;
import kr.ksw3230.multiBoard.service.imageBoard.ImageCommentService;

@Controller
@RequestMapping("imageComment/*")
public class ImageCommentController {
	
	@Inject
	ImageCommentService imageCommentService;
	
	@RequestMapping("insert")
	public String insert(ImageCommentDTO dto, int currentPage, Model model) {
//		System.out.println(dto);
		imageCommentService.insert(dto);
		
		model.addAttribute("message", "댓글 입력 완료!");
		model.addAttribute("url", "imageBoard/view?idx="+dto.getIdx()+"&currentPage="+currentPage);
		return "redirect";
	}
	
	@RequestMapping("delete")
	public String insert(int currentPage, int idx, int ref) {
		imageCommentService.delete(idx);
		return "redirect:/imageBoard/view?currentPage="+currentPage+"&idx="+ref;
	}
	

	
	
}
