package br.com.valemobi.dao.interfaces;

import br.com.valemobi.bean.Mercadoria;

public interface MercadoriaDAO {

	public void cadastrar(Mercadoria obj);
	
	public Mercadoria selecionar(int codigo);
	
	public void atualizar(int codigo, Mercadoria obj);
	
	public void deletar(int codigo);
}
