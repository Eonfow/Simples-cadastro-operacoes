package br.com.valemobi.bean;

public class RespostaRegistroOperacao {
	
	public RespostaRegistroOperacao(){
		cadastro = true;
		text = "Sucesso na operacao!";
	}

	private boolean cadastro;
	private String text;
	
	public boolean isCadastro() {
		return cadastro;
	}
	public void setCadastro(boolean cadastro) {
		this.cadastro = cadastro;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
