package br.com.valemobi.dao.interfaces;

import br.com.valemobi.bean.Operacao;

public interface OperacaoDAO{

	public void cadastrar(Operacao obj);
	
	public Operacao selecionar(int codigo);
	
	public void atualizar(int codigo, Operacao obj);
	
	public void deletar(int codigo);
}
