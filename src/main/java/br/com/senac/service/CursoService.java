package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Curso;
import br.com.senac.repository.CursoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CursoService {

	@Autowired
	CursoRepository repoCurso;
		
	public List<Curso> buscarTodosCursos(){
		return repoCurso.findAll();
	}
		
	public Curso salvar(Curso curso) {
		return repoCurso.save(curso);
	}
	
	public Curso buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Curso> curso = repoCurso.findById(id);
		return curso.orElseThrow(() -> new ObjectNotFoundException("Curso não encontrado. ID: " + id));
	}
	
	public Curso salvarAlteracao(Curso cursoAlterado) throws ObjectNotFoundException{
		Curso curso = buscaPorID(cursoAlterado.getId());
		curso.setId(cursoAlterado.getId());
		curso.setNome(cursoAlterado.getNome());
		curso.setDesc(cursoAlterado.getDesc());
		curso.setNivel(cursoAlterado.getNivel());
		curso.setModalidade(cursoAlterado.getModalidade());
		curso.setDuracao(cursoAlterado.getDuracao());
		curso.setCargaHoraria(cursoAlterado.getCargaHoraria());
		return salvar(curso);
	}
	
	public void excluir (Integer id) {
		repoCurso.deleteById(id);
	}

}
