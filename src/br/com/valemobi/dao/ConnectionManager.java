package br.com.valemobi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe geranciadora de conexao com o banco de dados.
 * @author Bruno de Moura Ribeiro
 * @version 1.0
 */
public class ConnectionManager {
	
	private DataSource ds = null;
	private static ConnectionManager single = null;
	private static final Logger log = LoggerFactory.getLogger(ConnectionManager.class);
	
	/**
	 * Cria o DataSource
	 * @throws NamingException
	 */
	private ConnectionManager() throws NamingException{
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		ds = (DataSource)envContext.lookup("jdbc/ConnectionPool");
	}
	
	/**
	 * Cria conexao para testes
	 */
	private static Connection connectBackUp() throws SQLException{
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			log.error("Erro: Driver nao encontrado");
		}		
		
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://mysqlinstance.cz131oanqrih.sa-east-1.rds.amazonaws.com:3306/innodb", 
					"rm73930", 
					"Ps776724"
			);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			log.error("Erro ao criar conexao");
			log.error(e.getMessage());
			throw new SQLException(e);
		}
		
		return conn;
	}

	/**
	 * Retorna uma conexao com o banco
	 * @return conexao sql
	 * @throws SQLException caso haja erro ao criar conexao
	 */
	public static Connection getConnection() throws SQLException {
		
		if(single == null || single.ds == null){
			try {
				single = new ConnectionManager();
			} catch (NamingException e) {
				log.error("O DataSource nao foi encontrado retornando backup!");
				return connectBackUp();
			}
		}
	
		try{
			return single.ds.getConnection();		
		}
		catch (SQLException e) {
			log.error("Erro ao obter a conexão com banco de dados");
			throw new SQLException(e);
		}
		
	}

}