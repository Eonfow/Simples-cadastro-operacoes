package br.com.valemobi.bo;

import br.com.valemobi.bean.Mercadoria;
import br.com.valemobi.bean.Operacao;
import br.com.valemobi.bean.Usuario;
import br.com.valemobi.dao.DAOFactory;
import br.com.valemobi.dao.TipoBanco;
import br.com.valemobi.dao.interfaces.MercadoriaDAO;
import br.com.valemobi.dao.interfaces.OperacaoDAO;
import br.com.valemobi.dao.interfaces.UsuarioDAO;

public class TransacoesBO {

	public void cadastrarMercadoria(Mercadoria merc){
		DAOFactory fc = DAOFactory.getFactory(TipoBanco.ORACLE);
		
		MercadoriaDAO dao = fc.getMercadoriaDAO();
		dao.cadastrar(merc);
	}
	
	public void transacao(Operacao op) throws Exception{
		Usuario novoDono = op.getNovoDono();
		if(novoDono.getCarteira() < op.getPrecoTotal())
			throw new Exception("Dinheiro insuficiente");
		
		DAOFactory fc = DAOFactory.getFactory(TipoBanco.ORACLE);
		
		MercadoriaDAO daoMerc = fc.getMercadoriaDAO();
		OperacaoDAO daoOp = fc.getOperacaoDAO();
		UsuarioDAO daoUser = fc.getUsuarioDAO();
		
		
		Mercadoria merc = op.getMercadoria();
		Usuario velhoDono = merc.getDono();
		merc.setDono(novoDono);
		
		daoMerc.atualizar(merc.getCodigo(), merc);		
		daoOp.cadastrar(op);
		
		velhoDono.setCarteira(velhoDono.getCarteira() + op.getPrecoTotal());
		novoDono.setCarteira(novoDono.getCarteira() - op.getPrecoTotal());
		
		daoUser.atualizar(velhoDono.getCodigo(), velhoDono);
		daoUser.atualizar(novoDono.getCodigo(), novoDono);		
	}
}
