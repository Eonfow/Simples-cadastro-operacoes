package br.com.valemobi.bo;

import br.com.valemobi.bean.Usuario;
import br.com.valemobi.dao.DAOFactory;
import br.com.valemobi.dao.TipoBanco;
import br.com.valemobi.dao.interfaces.UsuarioDAO;

public class LoginBO {
	
	public void cadastrar(Usuario u){
		DAOFactory fc = DAOFactory.getFactory(TipoBanco.ORACLE);

		UsuarioDAO dao = fc.getUsuarioDAO();
		dao.cadastrar(u);
	}
	
	public Usuario login(int codigo){
		DAOFactory fc = DAOFactory.getFactory(TipoBanco.ORACLE);
		
		UsuarioDAO dao = fc.getUsuarioDAO();
		
		Usuario user = dao.selecionar(codigo);
		
		return user;
	}

}
