package br.com.checkpoint.test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.checkpoint.dao.ProjetoDao;
import br.com.checkpoint.entities.Projeto;
import br.com.checkpoint.exceptions.TransactionException;
import br.com.checkpoint.impl.ProjetoImpl;
import br.com.checkpoint.singleton.EntityManagerFactorySingleton;

public class ProjetoTest {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		ProjetoDao dao = new ProjetoImpl(em);
		
		Projeto projeto = new Projeto("Dim Dim", LocalDate.of(2010, 10, 5), LocalDate.of(2010, 12, 10));
		
		try {
			dao.insert(projeto);
			dao.commit();
			Projeto busca = dao.find(1L);
			System.out.println(busca.getName());
			
			//projeto.setName("Projeto Alfa");
			//dao.update(projeto);
			//dao.remove(3L);
		}catch(TransactionException tex) {
			tex.printStackTrace();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {			
			em.close();
			fabrica.close();
		}
	}
	
}
