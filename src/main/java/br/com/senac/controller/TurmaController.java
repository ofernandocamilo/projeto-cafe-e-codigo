package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Turma;
import br.com.senac.service.CursoService;
import br.com.senac.service.TurmaService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("turma")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/listar")
	public ModelAndView listaTodasTurmas() {
		ModelAndView mv = new ModelAndView("turma/listarTurmas");
		mv.addObject("turmas", turmaService.buscarTodasTurmas());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarTurma() {
		ModelAndView mv = new ModelAndView("turma/cadastrarTurma");
		mv.addObject("cursos", cursoService.buscarTodosCursos());
		mv.addObject("turma", new Turma());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarTurma(Turma turma) {
		turmaService.salvar(turma);
		return listaTodasTurmas();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarTurma(@PathVariable("id") Integer idTurma) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("turma/atualizarTurma");
		mv.addObject("turma", turmaService.buscaPorID(idTurma));
		mv.addObject("cursos", cursoService.buscarTodosCursos());
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Turma turmaAlterado) throws ObjectNotFoundException{
		turmaService.salvarAlteracao(turmaAlterado);
		return listaTodasTurmas();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirTurma(@PathVariable("id") Integer id) {
		turmaService.excluir(id);
		return listaTodasTurmas();
	}

}
