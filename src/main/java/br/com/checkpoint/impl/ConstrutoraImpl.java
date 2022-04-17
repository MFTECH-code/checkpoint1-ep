package br.com.checkpoint.impl;

import javax.persistence.EntityManager;

import br.com.checkpoint.dao.ConstrutoraDao;
import br.com.checkpoint.entities.Construtora;

public class ConstrutoraImpl extends GenericDaoImpl<Construtora, Long> implements ConstrutoraDao{

	public ConstrutoraImpl(EntityManager em) {
		super(em);
	}

}
