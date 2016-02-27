package br.com.valemobi.bo;

import java.sql.SQLException;

import br.com.valemobi.bean.Operacao;
import br.com.valemobi.dao.DAOFactory;
import br.com.valemobi.dao.TipoBanco;
import br.com.valemobi.dao.interfaces.OperacaoDAO;

public class OperacoesBO {

	public void registrarOperacao(Operacao op) throws SQLException, Exception{
		DAOFactory fc = DAOFactory.getFactory(TipoBanco.MYSQL);
		OperacaoDAO daoOp = fc.getOperacaoDAO();
		
		if(checarOperacao(op)){
			throw new Exception("Operacao invalida, parametros indevidos.");
		}
		
		
		daoOp.cadastrar(op);
	}
	
	private boolean checarOperacao(Operacao op){
		if(op.getCodigoMerc() == 0 || op.getQuantidade() == 0)
			return true;
		
		if(op.getNomeMerc() == null)
			return true;
		
		if(op.getPrecoTotal() == 0.0d)
			return true;
		
		if(op.getTipoMercadoria() == null || op.getTipoNegocio() == null)
			return true;
		
		return false;
	}
}
