package br.com.valemobi.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.valemobi.bean.Operacao;
import br.com.valemobi.dao.interfaces.OperacaoDAO;

public class OracleOperacaoDAO implements OperacaoDAO{
	
	private static final Logger log = 
			LoggerFactory.getLogger(OracleOperacaoDAO.class);

	@Override
	public void cadastrar(Operacao obj) {
		log.info("Cadastrando operacao de " + obj.getTipoNegocio().toString());
		log.info("Comecando conexao...");
		
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		EntityManager em = fabrica.createEntityManager();

		em.getTransaction().begin();
		
		em.persist(obj);
		em.getTransaction().commit();
		log.info("Operacao cadastrada!");
		
		log.info("Fechando conexao");
		em.close();
		fabrica.close();
		log.info("Conexao fechada com sucesso");
	}

	@Override
	public Operacao selecionar(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(int codigo, Operacao obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int codigo) {
		//TODO
	}

}
