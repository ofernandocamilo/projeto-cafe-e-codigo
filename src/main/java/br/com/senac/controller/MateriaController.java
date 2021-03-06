package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Materia;
import br.com.senac.service.MateriaService;
import br.com.senac.service.ModuloService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("materia")
public class MateriaController {
	
	@Autowired
	private MateriaService materiaService;
	
	@Autowired
	private ModuloService moduloService;
	
	@GetMapping("/listar")
	public ModelAndView listaTodasMaterias() {
		ModelAndView mv = new ModelAndView("materia/listarMaterias");
		mv.addObject("materias", materiaService.buscarTodasMaterias());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarMateria() {
		ModelAndView mv = new ModelAndView("materia/cadastrarMateria");
		mv.addObject("materia", new Materia());
		mv.addObject("modulos", moduloService.buscarTodosModulos());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarMateria(Materia materia) {
		materiaService.salvar(materia);
		return listaTodasMaterias();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarMateria(@PathVariable("id") Integer idMateria) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("materia/atualizarMateria");
		mv.addObject("materia", materiaService.buscaPorID(idMateria));
		mv.addObject("modulos", moduloService.buscarTodosModulos());
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Materia materiaAlterado) throws ObjectNotFoundException{
		materiaService.salvarAlteracao(materiaAlterado);
		return listaTodasMaterias();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirMateria(@PathVariable("id") Integer id) {
		materiaService.excluir(id);
		return listaTodasMaterias();
	}

}
