package br.com.checkpoint.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="TB_ATUACAO")
@Entity
@SequenceGenerator(name = "SQ_TB_ATUACAO", sequenceName = "SQ_TB_ATUACAO", allocationSize = 1)
public class Atuacao {
	
	@Id
	@Column(name = "CD_FUNCAO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_ATUACAO")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "NM_FUNCAO", nullable = false, length = 50)
	private Funcao function;
	
	@Column(name = "DT_INICIO", nullable = false)
	private LocalDate startDate;
	
	@Column(name = "DT_FIM", nullable = false)
	private LocalDate endDate;
	
	@Column(name = "DS_FUNCAO", nullable = false, length = 100)
	private String description;
	
	
	public Atuacao(Funcao function, LocalDate startDate, LocalDate endDate, String description) {
		super();
		this.function = function;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setFuncaoDescription(String description) {
		this.description = description;
	}

}
