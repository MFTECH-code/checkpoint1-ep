package br.com.checkpoint.impl;

import javax.persistence.EntityManager;

import br.com.checkpoint.dao.ProjetoDao;
import br.com.checkpoint.entities.Projeto;

public class ProjetoImpl extends GenericDaoImpl<Projeto, Long> implements ProjetoDao {

	public ProjetoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
