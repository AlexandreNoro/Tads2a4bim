package br.univel.cadastro.model;

public class Cliente {

	private int id;
	private String nome;
	private String endereço;
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

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
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
		this.endereço = endereco;
		this.telefone = telefone;
		this.cidade = cidade;
		this.uf = uf;
	}
	
	public Cliente (int id){
		super();
		this.id = id;
	}
	
	
	
	public String toString(){
		return "Cliente[ " + this.nome + ", " + this.endereço + ", "
				+ this.telefone + ", " + this.cidade + ", " + this.uf.getNome() + "] \n";
	}

}
