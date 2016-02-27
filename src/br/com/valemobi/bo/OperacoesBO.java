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
		
		daoOp.cadastrar(op);
	}
}
