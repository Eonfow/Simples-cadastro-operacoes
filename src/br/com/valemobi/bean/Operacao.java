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
@Table(name="T_TDM_OPERACAO")
@SequenceGenerator(name="seqTransacao", sequenceName="SEQ_TRANSACAO", allocationSize=1)
public class Operacao {
	
	public Operacao(int quantidade, Mercadoria mercadoria, TipoNegocio tipoNegocio, Usuario novoDono) {
		super();
		this.quantidade = quantidade;
		this.mercadoria = mercadoria;
		this.tipoNegocio = tipoNegocio;
		this.setNovoDono(novoDono);

		calcularPrecoTotal();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqTransacao")
	@Column(name="CD_TRANSACAO")
	private int codigo;
	
	@Column(name="CD_NOVO_DONO")
	private Usuario novoDono;
	
	@Column(name="NR_PRODUTOS")
	private int quantidade;
	
	@Column(name="CD_MERCADORIA")
	private Mercadoria mercadoria;
	
	@Enumerated(EnumType.STRING)
	private TipoNegocio tipoNegocio;
	
	@Column(name="VL_TOTAL")
	private double precoTotal;

	public TipoNegocio getTipoNegocio() {
		return tipoNegocio;
	}

	public void setTipoNegocio(TipoNegocio tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}
	
	private void calcularPrecoTotal(){
		precoTotal = mercadoria.getPreco() * quantidade;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Mercadoria getMercadoria() {
		return mercadoria;
	}

	public void setMercadoria(Mercadoria mercadoria) {
		if(mercadoria != null && quantidade > 0)
			calcularPrecoTotal();
		
		this.mercadoria = mercadoria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		if(mercadoria != null && quantidade > 0)
			calcularPrecoTotal();
		
		this.quantidade = quantidade;
	}

	public Usuario getNovoDono() {
		return novoDono;
	}

	public void setNovoDono(Usuario novoDono) {
		this.novoDono = novoDono;
	}
}
