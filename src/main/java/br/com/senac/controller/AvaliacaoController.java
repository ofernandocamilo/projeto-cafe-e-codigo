package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Avaliacao;
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
	
	@GetMapping("/listar")
	public ModelAndView listaTodasAvaliacoes() {
		ModelAndView mv = new ModelAndView("avaliacao/listarAvaliacoes");
		mv.addObject("avaliacoes", avaliacaoService.buscarTodasAvaliacoes());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAvaliacao() {
		ModelAndView mv = new ModelAndView("avaliacao/cadastrarAvaliacao");
		mv.addObject("materias", materiaService.buscarTodasMaterias());
		mv.addObject("avaliacao", new Avaliacao());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarAvaliacao(Avaliacao avaliacao) {
		avaliacaoService.salvar(avaliacao);
		return listaTodasAvaliacoes();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarAvaliacao(@PathVariable("id") Integer idAvaliacao) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("avaliacao/atualizarAvaliacao");
		mv.addObject("avaliacao", avaliacaoService.buscaPorID(idAvaliacao));
		mv.addObject("materias", materiaService.buscarTodasMaterias());
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Avaliacao avaliacaoAlterado) throws ObjectNotFoundException{
		avaliacaoService.salvarAlteracao(avaliacaoAlterado);
		return listaTodasAvaliacoes();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirAvaliacao(@PathVariable("id") Integer id) {
		avaliacaoService.excluir(id);
		return listaTodasAvaliacoes();
	}
	
}
