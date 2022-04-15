package br.com.checkpoint.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "TB_PROJETO")
@SequenceGenerator(name = "projeto", sequenceName = "SQ_TB_PROJETO", allocationSize = 1)
public class Projeto {

	@Id
	@Column(name = "CD_PROJETO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projeto")
	private Long id;

	@Column(name = "NM_PROJETO", length = 50, nullable = false)
	private String name;

	@Column(name = "DT_INICIO", nullable = false)
	private Date startDate;

	@Column(name = "CD_TERMINO", nullable = false)
	private Date endDate;

	public Projeto() {
		super();
	}

	public Projeto(Long id, String name, Date startDate, Date endDate) {
		super();
		this.id = id;
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

}
