package kr.ksw3230.fboard.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ksw3230.fboard.service.FboardService;

@Controller
@RequestMapping("fboard/*")
public class FboardController {
	
	private static final Logger logger = LoggerFactory.getLogger(FboardController.class);

	@Inject
	FboardService fboardService;
	
	@RequestMapping("list")
	public String list() {
		return "fboard/list";
	}
	
	@RequestMapping("insert")
	public String insert() {
		return "fboard/insert";
	}
	
}
