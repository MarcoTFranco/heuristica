package com.desafio.heuristicas.coesaobasica.validarequest.v1;

public class Estado {

	private String nome;
	private Pais pais;

	public Estado(String nome, Pais pais) {
		super();
		this.nome = nome;
		this.pais = pais;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}

	public boolean pertence(Pais pais) {
		return this.pais.equals(pais);
	}
}
