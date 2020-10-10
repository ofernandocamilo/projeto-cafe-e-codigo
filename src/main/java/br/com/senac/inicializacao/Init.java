package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.domain.Aluno;
import br.com.senac.service.AlunoService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	AlunoService alunoService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
//		Aluno aluno1 = new Aluno();
//		aluno1.setNome("Lucas");
//		alunoService.salvar(aluno1);
//		
//		Aluno aluno2 = new Aluno();
//		aluno2.setNome("Arthur");
//		alunoService.salvar(aluno2);
//		
//		Aluno aluno3 = new Aluno();
//		aluno3.setNome("Jose");
//		alunoService.salvar(aluno3);
//	
//		
//		List<Aluno> listaAlunos = alunoService.buscarTodosAlunos();
//		
//		for (Aluno aluno : listaAlunos) {
//			System.out.println(aluno.getNome());
//		}
	}

}