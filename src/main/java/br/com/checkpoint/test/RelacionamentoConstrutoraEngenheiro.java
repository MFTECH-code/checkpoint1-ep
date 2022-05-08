package br.com.checkpoint.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.checkpoint.dao.ConstrutoraDao;
import br.com.checkpoint.entities.Construtora;
import br.com.checkpoint.entities.Engenheiro;
import br.com.checkpoint.exceptions.TransactionException;
import br.com.checkpoint.impl.ConstrutoraImpl;
import br.com.checkpoint.singleton.EntityManagerFactorySingleton;

public class RelacionamentoConstrutoraEngenheiro {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		ConstrutoraDao dao = new ConstrutoraImpl(em);
		
		
		try {
			Construtora construtora = new Construtora("1123463234", "BOB'S CONSTRUTORA");
			Engenheiro egenheiro1 = new Engenheiro("Bob", "1234", 35, construtora);
			Engenheiro egenheiro2 = new Engenheiro("Marcio", "4321", 30, construtora);
			
			construtora.addEngenheiro(egenheiro1);
			construtora.addEngenheiro(egenheiro2);
			
			dao.insert(construtora);
			
			// Removendo a construtora, também serão removidos os engenheiros ligados a ela.
			//dao.remove(1L);
			dao.commit();
			
			Construtora construtoraSelect = dao.find(1L);
			System.out.println(construtoraSelect);
			construtoraSelect.getEngenheiros().forEach(e -> System.out.println(e));
			
		} catch(TransactionException tex) {
			System.out.println(tex.getLocalizedMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {			
			em.close();
			fabrica.close();
		}
		
	}

}
