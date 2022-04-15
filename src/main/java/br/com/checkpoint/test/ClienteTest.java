package br.com.checkpoint.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.checkpoint.dao.ClienteDao;
import br.com.checkpoint.entities.Cliente;
import br.com.checkpoint.impl.ClienteImpl;
import br.com.checkpoint.singleton.EntityManagerFactorySingleton;

public class ClienteTest {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance("CLIENTE_ORACLE");
		
		EntityManager em = fabrica.createEntityManager();
		
		ClienteDao dao = new ClienteImpl(em);
		
		Cliente cliente = new Cliente("Wesley", "43279245800", "11962019712", "wesleyrr2015@gmail.com");
		
		try {
			dao.insert(cliente);
			dao.commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Cliente busca = dao.find(9L);
			System.out.println(busca.getClient());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			cliente.setClient("Mario");
			dao.update(cliente);
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
