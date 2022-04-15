package br.com.checkpoint.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "TB_PROJETO")
@Entity
@SequenceGenerator(name = "SQ_TB_PROJETO", sequenceName = "SQ_TB_PROJETO", allocationSize = 1)
public class Projeto {

	@Id
	@Column(name = "CD_PROJETO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_PROJETO")
	private Long id;

	@Column(name = "NM_PROJETO", length = 50, nullable = false)
	private String name;

	@Column(name = "DT_INICIO")
	private LocalDate startDate;

	@Column(name = "CD_TERMINO")
	private LocalDate endDate;

	public Projeto() {
		super();
	}

	public Projeto(String name, LocalDate startDate, LocalDate endDate) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
