package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.service.TurmaService;

@Controller
@RequestMapping("/dashboard")
public class PrincipalController {
	
	@Autowired
	private TurmaService turmaService;

	@GetMapping
	public ModelAndView chamaPagina(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("turmas", turmaService.buscarTodasTurmas());
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
}
