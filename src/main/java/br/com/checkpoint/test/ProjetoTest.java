package br.com.checkpoint.test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.checkpoint.dao.ProjetoDao;
import br.com.checkpoint.entities.Projeto;
import br.com.checkpoint.impl.ProjetoImpl;
import br.com.checkpoint.singleton.EntityManagerFactorySingleton;

public class ProjetoTest {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance("CLIENTE_ORACLE");
		
		EntityManager em = fabrica.createEntityManager();
		
		
		ProjetoDao dao = new ProjetoImpl(em);
		
		Projeto projeto = new Projeto("Dim Dim",LocalDate.of(2010, 10, 5), LocalDate.of(2010, 12, 10));
		
		try {
			dao.insert(projeto);
			dao.commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Projeto busca = dao.find(9L);
			System.out.println(busca.getName());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			projeto.setName("Projeto Alfa");
			dao.update(projeto);
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
