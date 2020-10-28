package br.com.senac.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao implements Serializable {
	
	private static final long serialVersionUID = 7697943553676477457L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@EmbeddedId
	private MateriaAluno alunomateria;
	
//	private Integer id;
	private String conceito;
	private String desc;
	
	public MateriaAluno getAlunomateria() {
		return alunomateria;
	}
	public void setAlunomateria(MateriaAluno alunomateria) {
		this.alunomateria = alunomateria;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getConceito() {
		return conceito;
	}
	public void setConceito(String conceito) {
		this.conceito = conceito;
	}
	
//	@OneToOne
//	@JoinColumn(name = "id_materia")
//	private Materia materia;
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public Materia getMateria() {
//		return materia;
//	}£
//	public void setMateria(Materia materia) {
//		this.materia = materia;
//	}
	
}
