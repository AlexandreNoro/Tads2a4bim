package br.univel.cadastro.model;

public enum Uf {

	PR("Paraná"), SP("São Paulo"), SC("Santa Catarina");

	private String nome;

	public String getNome() {
		return nome;
	}

	private Uf(String nome) {
		this.nome = nome;
	}

	public Uf validar(Object obj){
		if (obj.toString().equals(PR.nome)) 
			return Uf.PR;
		else if(obj.toString().equals(SP.nome))
			return Uf.SP;
		else if(obj.toString().equals(SC.nome))
			return Uf.SC;
		
		return null;
		
	}
	
}
