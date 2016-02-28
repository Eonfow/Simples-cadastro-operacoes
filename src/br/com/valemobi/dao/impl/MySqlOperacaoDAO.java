package br.com.valemobi.dao.impl;

/*import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.valemobi.bean.Operacao;
import br.com.valemobi.dao.ConnectionManager;
import br.com.valemobi.dao.interfaces.OperacaoDAO;

/**
 * Implementacao MySql para alteracoes de persistencia em Operacao
 * @author Bruno de Moura Ribeiro
 * @version 2.0
 */
public class MySqlOperacaoDAO implements OperacaoDAO{
	
	private static final Logger log = 
			LoggerFactory.getLogger(MySqlOperacaoDAO.class);
	
	/**
	 * Ordem:
	 * 1. QT_PRODUTOS
	 * 2. NM_TIPO_NEGOCIO
 	 * 3. CD_MERCADORIA
 	 * 4. NM_TIPO_MERCADORIA
 	 * 5. NM_MERCADORIA
 	 * 6. VL_TOTAL
	 */
	private PreparedStatement PStmt;//ORM nao tava funcionando :(
	
	private String insertStmt = "INSERT INTO T_TDM_OPERACAO "
			+ "(QT_PRODUTOS, NM_TIPO_NEGOCIO, CD_MERCADORIA, NM_TIPO_MERCADORIA, NM_MERCADORIA, VL_TOTAL) "
			+ "VALUES(?, ?, ?, ?, ?, ?)";

	/**
	 * Cadastra nova Operacao no banco
	 * @param Operacao a ser registrada
	 * @throws SQLException caso ocorra um erro ao persistir dados
	 */
	@Override
	public void cadastrar(Operacao obj) throws SQLException{
		log.info("Cadastrando Operacao de " + obj.getTipoNegocio().toString());
		log.info("Comecando conexao...");
		
		Connection conn;
		try{
			conn = ConnectionManager.getConnection();
		}catch(SQLException e){
			throw new SQLException(e);
		}
		
		try{
			PStmt = conn.prepareStatement(insertStmt);
			
			PStmt.setInt(1, obj.getQuantidade());
			PStmt.setString(2, obj.getTipoNegocio().toString());
			PStmt.setInt(3, obj.getCodigoMerc());
			PStmt.setString(4, obj.getTipoMercadoria().toString());
			PStmt.setString(5, obj.getNomeMerc());
			PStmt.setDouble(6, obj.getPrecoTotal());
		}catch(SQLException e){
			log.error("Erro ao criar sql para inserir operacao");
			throw new SQLException("INSERT Operacao");
		}
		
		try {
			PStmt.executeUpdate();
		} catch (SQLException e) {
			log.error("Erro ao inserir Operacao");
			throw new SQLException("INSERT Operacao");
		}		
		try {
			conn.commit();
		} catch (Exception e) {
			log.warn(e.getMessage());
		}
		log.info("Operacao cadastrada!");
		
		log.info("Fechando conexao");		
		PStmt.close();		
		conn.close();
		log.info("Conexao fechada com sucesso");
	}

	@Override
	public Operacao selecionar(int codigo) throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(int codigo, Operacao obj) throws SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int codigo) throws SQLException{
		//TODO
	}

}
