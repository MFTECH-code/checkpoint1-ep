package br.com.checkpoint.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.checkpoint.singleton.EntityManagerFactorySingleton;

public class TestConnection {

	public static void main(String[] args) {
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance("CLIENTE_ORACLE");
		EntityManager em = factory.createEntityManager();

		
		em.clear();
	}

}
