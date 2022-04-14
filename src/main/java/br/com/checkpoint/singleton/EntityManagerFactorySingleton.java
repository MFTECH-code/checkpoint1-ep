package br.com.checkpoint.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	private static EntityManagerFactory factory;
	
	private EntityManagerFactorySingleton() {
		super();
	}
	
	public static EntityManagerFactory getInstance(String client) {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(client);
		}
		
		return factory;
	}
}
