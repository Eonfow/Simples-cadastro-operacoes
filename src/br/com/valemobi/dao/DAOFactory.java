package br.com.valemobi.dao;

import br.com.valemobi.dao.impl.OracleMercadoriaDAO;
import br.com.valemobi.dao.impl.OracleOperacaoDAO;
import br.com.valemobi.dao.impl.OracleUsuarioDAO;
import br.com.valemobi.dao.interfaces.MercadoriaDAO;
import br.com.valemobi.dao.interfaces.OperacaoDAO;
import br.com.valemobi.dao.interfaces.UsuarioDAO;

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
	
	public MercadoriaDAO getMercadoriaDAO(){
		MercadoriaDAO dao;
		
		switch (tipo) {
		case ORACLE:
			dao = new OracleMercadoriaDAO() ;
			break;
			
		default:
			dao = null;
			break;
		}
		
		return dao;
	}

	public UsuarioDAO getUsuarioDAO(){
		UsuarioDAO dao;
		
		switch (tipo) {
		case ORACLE:
			dao = new OracleUsuarioDAO() ;
			break;
			
		default:
			dao = null;
			break;
		}
		
		return dao;
	}
}
