package br.com.checkpoint.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="TB_ATUACAO")
@SequenceGenerator(name = "atuacao", sequenceName = "SQ_TB_ATUACAO", allocationSize = 1)
public class Atuacao {
	
	@Id
	@Column(name = "CD_FUNCAO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "atuacao")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "NM_FUNCAO", nullable = false, length = 50)
	private Funcao function;
	
	@Column(name = "DT_INICIO", nullable = false)
	private Date startDate;
	
	@Column(name = "DT_FIM", nullable = false)
	private Date endDate;
	
	@Column(name = "DS_FUNCAO", nullable = false, length = 100)
	private String description;
	
	
	public Atuacao(Long id, Funcao function, Date startDate, Date endDate, String description) {
		super();
		this.id = id;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setFuncaoDescription(String description) {
		this.description = description;
	}

}
