package br.com.senac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
	
//	@GetMapping("login")
//	public ModelAndView login(){
//		ModelAndView mv = new ModelAndView("/login");
//		return mv;
//	}

	@GetMapping
	public ModelAndView chamaPagina(){
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
}
