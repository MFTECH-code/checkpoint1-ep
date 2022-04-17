package br.com.checkpoint.impl;

import javax.persistence.EntityManager;

import br.com.checkpoint.dao.EngenheiroDao;
import br.com.checkpoint.entities.Engenheiro;

public class EngenheiroImpl extends GenericDaoImpl<Engenheiro, Long> implements EngenheiroDao{

	public EngenheiroImpl(EntityManager em) {
		super(em);
	}
}
