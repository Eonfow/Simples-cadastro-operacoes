package br.com.valemobi.teste;

import br.com.valemobi.bean.Operacao;
import br.com.valemobi.bean.TipoMercadoria;
import br.com.valemobi.bean.TipoNegocio;
import br.com.valemobi.dao.DAOFactory;
import br.com.valemobi.dao.TipoBanco;
import br.com.valemobi.dao.interfaces.OperacaoDAO;

public class TesteOperacaoDao {

	public static void main(String[] args) {
		Operacao op = new Operacao();
		
		op.setCodigoMerc(01234);
		op.setNomeMerc("Teste");
		op.setPrecoTotal(100.50);
		op.setQuantidade(2);
		op.setTipoMercadoria(TipoMercadoria.CAMISA);
		op.setTipoNegocio(TipoNegocio.COMPRA);
		
		DAOFactory fc = DAOFactory.getFactory(TipoBanco.MYSQL);
		OperacaoDAO daoOp = fc.getOperacaoDAO();
		
		daoOp.cadastrar(op);	
	}

}
