package br.com.checkpoint.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.checkpoint.dao.ConstrutoraDao;
import br.com.checkpoint.entities.Cliente;
import br.com.checkpoint.entities.Construtora;
import br.com.checkpoint.impl.ConstrutoraImpl;
import br.com.checkpoint.singleton.EntityManagerFactorySingleton;

public class RelacionamentoConstrutoraCliente {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		ConstrutoraDao dao = new ConstrutoraImpl(em);
		
		try {
			Construtora construtora = new Construtora("114463124", "CAMPO ALTO E MINAS");
			Cliente cliente1 = new Cliente("Wesley", "43279245800", "11962019712", "wesleyrr2015@gmail.com");
			Cliente cliente2 = new Cliente("Matheus", "14342312412", "11990002011", "matheus@email.com");
			
			construtora.addCliente(cliente1);
			construtora.addCliente(cliente2);
			
			dao.insert(construtora);
			
			// Removendo a construtora, também serão removidos os clientes ligados a ela.
			//dao.remove(1L);
			
			// Selecionando uma construtora
			Construtora construtoraSelect = dao.find(1L);
			System.out.println(construtoraSelect);
			
			dao.commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
		em.close();
		fabrica.close();

	}

}
