package br.com.checkpoint.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="TB_ATUACAO")
@Entity
@SequenceGenerator(name = "SQ_TB_ATUACAO", sequenceName = "SQ_TB_ATUACAO", allocationSize = 1)
public class Atuacao {
	
	@Id
	@Column(name = "CD_ATUACAO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_ATUACAO")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "NM_ATUACAO", nullable = false, length = 50)
	private Funcao function;
	
	@Column(name = "DS_ATUACAO", nullable = false, length = 100)
	private String description;
	
	@OneToOne(mappedBy = "atuacao")
	private Engenheiro engenheiro;
	
	public Atuacao(Funcao function, String description) {
		super();
		this.function = function;
		this.description = description;
	}
	
	public Atuacao() {
		super();
	}

	public Funcao getFunction() {
		return function;
	}

	public void setFunction(Funcao function) {
		this.function = function;
	}

	public String getDescription() {
		return description;
	}

	public void setFuncaoDescription(String description) {
		this.description = description;
	}

}
