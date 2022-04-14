package br.com.checkpoint.dao;

import br.com.checkpoint.exceptions.NotFoundItemException;
import br.com.checkpoint.exceptions.TransactionException;

public interface GenericDao<T, K> {
	void insert(T object);
	
	T find(K id) throws NotFoundItemException;
	
	void update(T object);
	
	void remove(K id) throws NotFoundItemException;
	
	void commit() throws TransactionException;
}
