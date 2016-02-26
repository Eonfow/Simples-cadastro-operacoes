package br.com.valemobi.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_TDM_Usuario")
@SequenceGenerator(name="seqUsuario", sequenceName="SEQ_USUARIO", allocationSize=1)
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqUsuario")
	@Column(name="CD_USUARIO")
	private int codigo;
	
	@Column(name="NM_USUARIO")
	private String nome;
	
	@Column(name="DS_LOGIN", unique=true)
	private String login;
	
	@Column(name="DS_SENHA")
	private String senha;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
