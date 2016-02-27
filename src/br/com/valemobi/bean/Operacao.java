package br.com.valemobi.bean;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;*/

//@Entity
//@Table(name="T_TDM_OPERACAO")
public class Operacao {

	//@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//@Column(name="CD_OPERACAO")
	private int codigoOp;
	
	//@Column(name="QT_PRODUTOS")
	private int quantidade;
	
	//@Enumerated(EnumType.STRING)
	//@Column(name="NM_TIPO_NEGOCIO")
	private TipoNegocio tipoNegocio;
	
	//@Column(name="CD_MERCADORIA")
	private int codigoMerc;
	
	//@Enumerated(EnumType.STRING)
	//@Column(name="NM_TIPO_MERCADORIA")
	private TipoMercadoria tipoMercadoria;

	//@Column(name="NM_MERCADORIA")
	private String nomeMerc;
	
	//@Column(name="VL_TOTAL")
	private double precoTotal;

	public TipoNegocio getTipoNegocio() {
		return tipoNegocio;
	}

	public void setTipoNegocio(TipoNegocio tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}
	
	public void setPrecoTotal(double precoTotal){
		this.precoTotal = precoTotal;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public int getCodigoOp() {
		return codigoOp;
	}

	public void setCodigoOp(int codigo) {
		this.codigoOp = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getCodigoMerc() {
		return codigoMerc;
	}

	public void setCodigoMerc(int codigoMerc) {
		this.codigoMerc = codigoMerc;
	}

	public TipoMercadoria getTipoMercadoria() {
		return tipoMercadoria;
	}

	public void setTipoMercadoria(TipoMercadoria tipoMercadoria) {
		this.tipoMercadoria = tipoMercadoria;
	}

	public String getNomeMerc() {
		return nomeMerc;
	}

	public void setNomeMerc(String nome) {
		this.nomeMerc = nome;
	}
}
