package br.com.valemobi.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.valemobi.bean.Usuario;
import br.com.valemobi.dao.interfaces.UsuarioDAO;

public class OracleUsuarioDAO implements UsuarioDAO {
	
	private static final Logger log = 
			LoggerFactory.getLogger(OracleUsuarioDAO.class);

	@Override
	public void cadastrar(Usuario obj) {
		log.info("Cadastrando novo usuario");
		log.info("Comecando conexao...");
		
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		EntityManager em = fabrica.createEntityManager();

		em.getTransaction().begin();
		
		em.persist(obj);
		em.getTransaction().commit();
		log.info("Usuario cadastrado!");
		
		log.info("Fechando conexao");
		em.close();
		fabrica.close();
		log.info("Conexao fechada com sucesso");
	}

	@Override
	public Usuario selecionar(int codigo) {
		log.info("Procurando usuario");
		log.info("Comecando conexao...");
		
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		EntityManager em = fabrica.createEntityManager();

		em.getTransaction().begin();
		
		Usuario u = em.find(Usuario.class, codigo);

		log.info("Usuario localizado!");
		
		log.info("Fechando conexao");
		em.close();
		fabrica.close();
		log.info("Conexao fechada com sucesso");
		
		return u;
	}

	@Override
	public void atualizar(int codigo, Usuario obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar(int codigo) {
		// TODO Auto-generated method stub

	}

}
