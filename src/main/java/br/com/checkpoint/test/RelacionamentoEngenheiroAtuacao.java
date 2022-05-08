package br.com.checkpoint.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.checkpoint.dao.ConstrutoraDao;
import br.com.checkpoint.entities.Atuacao;
import br.com.checkpoint.entities.Cliente;
import br.com.checkpoint.entities.Construtora;
import br.com.checkpoint.entities.Engenheiro;
import br.com.checkpoint.entities.Funcao;
import br.com.checkpoint.entities.Projeto;
import br.com.checkpoint.exceptions.TransactionException;
import br.com.checkpoint.impl.ConstrutoraImpl;
import br.com.checkpoint.singleton.EntityManagerFactorySingleton;

public class RelacionamentoEngenheiroAtuacao {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		ConstrutoraDao dao = new ConstrutoraImpl(em);
		
		
		try {
			Construtora construtora = new Construtora("1123463234", "BOB'S CONSTRUTORA");
			Engenheiro egenheiro1 = new Engenheiro("Bob", "1234", 35, construtora, new Atuacao(Funcao.CIVIL, "Construção civil"));
			Engenheiro egenheiro2 = new Engenheiro("Marcio", "4321", 30, construtora, new Atuacao(Funcao.CIVIL, "Construção civil"));
			Cliente cliente1 = new Cliente("Wesley", "43279245800", "11962019712", "wesleyrr2015@gmail.com");
			Cliente cliente2 = new Cliente("Matheus", "14342312412", "11990002011", "matheus@email.com");
			Projeto p1 = new Projeto("Estadio Vasco", LocalDate.of(2022, 11, 4), LocalDate.of(2077, 12, 25));
			Projeto p2 = new Projeto("Predio", LocalDate.of(2022, 11, 4), LocalDate.of(2077, 12, 25));
			
			
			List<Projeto> projetos = new ArrayList<Projeto>();
			projetos.add(p1);
			projetos.add(p2);
	
			
			egenheiro1.setProjetos(projetos);
			egenheiro2.setProjetos(projetos);
			
			construtora.addCliente(cliente1);
			construtora.addCliente(cliente2);
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
			tex.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {			
			em.close();
			fabrica.close();
		}
	}

}
