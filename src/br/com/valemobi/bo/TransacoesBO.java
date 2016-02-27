package br.com.valemobi.bo;

import br.com.valemobi.bean.Operacao;
import br.com.valemobi.dao.DAOFactory;
import br.com.valemobi.dao.TipoBanco;
import br.com.valemobi.dao.interfaces.OperacaoDAO;

public class TransacoesBO {

	public void transacao(Operacao op) throws Exception{
		DAOFactory fc = DAOFactory.getFactory(TipoBanco.MYSQL);
		OperacaoDAO daoOp = fc.getOperacaoDAO();
		
		daoOp.cadastrar(op);	
	}
}
