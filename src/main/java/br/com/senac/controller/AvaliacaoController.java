package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Aluno;
import br.com.senac.domain.Avaliacao;
import br.com.senac.service.AlunoService;
import br.com.senac.service.AvaliacaoService;
import br.com.senac.service.MateriaService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("avaliacao")
public class AvaliacaoController {

	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@Autowired
	private MateriaService materiaService;
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping("/listar")
	public ModelAndView listaTodasAvaliacoes() {
		ModelAndView mv = new ModelAndView("avaliacao/listarAvaliacoes");
		mv.addObject("avaliacoes", avaliacaoService.buscarTodasAvaliacoes());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAvaliacao() {
		ModelAndView mv = new ModelAndView("avaliacao/cadastrarAvaliacao");
		mv.addObject("alunos", alunoService.buscarTodosAlunos());
		mv.addObject("materias", materiaService.buscarTodasMaterias());
		mv.addObject("avaliacao", new Avaliacao());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView save(@ModelAttribute("avaliacao") Avaliacao avaliacao){
		avaliacao.getAlunomateria().setAluno(alunoService.findById(avaliacao.getAlunomateria().getAluno().getId()));
		avaliacao.getAlunomateria().setMateria(materiaService.findById(avaliacao.getAlunomateria().getMateria().getId()));
		avaliacaoService.salvar(avaliacao);

		ModelAndView mv = new ModelAndView("avaliacao/listarAvaliacoes");
		mv.addObject("avaliacoes", avaliacaoService.buscarTodasAvaliacoes());
		return mv;
	}
	
	@GetMapping("/email/{emailAluno}")
	public ModelAndView enviarEmail(@PathVariable("emailAluno") String emailAluno) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("email/email-enviado");
		mv.addObject("aluno", alunoService.findByEmail(emailAluno));
		avaliacaoService.sendResetPasswordEmail(alunoService.findByEmail(emailAluno));
		return mv;
	}
}
