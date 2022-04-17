package br.com.checkpoint.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "TB_ENGENHEIRO")
@Entity
@SequenceGenerator(name = "SQ_TB_ENGENHEIRO", sequenceName = "SQ_TB_ENGENHEIRO", allocationSize = 1)
public class Engenheiro {
	
	@Id
	@Column(name = "CD_ENGENHEIRO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_ENGENHEIRO")
	private Long id;
	
	@Column(name = "NM_ENGENHEIRO", length = 50, nullable = false )
	private String name;
	
	@Column(name = "CD_CREA", length = 10, nullable = false, unique = true)
	private String crea;
	
	@Column(name = "DS_IDADE", length = 3, nullable = false)
	private int age;
	
	@Lob
	@Column(name = "FT_ENGENHEIRO")
	private byte[] picture;
	
	public Engenheiro() {
		super();
	}

	public Engenheiro(String name, String crea, int age) {
		super();
		this.name = name;
		this.crea = crea;
		this.age = age;
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

	public String getCrea() {
		return crea;
	}

	public void setCrea(String crea) {
		this.crea = crea;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
}
