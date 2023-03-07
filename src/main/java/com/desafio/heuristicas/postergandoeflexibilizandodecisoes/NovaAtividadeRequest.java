package com.desafio.heuristicas.postergandoeflexibilizandodecisoes;

public class NovaAtividadeRequest {

	private String texto;

	public NovaAtividadeRequest(String texto) {
		super();
		this.texto = texto;
	}

	public Atividade toAtividade() {
		return new Atividade(texto);
	}

}
