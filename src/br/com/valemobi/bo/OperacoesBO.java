package br.com.valemobi.bo;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.valemobi.bean.Operacao;
import br.com.valemobi.dao.DAOFactory;
import br.com.valemobi.dao.TipoBanco;
import br.com.valemobi.dao.interfaces.OperacaoDAO;

/**
 * @author Bruno de Moura Ribeiro
 */
public class OperacoesBO {

	private static final Logger log = LoggerFactory.getLogger(OperacoesBO.class);
	
	public void registrarOperacao(Operacao op) throws SQLException, Exception{
		DAOFactory fc = DAOFactory.getFactory(TipoBanco.MYSQL);
		OperacaoDAO daoOp = fc.getOperacaoDAO();
		
		if(checarOperacao(op)){
			throw new Exception("Operacao invalida, parametros indevidos.");
		}
		
		
		daoOp.cadastrar(op);
	}
	
	private boolean checarOperacao(Operacao op){
		if(op.getCodigoMerc() == 0){
			log.warn("Codigo da mercadoria invalido: " + op.getCodigoMerc());
			return true;
		}
		
		if(op.getQuantidade() == 0){
			log.warn("Quantidade invalida: " + op.getQuantidade());
			return true;
		}
		
		if(op.getNomeMerc() == null){
			log.warn("Nome da mercadoria invalido: " + op.getNomeMerc());
			return true;
		}
		
		if(op.getPrecoTotal() == 0.0d){
			log.warn("Preco da mercadoria invalido: " + op.getPrecoTotal());
			return true;
		}
		
		if(op.getTipoNegocio() == null){
			log.warn("Tipo negocio invalido: " + op.getTipoNegocio().toString());
			return true;
		}
		
		if(op.getTipoMercadoria() == null){
			log.warn("Tipo da mercadoria invalido: " + op.getTipoMercadoria().toString());
			return true;
		}
		
		return false;
	}
}
