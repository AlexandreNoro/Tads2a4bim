package br.univel.cadastro.model;

public class Cliente {

	private int id;
	private String nome;
	private String enderešo;
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

	public String getEnderešo() {
		return enderešo;
	}

	public void setEnderešo(String enderešo) {
		this.enderešo = enderešo;
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
		this.enderešo = endereco;
		this.telefone = telefone;
		this.cidade = cidade;
		this.uf = uf;
	}
	
	public Cliente (int id){
		super();
		this.id = id;
	}
	
	
	
	public String toString(){
		return "Cliente[ " + this.nome + ", " + this.enderešo + ", "
				+ this.telefone + ", " + this.cidade + ", " + this.uf.getNome() + "] \n";
	}

}
