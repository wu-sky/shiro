package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("index.do")
	public String index(){
		return "/common/index";
	}
	@RequestMapping("error.do")
	public String error(){
		return "/common/error";
	}
}
/*
 *用户：sky-吴
 *日期：2019/8/29
 */