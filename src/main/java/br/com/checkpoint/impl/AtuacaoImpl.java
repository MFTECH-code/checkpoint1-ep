package br.com.checkpoint.impl;

import javax.persistence.EntityManager;

import br.com.checkpoint.dao.AtuacaoDao;
import br.com.checkpoint.entities.Atuacao;

public class AtuacaoImpl extends GenericDaoImpl<Atuacao, Long> implements AtuacaoDao{

	public AtuacaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
