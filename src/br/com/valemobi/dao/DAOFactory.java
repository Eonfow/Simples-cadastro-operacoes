package br.com.valemobi.dao;

import br.com.valemobi.dao.impl.MySqlOperacaoDAO;
import br.com.valemobi.dao.interfaces.OperacaoDAO;

/**
 * @author Bruno de Moura Ribeiro
 */
public final class DAOFactory {
	
	TipoBanco tipo;
	
	private DAOFactory(){
		
	}
	
	public static DAOFactory getFactory(TipoBanco tipo){
		DAOFactory factory = new DAOFactory();
		factory.tipo = tipo;
		
		return factory;
	}
	
	public OperacaoDAO getOperacaoDAO(){
		OperacaoDAO dao;
		
		switch (tipo) {
		case MYSQL:
			dao = new MySqlOperacaoDAO() ;
			break;
			
		default:
			dao = null;
			break;
		}
		
		return dao;
	}
}
