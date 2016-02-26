package br.com.valemobi.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_TDM_MERCADORIA")
@SequenceGenerator(name="seqMercadoria", sequenceName="SEQ_MERCADORIA", allocationSize=1)
public class Mercadoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqMercadoria")
	@Column(name="CD_MERCADORIA")
	private int codigo;
	
	@Enumerated(EnumType.STRING)
	private TipoMercadoria tipoMercadoria;

	@Column(name="NM_MERCADORIA")
	private String nome;
	
	@Column(name="VL_PRECO_MERCADORIA")
	private double preco;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public TipoMercadoria getTipoMercadoria() {
		return tipoMercadoria;
	}

	public void setTipoMercadoria(TipoMercadoria tipoMercadoria) {
		this.tipoMercadoria = tipoMercadoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
