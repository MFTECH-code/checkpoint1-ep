package br.com.checkpoint.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "TB_CONSTRUTORA")
@Entity
@SequenceGenerator(name = "SQ_TB_CONSTRUTORA", sequenceName = "SQ_TB_CONSTRUTORA", allocationSize = 1)
public class Construtora {
	
	@Id
	@Column(name = "CD_CONSTRUTORA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_CONSTRUTORA")
	private Long id;
	
	@Column(name = "DS_CNPJ", length = 11, nullable = false, unique = true)
	private String CNPJ; 
	
	@Column(name = "NM_CONSTRUTORA", length = 50, nullable = false)
	private String construtora;

	@OneToMany(mappedBy = "construtora", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Cliente> clientes;
	
	public Construtora() {
		super();
	}
	
	public Construtora(String cNPJ, String construtora) {
		super();
		CNPJ = cNPJ;
		this.construtora = construtora;
		this.clientes = new ArrayList<Cliente>();
	}
	
	public void addCliente(Cliente cliente) {
		cliente.setConstrutora(this);
		clientes.add(cliente);
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getConstrutora() {
		return construtora;
	}

	public void setConstrutora(String construtora) {
		this.construtora = construtora;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Construtora [id=" + id + ", CNPJ=" + CNPJ + ", construtora=" + construtora + "]";
	}
}
