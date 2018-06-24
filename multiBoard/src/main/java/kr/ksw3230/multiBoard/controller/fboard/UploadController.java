package kr.ksw3230.multiBoard.controller.fboard;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import kr.ksw3230.multiBoard.service.fboard.FboardService;
import kr.ksw3230.multiBoard.util.UploadFileUtils;


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
	
	
	@ResponseBody // view가 아닌 data 리턴
	@RequestMapping("/fboard/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
		InputStream in = null; // java.io
		ResponseEntity<byte[]> entity = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath + fileName);
			fileName = fileName.substring(fileName.indexOf("_") + 1);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("utf-8"), "iso-8859-1") + "\"");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			if (in != null) {
				in.close(); // 스트림 닫기
			}
		}
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value="/fboard/deleteFile", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName){
		logger.info("fileName : " + fileName);
		new File(uploadPath+fileName.replace('/', File.separatorChar)).delete();
		fboardService.deleteFile(fileName);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

	
}
