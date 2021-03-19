package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.senac.domain.Aluno;
import br.com.senac.domain.Usuario;
import br.com.senac.repository.UsuarioRepository;
import br.com.senac.service.AlunoService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	AlunoService alunoService;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Usuario usuario = new Usuario();
		usuario.setLogin("admin");
		usuario.setNomeCompleto("Fernando Camilo");
		usuario.setSenha(new BCryptPasswordEncoder().encode("123456"));

		usuarioRepository.save(usuario);
		
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