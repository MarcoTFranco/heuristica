package com.desafio.heuristicas.coesaobasica.validarequest.v1;

import java.util.Objects;

public class Pais {

	private String nome;

	public Pais(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pais pais = (Pais) o;
		return nome.equals(pais.nome);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
}
