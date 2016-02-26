package br.com.valemobi.dao;

import br.com.valemobi.dao.impl.OracleOperacaoDAO;
import br.com.valemobi.dao.interfaces.OperacaoDAO;

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
		case ORACLE:
			dao = new OracleOperacaoDAO() ;
			break;
			
		default:
			dao = null;
			break;
		}
		
		return dao;
	}

}
