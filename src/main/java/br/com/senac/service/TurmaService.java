package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Turma;
import br.com.senac.repository.TurmaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class TurmaService {

	@Autowired
	TurmaRepository repoTurma;
		
	public List<Turma> buscarTodasTurmas(){
		return repoTurma.findAll();
	}
		
	public Turma salvar(Turma turma) {
		return repoTurma.save(turma);
	}
	
	public Turma buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Turma> turma = repoTurma.findById(id);
		return turma.orElseThrow(() -> new ObjectNotFoundException("Turma não encontrado. ID: " + id));
	}
	
	public Turma salvarAlteracao(Turma turmaAlterado) throws ObjectNotFoundException{
		Turma turma = buscaPorID(turmaAlterado.getId());
		turma.setId(turmaAlterado.getId());
		turma.setAnoSemestre(turmaAlterado.getAnoSemestre());
		turma.setCurso(turmaAlterado.getCurso());
		turma.setDataCriacao(turmaAlterado.getDataCriacao());
		turma.setTurno(turmaAlterado.getTurno());
		turma.setHorario(turmaAlterado.getHorario());
		turma.setStatus(turmaAlterado.getStatus());
		return salvar(turma);
	}
	
	public void excluir (Integer id) {
		repoTurma.deleteById(id);
	}


}
