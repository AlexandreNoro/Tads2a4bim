package br.univel.cadastro.model;

public class Cliente {

	private int id;
	private String nome;
	private String endere�o;
	private String telefone;
	private String cidade;
	private Uf uf;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndere�o() {
		return endere�o;
	}

	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}
	
	public Cliente (int id, String nome, String endereco, String telefone, String cidade, Uf uf){
		
		super();
		this.id = id;
		this.nome = nome;
		this.endere�o = endereco;
		this.telefone = telefone;
		this.cidade = cidade;
		this.uf = uf;
	}
	
	public Cliente (int id){
		super();
		this.id = id;
	}
	
	
	
	public String toString(){
		return "Cliente[ " + this.nome + ", " + this.endere�o + ", "
				+ this.telefone + ", " + this.cidade + ", " + this.uf.getNome() + "] \n";
	}

}
