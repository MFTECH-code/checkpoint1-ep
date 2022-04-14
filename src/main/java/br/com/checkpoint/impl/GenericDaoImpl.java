package br.com.checkpoint.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.checkpoint.dao.GenericDao;
import br.com.checkpoint.exceptions.NotFoundItemException;
import br.com.checkpoint.exceptions.TransactionException;

public class GenericDaoImpl<T, K> implements GenericDao<T, K> {

	private EntityManager em;
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		super();
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void insert(T object) {
		em.persist(object);
	}

	public T find(K id) throws NotFoundItemException {
		T entity = em.find(clazz, id);
		
		if (entity == null) {
			throw new NotFoundItemException();
		}
		
		return entity;
	}

	public void update(T object) {
		em.merge(object);
	}

	public void remove(K id) throws NotFoundItemException {
		em.remove(find(id));
	}

	public void commit() throws TransactionException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();			
		} catch(Exception e) {
			em.getTransaction().rollback();
			throw new TransactionException();
		}
		
	}

}
