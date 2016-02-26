package br.com.valemobi.dao.interfaces;

import br.com.valemobi.bean.Usuario;

public interface UsuarioDAO {

	public void cadastrar(Usuario obj);
	
	public Usuario selecionar(int codigo);
	
	public void atualizar(int codigo, Usuario obj);
	
	public void deletar(int codigo);
}
