package br.com.valemobi.testes;

import br.com.valemobi.bean.Usuario;
import br.com.valemobi.dao.DAOFactory;
import br.com.valemobi.dao.TipoBanco;
import br.com.valemobi.dao.interfaces.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		UsuarioDAO dao = DAOFactory.getFactory(TipoBanco.ORACLE).getUsuarioDAO();
		
		Usuario obj = new Usuario();
		obj.setLogin("teste1");
		obj.setSenha("teste1");
		obj.setNome("teste1");
		
		dao.cadastrar(obj);
		
		Usuario obj2 = dao.selecionar(1);
		
		System.out.println(obj2.getNome());
	}
}
