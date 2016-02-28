package br.com.valemobi.dao.interfaces;

import java.sql.SQLException;

import br.com.valemobi.bean.Operacao;

/**
 * @author Bruno de Moura Ribeiro
 */
public interface OperacaoDAO{

	public void cadastrar(Operacao obj) throws SQLException;
	
	public Operacao selecionar(int codigo) throws SQLException;
	
	public void atualizar(int codigo, Operacao obj) throws SQLException;
	
	public void deletar(int codigo) throws SQLException;
}
