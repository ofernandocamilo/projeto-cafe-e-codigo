package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Materia;
import br.com.senac.domain.Materia;
import br.com.senac.repository.MateriaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class MateriaService {
	
	@Autowired
	MateriaRepository repoMateria;
		
	public List<Materia> buscarTodasMaterias(){
		return repoMateria.findAll();
	}
		
	public Materia salvar(Materia materia) {
		return repoMateria.save(materia);
	}
	
	public Materia buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Materia> materia = repoMateria.findById(id);
		return materia.orElseThrow(() -> new ObjectNotFoundException("Materia não encontrado. ID: " + id));
	}
	
	public Materia salvarAlteracao(Materia materiaAlterado) throws ObjectNotFoundException{
		Materia materia = buscaPorID(materiaAlterado.getId());
		materia.setId(materiaAlterado.getId());
		materia.setNome(materiaAlterado.getNome());
		materia.setDesc(materiaAlterado.getDesc());
		materia.setProfessor(materiaAlterado.getProfessor());
		materia.setModulo(materiaAlterado.getModulo());
		return salvar(materia);
	}
	
	public void excluir (Integer id) {
		repoMateria.deleteById(id);
	}
	
	public List<Materia> findAll(){
		return repoMateria.findAll();
	}

	public Materia findById(Integer materiaId){
		return repoMateria.findById(materiaId).get();
	}

}
