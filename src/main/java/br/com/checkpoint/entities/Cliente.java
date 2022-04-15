package br.com.checkpoint.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "TB_CLIENTE")
@Entity
@SequenceGenerator(name = "SQ_TB_CLIENTE", sequenceName = "SQ_TB_CLIENTE", allocationSize = 1)
public class Cliente {

	@Id
	@Column(name = "CD_CLIENTE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_CLIENTE")
	private Long id;
	
	@Column(name = "NM_CLIENTE", length = 50, nullable = false)
	private String client;
	
	@Column(name = "DS_CNPJ", length = 11, nullable = false, unique = true)
	private String cnpj;
	
	@Column(name = "DS_TELEFONE", length = 14, nullable = false)
	private String tel;
	
	@Column(name = "DS_EMAIL", length = 80)
	private String email;

	
	public Cliente() {
		super();
	}
	
	
	public Cliente(String client, String cnpj, String tel, String email) {
		super();
		this.client = client;
		this.cnpj = cnpj;
		this.tel = tel;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
