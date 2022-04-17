package br.com.checkpoint.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.checkpoint.dao.EngenheiroDao;
import br.com.checkpoint.entities.Engenheiro;
import br.com.checkpoint.impl.EngenheiroImpl;
import br.com.checkpoint.singleton.EntityManagerFactorySingleton;

public class EngenheiroTest {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance("CLIENTE_ORACLE");
		
		EntityManager em = fabrica.createEntityManager();
		
		
		EngenheiroDao dao = new EngenheiroImpl(em);
		
		Engenheiro engenheiro = new Engenheiro("Wesley", "3213712938", 21);
		
		try {
			dao.insert(engenheiro);
			dao.commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Engenheiro busca = dao.find(9L);
			System.out.println(busca.getName());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			engenheiro.setName("Mario");
			dao.update(engenheiro);
			dao.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dao.remove(3L);
			dao.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		em.close();
		fabrica.close();
	}
}
