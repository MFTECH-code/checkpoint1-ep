package br.com.checkpoint.impl;

import javax.persistence.EntityManager;

import br.com.checkpoint.dao.ClienteDao;
import br.com.checkpoint.entities.Cliente;

public class ClienteImpl extends GenericDaoImpl<Cliente	, Long> implements ClienteDao{

	public ClienteImpl(EntityManager em) {
		super(em);
	}

}
