package br.com.checkpoint.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.checkpoint.dao.AtuacaoDao;
import br.com.checkpoint.entities.Atuacao;
import br.com.checkpoint.entities.Funcao;
import br.com.checkpoint.impl.AtuacaoImpl;
import br.com.checkpoint.singleton.EntityManagerFactorySingleton;

@SuppressWarnings("all")
public class AtuacaoTest {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance("CLIENTE_ORACLE");
		
		EntityManager em = fabrica.createEntityManager();
		
		
		AtuacaoDao dao = new AtuacaoImpl(em);
		
		Atuacao atuacao = new Atuacao(Funcao.CIVIL, "ola");
		
		try {
			dao.insert(atuacao);
			dao.commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Atuacao busca = dao.find(9L);
			System.out.println(busca.getFunction());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			atuacao.setFunction(Funcao.COMPUTACAO);
			dao.update(atuacao);
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
