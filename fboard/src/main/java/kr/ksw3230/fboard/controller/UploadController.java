package kr.ksw3230.fboard.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.ksw3230.fboard.service.FboardService;
import kr.ksw3230.fboard.util.UploadFileUtils;

@Controller
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@Inject
	FboardService fboardService;
	
	@Resource(name="uploadPath")
	String uploadPath;
	
	@RequestMapping(value="/fboard/uploadFile", method = RequestMethod.GET)
	public String uploadFile() {
		return "/fboard/insert";
	}
	
	@ResponseBody
	@RequestMapping(value="/fboard/uploadFile", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public ResponseEntity<String> uploadFile(MultipartFile file) throws Exception {
		return new ResponseEntity<String>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()), HttpStatus.OK);
	}
	
	

	
}
