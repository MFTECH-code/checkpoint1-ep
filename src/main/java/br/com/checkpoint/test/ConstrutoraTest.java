package br.com.checkpoint.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.checkpoint.dao.ConstrutoraDao;
import br.com.checkpoint.entities.Construtora;
import br.com.checkpoint.impl.ConstrutoraImpl;
import br.com.checkpoint.singleton.EntityManagerFactorySingleton;

public class ConstrutoraTest {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance("CLIENTE_ORACLE");

		EntityManager em = fabrica.createEntityManager();

		ConstrutoraDao dao = new ConstrutoraImpl(em);

		Construtora construtora = new Construtora("31321212332", "RL Construtora");

		try {
			dao.insert(construtora);
			dao.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			Construtora busca = dao.find(9L);
			System.out.println(busca.getConstrutora());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			construtora.setConstrutora("Construtora B");
			dao.update(construtora);
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
