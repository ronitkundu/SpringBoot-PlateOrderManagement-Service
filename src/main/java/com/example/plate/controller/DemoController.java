package com.example.plate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

	
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public ModelAndView startRets(){
		
	ModelAndView mv=new ModelAndView("test");
	
	return mv;
	}
}
