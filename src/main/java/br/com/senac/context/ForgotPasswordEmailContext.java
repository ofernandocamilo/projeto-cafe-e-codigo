package br.com.senac.context;

import br.com.senac.domain.Aluno;
import br.com.senac.domain.Avaliacao;

public class ForgotPasswordEmailContext extends AbstractEmailContext{

	public <T> void init(T context) {
		
		Aluno aluno = (Aluno) context;
		put("nome",aluno.getNome());
		setSubject("Seu conceito | Café & Código");
		setFrom("evanildoobservatorio@gmail.com"); 
		setTemplateLocation("email/email-conceito-aluno");
		setTo(aluno.getEmail());
		
		//Aluno aluno = (Aluno) context;
//		Avaliacao avaliacao = (Avaliacao) context;
//		put("nome",avaliacao.getAlunomateria().getAluno().getNome());
//		put("conceito",avaliacao.getConceito());
//		put("descricao",avaliacao.getAlunomateria().getMateria().getDesc());
//		put("materia",avaliacao.getAlunomateria().getMateria());
//		setSubject("Seu conceito | Café & Código");
//		setFrom("evanildoobservatorio@gmail.com"); 
//		setTemplateLocation("email/email-conceito-aluno");
//		setTo(avaliacao.getAlunomateria().getAluno().getEmail());
	}
}
